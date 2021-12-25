
grammar Expr;
//root : expr EOF ;
root : func* EOF ;
func : TYPE ident LPAR ((ident',')* ident)? RPAR LBRACKET stmt* RBRACKET;
expr : LPAR expr RPAR
    | <assoc=right> expr POW expr
    | expr MULT expr
    | expr DIV expr
    | expr MES expr
    | expr MENYS expr
    | expr MOD expr
    | expr LT expr
    | expr LE expr
    | expr GT expr
    | expr GE expr
    | expr DIFF expr
    | expr EQ expr
    | NUM
    | ident
    | getArr
    ;

stmt : 'if' LPAR expr RPAR LBRACKET stmt* RBRACKET ('else' LBRACKET stmt* RBRACKET)?
    | 'while' LPAR expr RPAR LBRACKET stmt+ RBRACKET
    | 'for' LPAR assig ';' expr ';' assig RPAR LBRACKET stmt+ RBRACKET
    | read
    | write
    | assig
    | method
    | array
    | getArr
    | setArr;

read     : 'read' LPAR ident RPAR;
write    : 'write' LPAR ((ident | STRING | expr | getArr) (','(ident | STRING | expr | getArr))*)? RPAR;
array    : 'array' LPAR ident ',' expr RPAR;
getArr   : 'get' LPAR ident ',' expr RPAR;
setArr   : 'set' LPAR ident ',' expr ',' expr RPAR;
assig    : ident '=' expr;
method   : ident LPAR (((ident | expr)',')* (ident | expr))? RPAR;

COMMENT  : '#' ~[\r\n]* -> skip ;

TYPE     : 'void';
NUM      : [0-9]+ ('.'[0-9]+)?;
LETTER   : [a-zA-Z\u0080-\u00FF];
ident    : LETTER (LETTER | NUM)*;
MES      : '+' ;
MENYS    : '-';
MULT     : '*';
DIV      : '/';
MOD      : '%';
LT       : '<';
LE       : '<=';
GT       : '>';
GE       : '>=';
DIFF     : '<>';
EQ       : '==';
POW      : '^';
LPAR     : '(';
RPAR     : ')';
LBRACKET : '{';
RBRACKET : '}';
STRING   : '"' ~'"'* '"';
WS       : [ \n]+ -> skip ;