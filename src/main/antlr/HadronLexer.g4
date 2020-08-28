lexer grammar HadronLexer;

fragment LETTER : [A-Z] | [a-z] | '_' | '$';
fragment NON_ZERO_DIGIT : [1-9];
fragment DIGIT : [0-9];
fragment HEX_DIGIT : [0-9] | [a-f] | [A-F];
fragment OCT_DIGIT : [0-7];
fragment BINARY_DIGIT : '0' | '1';
fragment TAB : '\t';
fragment STRING_CHAR : ~('"' | '\\' | '\r' | '\n');

fragment A : 'a' | 'A';
fragment B : 'b' | 'B';
fragment C : 'c' | 'C';
fragment D : 'd' | 'D';
fragment E : 'e' | 'E';
fragment F : 'f' | 'F';
fragment G : 'g' | 'G';
fragment H : 'h' | 'H';
fragment I : 'i' | 'I';
fragment J : 'j' | 'J';
fragment K : 'k' | 'K';
fragment L : 'l' | 'L';
fragment M : 'm' | 'M';
fragment N : 'n' | 'N';
fragment O : 'o' | 'O';
fragment P : 'p' | 'P';
fragment Q : 'q' | 'Q';
fragment R : 'r' | 'R';
fragment S : 's' | 'S';
fragment T : 't' | 'T';
fragment U : 'u' | 'U';
fragment V : 'v' | 'V';
fragment W : 'w' | 'W';
fragment X : 'x' | 'X';
fragment Y : 'y' | 'Y';
fragment Z : 'z' | 'Z';

FN : F N;
VAR : V A R;
VAL : V A L;

IF : I F;
ELSE : E L S E;
ELSEIF : E L S E I F;

AND : A N D;
OR : O R;
NOT : N O T;

UNIT : U N I T;
DIM : D I M;
PREFIX : P R E F I X;

TO: T O;

LOOP : L O O P;
FOR : F O R;
WHILE : W H I L E;

IMPORT : I M P O R T;

PLUS : '+';
MINUS : '-';
STAR : '*';
SLASH : '/';
CARROT : '^';
EQUAL : '=';
OPAREN : '(';
CPAREN : ')';
OBRACE : '{';
CBRACE : '}';
OBRAKET : '[';
CBRAKET : ']';
COMMA : ',';
COLON : ':';
SEMICOLON : ';';
OHAIRPIN : '<';
CHAIRPIN : '>';
OHAIRPINEQUAL : '<=';
CHAIRPINEQUAL : '>=';
BANG : '!';
PERCENT : '%';
HASH : '#';
DOLLAR : '$';


WS : [ \t\u000C]+ -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
NL : '\n' | '\r';

BOOLEAN_LITERAL : T R U E | F A L S E;
STRING_LITERAL : '"' STRING_CHAR* '"';
SCIENTIFIC_FLOAT_LITERAL : (DIGIT+ | DIGIT+ '.' DIGIT* | DIGIT* '.' DIGIT+) E MINUS? DIGIT+;
FLOAT_LITERAL : DIGIT+ '.' DIGIT* | DIGIT* '.' DIGIT+;
INTEGER_LITERAL : DIGIT+;
IDENTIFIER : LETTER (LETTER | DIGIT)*;
