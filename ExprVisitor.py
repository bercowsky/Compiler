# Generated from Expr.g by ANTLR 4.7.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .ExprParser import ExprParser
else:
    from ExprParser import ExprParser

# This class defines a complete generic visitor for a parse tree produced by ExprParser.

class ExprVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ExprParser#root.
    def visitRoot(self, ctx:ExprParser.RootContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#func.
    def visitFunc(self, ctx:ExprParser.FuncContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#expr.
    def visitExpr(self, ctx:ExprParser.ExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#stmt.
    def visitStmt(self, ctx:ExprParser.StmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#read.
    def visitRead(self, ctx:ExprParser.ReadContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#write.
    def visitWrite(self, ctx:ExprParser.WriteContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#array.
    def visitArray(self, ctx:ExprParser.ArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#getArr.
    def visitGetArr(self, ctx:ExprParser.GetArrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#setArr.
    def visitSetArr(self, ctx:ExprParser.SetArrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#assig.
    def visitAssig(self, ctx:ExprParser.AssigContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#method.
    def visitMethod(self, ctx:ExprParser.MethodContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExprParser#ident.
    def visitIdent(self, ctx:ExprParser.IdentContext):
        return self.visitChildren(ctx)



del ExprParser