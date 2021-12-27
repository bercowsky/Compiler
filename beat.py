from antlr4 import *
from ExprLexer import ExprLexer
from os import sys

if __name__ is not None and "." in __name__:
    from .ExprParser import ExprParser
    from .ExprVisitor import ExprVisitor
else:
    from ExprParser import ExprParser
    from ExprVisitor import ExprVisitor


class Style():
    RED = '\033[38;2;255;89;129m'
    PURPLE = '\033[38;2;187;110;255m'
    BLUE = '\033[38;2;80;130;220m'
    GREEN = '\033[38;2;100;210;100m'
    ORANGE = '\033[38;2;221;162;58m'
    RESET = '\033[0m'


class BeatVisitor(ExprVisitor):
    def __init__(self):
        self.numSpaces = 0

    def checkRuleName(self, l, i, ruleName):
        b = i < len(l) and hasattr(l[i], 'getRuleIndex')
        return b and ExprParser.ruleNames[l[i].getRuleIndex()] == ruleName

# Visitors

    def visitRoot(self, ctx):
        l = list(ctx.getChildren())
        for i in range(0, len(l) - 1):
            print(self.visit(l[i]))
            if self.checkRuleName(l, i + 1, 'func'):
                print()

    def visitExpr(self, ctx):
        l = list(ctx.getChildren())
        code = ''
        if len(l) == 1:
            if l[0].getText().isnumeric():
                return Style.ORANGE + l[0].getText() + Style.RESET

            else:
                if self.checkRuleName(l, 0, 'getArr'):
                    return self.visit(l[0])
                else:
                    return Style.RESET + l[0].getText()

        else:  # len(l) == 3
            if l[0].getText() == '(' and l[2].getText() == ')':
                code += '(' + self.visit(l[1]) + ')'
            else:
                code += self.visit(l[0])
                code += ' ' + Style.RESET + l[1].getText() + ' '
                code += self.visit(l[2])

        return code

    def visitFunc(self, ctx):
        l = list(ctx.getChildren())
        code = ' ' * self.numSpaces
        code += Style.RED + l[0].getText() + ' ' + \
            Style.PURPLE + l[1].getText() + Style.RESET + ' ('
        i = 3
        while self.checkRuleName(l, i, 'ident'):
            code += l[i].getText()
            if l[i + 1].getText() == ',':
                code += ', '
            i += 2

        if i == 3:
            i += 2
        else:
            i += 1

        code += ') {\n'
        self.numSpaces += 4

        while self.checkRuleName(l, i, 'stmt'):
            code += ' ' * self.numSpaces + self.visit(l[i]) + '\n'
            i += 1

        self.numSpaces -= 4
        code += ' ' * self.numSpaces + Style.RESET + '}'
        return code

    def visitAssig(self, ctx):
        l = list(ctx.getChildren())
        code = ''
        code += Style.RESET + l[0].getText() + ' ' + \
            l[1].getText() + ' ' + self.visit(l[2])
        return code

    def visitWrite(self, ctx):
        l = list(ctx.getChildren())
        code = Style.BLUE + l[0].getText() + Style.RESET + '('
        i = 2
        while i < len(l) and (hasattr(l[i], 'getRuleIndex') or (hasattr(l[i], 'getSymbol') and l[i].getSymbol().type == ExprParser.STRING)):
            if hasattr(l[i], 'getSymbol'):
                code += Style.GREEN + l[i].getText() + Style.RESET
            else:
                code += l[i].getText()
            if l[i + 1].getText() == ',':
                code += ', '
            i += 2

        return code + ')'

    def visitRead(self, ctx):
        l = list(ctx.getChildren())
        return Style.BLUE + l[0].getText() + Style.RESET + \
            '(' + l[2].getText() + ')'

    def visitStmt(self, ctx):
        l = list(ctx.getChildren())
        code = ''
        if l[0].getText() == 'if':
            self.numSpaces += 4
            code += Style.RED + l[0].getText() + Style.RESET + \
                ' (' + self.visit(l[2]) + ') {\n'
            i = 5
            while self.checkRuleName(l, i, 'stmt'):
                code += ' ' * self.numSpaces + self.visit(l[i]) + '\n'
                i += 1

            i = 5
            while self.checkRuleName(l, i, 'stmt'):
                i += 1

            if i + 1 < len(l):
                i += 3
                self.numSpaces -= 4
                code += ' ' * self.numSpaces + '}\n'
                code += ' ' * self.numSpaces + Style.RED + 'else' + Style.RESET + ' {\n'
                self.numSpaces += 4
                while self.checkRuleName(l, i, 'stmt'):
                    code += ' ' * self.numSpaces + self.visit(l[i]) + '\n'
                    i += 1
            self.numSpaces -= 4
            code += ' ' * self.numSpaces + Style.RESET + '}'

        elif l[0].getText() == 'for':
            self.numSpaces += 4
            code += Style.RED + l[0].getText() + Style.RESET + ' (' + self.visit(
                l[2]) + '; ' + self.visit(l[4]) + '; ' + self.visit(l[6]) + ') {\n'
            i = 9
            while self.checkRuleName(l, i, 'stmt'):
                code += ' ' * self.numSpaces + self.visit(l[i]) + '\n'
                i += 1

            self.numSpaces -= 4
            code += ' ' * self.numSpaces + Style.RESET + '}'

        elif l[0].getText() == 'while':
            self.numSpaces += 4
            code += Style.RED + l[0].getText() + Style.RESET + \
                ' (' + self.visit(l[2]) + ') {\n'
            i = 5
            while self.checkRuleName(l, i, 'stmt'):
                code += ' ' * self.numSpaces + self.visit(l[i]) + '\n'
                i += 1

            self.numSpaces -= 4
            code += ' ' * self.numSpaces + Style.RESET + '}'
        else:
            return code + self.visit(l[0])
        return code

    def visitMethod(self, ctx):
        l = list(ctx.getChildren())
        code = ''
        code += Style.BLUE + l[0].getText() + Style.RESET + '('
        i = 2
        while i < len(l) and (hasattr(l[i], 'getRuleIndex') or (hasattr(l[i], 'getSymbol') and l[i].getSymbol().type == ExprParser.STRING)):
            if hasattr(l[i], 'getSymbol'):
                code += Style.GREEN + l[i].getText() + Style.RESET
            elif ExprParser.ruleNames[l[i].getRuleIndex()] == 'ident':
                code += l[i].getText()
            else:
                code += self.visit(l[i])
            if l[i + 1].getText() == ',':
                code += ', '
            i += 2

        code += ')'
        return code

    def visitArray(self, ctx):
        l = list(ctx.getChildren())
        return Style.BLUE + l[0].getText() + Style.RESET + \
            '(' + l[2].getText() + ', ' + self.visit(l[4]) + ')'

    def visitGetArr(self, ctx):
        l = list(ctx.getChildren())
        return Style.BLUE + l[0].getText() + Style.RESET + \
            '(' + l[2].getText() + ', ' + self.visit(l[4]) + ')'

    def visitSetArr(self, ctx):
        l = list(ctx.getChildren())
        return Style.BLUE + l[0].getText() + Style.RESET + '(' + l[2].getText() + \
            ', ' + self.visit(l[4]) + ', ' + self.visit(l[6]) + ')'


input_stream = FileStream(sys.argv[1], encoding='utf-8')

lexer = ExprLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = ExprParser(token_stream)
tree = parser.root()

visitor = BeatVisitor()
visitor.visit(tree)
