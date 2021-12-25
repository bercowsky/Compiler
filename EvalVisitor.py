from antlr4 import *
from os import sys
from ExprLexer import ExprLexer

if __name__ is not None and "." in __name__:
    from .ExprParser import ExprParser
    from .ExprVisitor import ExprVisitor
else:
    from ExprParser import ExprParser
    from ExprVisitor import ExprVisitor


class Error:
    def __init__(self, errorName, details):
        self.errorName = errorName
        self.details = details

    def asString(self):
        result = f'{self.errorName}: {self.details}'
        return result


class IllegaCharError(Error):
    def __init__(self, details):
        super().__init__('Illegal Character', details)


class EvalVisitor(ExprVisitor):
    def __init__(self, firstFunc, firstParams):
        self.symbolTable = SymbolTable()
        self.funcDeclarations = FuncDeclarations()
        self.firstFunc = firstFunc
        self.firstParams = firstParams

    def visitRoot(self, ctx):
        l = list(ctx.getChildren())
        i = 0
        while i < len(l):
            if hasattr(
                    l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'func':
                self.visit(l[i])
            i += 1

        mainFunc = 0
        for child in self.funcDeclarations.declarations:
            if child['name'] == self.firstFunc:
                mainFunc = child

        if mainFunc == 0:
            raise Exception('No main function found')

        funcParamNames = self.funcDeclarations.getFuncParams(self.firstFunc, self.firstParams)
        self.symbolTable.createContextWithParams(self.firstParams, funcParamNames)
        for stmt in mainFunc['body']:
            self.visit(stmt)
        self.symbolTable.destroyContext()

    def visitExpr(self, ctx):
        l = list(ctx.getChildren())
        if len(l) == 1:
            if '.' in l[0].getText():
                return float(l[0].getText())

            elif l[0].getText().isnumeric():
                return int(l[0].getText())

            else:
                if hasattr(l[0], 'getRuleIndex') and ExprParser.ruleNames[l[0].getRuleIndex()] == 'getArr':
                    return self.visit(l[0])
                else:
                    return self.symbolTable.findSymbol(l[0].getText())

        else:  # len(l) == 3
            if l[1].getText() == '+':
                return self.visit(l[0]) + self.visit(l[2])

            elif l[1].getText() == '-':
                return self.visit(l[0]) - self.visit(l[2])

            elif l[1].getText() == '*':
                return self.visit(l[0]) * self.visit(l[2])

            elif l[1].getText() == '/':
                divisor = self.visit(l[2])
                if divisor == 0:
                    raise Exception('Division by zero')

                return self.visit(l[0]) / divisor

            elif l[1].getText() == '^':
                return self.visit(l[0]) ** self.visit(l[2])
            
            elif l[1].getText() == '%':
                return self.visit(l[0]) % self.visit(l[2])

            elif l[0].getText() == '(' and l[2].getText() == ')':
                return self.visit(l[1])

            elif l[1].getText() == '<':
                if self.visit(l[0]) < self.visit(l[2]):
                    return 1
                return 0

            elif l[1].getText() == '<=':
                if self.visit(l[0]) <= self.visit(l[2]):
                    return 1
                return 0

            elif l[1].getText() == '>':
                if self.visit(l[0]) > self.visit(l[2]):
                    return 1
                return 0

            elif l[1].getText() == '>=':
                if self.visit(l[0]) >= self.visit(l[2]):
                    return 1
                return 0

            elif l[1].getText() == '==':
                if self.visit(l[0]) == self.visit(l[2]):
                    return 1
                return 0

            elif l[1].getText() == '<>':
                if self.visit(l[0]) != self.visit(l[2]):
                    return 1
                return 0

            else:
                raise Exception('Illegal operator')

    def visitFunc(self, ctx):
        l = list(ctx.getChildren())
        info = {
            'name': l[1].getText(),
            'params': [],
            'body': []
        }
        i = 3
        while i < len(l) and hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'ident':
            info['params'].append(l[i].getText())
            i += 2

        if len(info['params']) > 0:
            i += 1
        else:
            i += 2

        while i < len(l) and hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'stmt':
            info['body'].append(l[i])
            i += 1

        self.funcDeclarations.addFuncInfo(info)

    def visitAssig(self, ctx):
        l = list(ctx.getChildren())
        self.symbolTable.addSymbol(l[0].getText(), self.visit(l[2]))

    def visitWrite(self, ctx):
        l = list(ctx.getChildren())
        i = 2
        while i < len(l) and not (hasattr(l[i], 'getSymbol') and l[i].getSymbol == ExprParser.RPAR):
            if hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'ident':
                print(self.symbolTable.findSymbol(l[i].getText()), end=' ')
            elif hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'expr':
                print(self.visit(l[i]), end=' ')
            elif hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'getArr':
                print(self.visit(l[i]), end=' ')
            else:
                print(l[i].getText().strip('"'), end=' ')
            i += 2
        print()

    def visitRead(self, ctx):
        l = list(ctx.getChildren())
        inp = input()
        if (inp.isnumeric()):
            if '.' in inp:
                self.symbolTable.addSymbol(l[2].getText(), float(inp))
            else:
                self.symbolTable.addSymbol(l[2].getText(), int(inp))

        else:
            self.symbolTable.addSymbol(l[2].getText(), inp)

    def visitStmt(self, ctx):
        l = list(ctx.getChildren())
        if l[0].getText() == 'if':
            cond = self.visit(l[2])
            if cond == 1:
                i = 5
                while i < len(l) and hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'stmt':
                    self.visit(l[i])
                    i += 1
            else:
                i = 5
                while i < len(l) and hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'stmt':
                    i += 1
                if i + 1 < len(l):
                    i += 3
                    while i < len(l) and hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'stmt':
                        self.visit(l[i])
                        i += 1

        elif l[0].getText() == 'for':
            self.visit(l[2])
            while self.visit(l[4]) == 1:
                i = 9
                while i < len(l) and hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'stmt':
                    self.visit(l[i])
                    i += 1
                self.visit(l[6])

        elif l[0].getText() == 'while':
            while self.visit(l[2]) == 1:
                i = 5
                while i < len(l) and hasattr(l[i], 'getRuleIndex') and ExprParser.ruleNames[l[i].getRuleIndex()] == 'stmt':
                    self.visit(l[i])
                    i += 1

        else:
            return self.visit(l[0])

    def visitMethod(self, ctx):
        l = list(ctx.getChildren())
        paramsValues = []
        i = 2
        while i < len(l) and hasattr(l[i], 'getRuleIndex') and (ExprParser.ruleNames[l[i].getRuleIndex(
        )] == 'ident' or ExprParser.ruleNames[l[i].getRuleIndex()] == 'expr'):
            if ExprParser.ruleNames[l[i].getRuleIndex()] == 'ident':
                paramsValues.append(l[i].getText())
            elif ExprParser.ruleNames[l[i].getRuleIndex()] == 'expr':
                paramsValues.append(self.visit(l[i]))
            i += 2

        funcParamNames = self.funcDeclarations.getFuncParams(l[0].getText(), paramsValues)
        self.symbolTable.createContextWithParams(paramsValues, funcParamNames)

        for stmt in self.funcDeclarations.getFuncBody(l[0].getText(), paramsValues):
            self.visit(stmt)

        self.symbolTable.destroyContext()

    def visitArray(self, ctx):
        l = list(ctx.getChildren())
        arr = [0] * self.visit(l[4])
        self.symbolTable.addSymbol(l[2].getText(), arr)

    def visitGetArr(self, ctx):
        l = list(ctx.getChildren())
        # return self.symbolTable.findSymbol(l[2].getText())[self.visit(l[4])]
        return self.symbolTable.getArrayElem(l[2].getText(), self.visit(l[4]))

    def visitSetArr(self, ctx):
        l = list(ctx.getChildren())
        #self.symbolTable.findSymbol(l[2].getText())[self.visit(l[4])] = self.visit(l[6])
        self.symbolTable.setArrayElem(
            l[2].getText(), self.visit(l[4]), self.visit(l[6]))


class SymbolTable:
    symbols = list()

    @staticmethod
    def createContext():
        emptyDic = dict()
        SymbolTable.symbols.append(emptyDic)

    @staticmethod
    def createContextWithParams(paramsValues, funcParamNames):
        dic = dict()
        for param, paramName in zip(paramsValues, funcParamNames):
            if isinstance(param, int) or isinstance(param, float):
                dic[paramName] = param
            elif isinstance(SymbolTable.findSymbol(param), list):
                dic[paramName] = '*' + str(len(SymbolTable.symbols) - 1)
            else:
                dic[paramName] = SymbolTable.findSymbol(param)

        SymbolTable.symbols.append(dic)

    @staticmethod
    def addSymbol(key, value):
        SymbolTable.symbols[-1][key] = value

    @staticmethod
    def findSymbol(key):
        if key in SymbolTable.symbols[-1]:
            return SymbolTable.symbols[-1][key]

        raise Exception('Variable ' + key + ' not defined')

    @staticmethod
    def setArrayElem(key, index, value):
        if key in SymbolTable.symbols[-1]:
            level = int(SymbolTable.symbols[-1][key].replace('*', ''))
            SymbolTable.symbols[level][key][index] = value
        else:
            raise Exception('Variable ' + key + ' not defined')

    @staticmethod
    def getArrayElem(key, index):
        if key in SymbolTable.symbols[-1]:
            if isinstance(SymbolTable.symbols[-1][key], list):
                level = len(SymbolTable.symbols) - 1
            else:
                level = int(SymbolTable.symbols[-1][key].replace('*', ''))
            return SymbolTable.symbols[level][key][index]

        raise Exception('Variable ' + key + ' not defined')

    @staticmethod
    def destroyContext():
        SymbolTable.symbols.pop()


class FuncDeclarations:
    declarations = list()

    @staticmethod
    def addFuncInfo(info):
        for func in FuncDeclarations.declarations:
            if info['name'] == func['name'] and len(info['params']) == len(func['params']):
                raise Exception('Function ' + info['name'] + ' already defined')

        FuncDeclarations.declarations.append(info)

    @staticmethod
    def getFuncBody(name, params):
        for func in FuncDeclarations.declarations:
            if name == func['name'] and len(params) == len(func['params']):
                return func['body']

        raise Exception('Function not defined')

    @staticmethod
    def getFuncParams(name, params):
        for func in FuncDeclarations.declarations:
            if name == func['name'] and len(params) == len(func['params']):
                return func['params']

        raise Exception('Function not defined')


input_stream = FileStream(sys.argv[1], encoding='utf-8')

func_name = 'main'
if len(sys.argv) > 2:
    func_name = sys.argv[2]

params = []
for i in range(3, len(sys.argv)):
    elem = sys.argv[i]
    if (elem.isnumeric()):
        if '.' in elem:
            params.append(float(elem))
        else:
            params.append(int(elem))

    else:
        params.append(elem)

lexer = ExprLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = ExprParser(token_stream)
tree = parser.root()

visitor = EvalVisitor(func_name, params)
visitor.visit(tree)