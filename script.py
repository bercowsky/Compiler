from antlr4 import *
from ExprLexer import ExprLexer
from ExprParser import ExprParser
from TreeVisitor import TreeVisitor
from EvalVisitor import EvalVisitor
from os import sys

#input_stream = InputStream(input('? '))

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

#print(tree.toStringTree(recog=parser))