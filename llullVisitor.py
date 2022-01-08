# Generated from llull.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .llullParser import llullParser
else:
    from llullParser import llullParser

# This class defines a complete generic visitor for a parse tree produced by llullParser.

class llullVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by llullParser#root.
    def visitRoot(self, ctx:llullParser.RootContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#func.
    def visitFunc(self, ctx:llullParser.FuncContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#expr.
    def visitExpr(self, ctx:llullParser.ExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#stmt.
    def visitStmt(self, ctx:llullParser.StmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#read.
    def visitRead(self, ctx:llullParser.ReadContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#write.
    def visitWrite(self, ctx:llullParser.WriteContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#array.
    def visitArray(self, ctx:llullParser.ArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#getArr.
    def visitGetArr(self, ctx:llullParser.GetArrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#setArr.
    def visitSetArr(self, ctx:llullParser.SetArrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#assig.
    def visitAssig(self, ctx:llullParser.AssigContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#method.
    def visitMethod(self, ctx:llullParser.MethodContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by llullParser#ident.
    def visitIdent(self, ctx:llullParser.IdentContext):
        return self.visitChildren(ctx)



del llullParser