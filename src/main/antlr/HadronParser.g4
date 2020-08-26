parser grammar HadronParser;

options { tokenVocab = HadronLexer; }

@parser::header {
    import expressions.*;
    import values.*;
    import statements.*;
}

@parser::members {
    public static HadronFile parseHadron(String source) {
        HadronLexer lexer = new HadronLexer(CharStreams.fromString(source));
        HadronParser parser = new HadronParser(new CommonTokenStream(lexer));
        return parser.file().result;
    }
}

file returns [HadronFile result]
    : { ArrayList<Statement> statements = new ArrayList<Statement>(); } (
        s=statement sep { statements.add($s.result); }
    )* (
        s=statement { statements.add($s.result); }
    )? EOF { $result = new HadronFile(statements); };

statement returns [Statement result]
    : expression { $result = new ValueStatement($expression.result); }
    | VAL i=IDENTIFIER EQUAL expression { $result = new DeclareVarlStatement($i.getText(), $expression.result, false); }
    | VAR i=IDENTIFIER EQUAL expression { $result = new DeclareVarlStatement($i.getText(), $expression.result, true); }
    | i=IDENTIFIER EQUAL expression { $result = new AssignVarlStatement($i.getText(), $expression.result); }
    | FN n=IDENTIFIER OPAREN { List<String> args = new ArrayList<String>(); } (
        (
            i=IDENTIFIER COMMA { args.add($i.getText()); }
        )*
        i=IDENTIFIER { args.add($i.getText()); }
    )? CPAREN expression { $result = new DeclareFunctionStatement($n.getText(), args, $expression.result); }
    | IF c=expression sep e=expression { $result = new IfStatement($c.result, $e.result); }
    | UNIT DIM i=IDENTIFIER
    | UNIT DIM i=IDENTIFIER EQUAL e=unit_expression
    | UNIT PREFIX i=IDENTIFIER EQUAL OBRAKET NL* (unit_prefix SEP)* unit_prefix SEP? CBRAKET
    | UNIT i=IDENTIFIER (PREFIX p=IDENTIFIER)? EQUAL
        numeric_value STAR OBRAKET (unit_expression | OBRAKET unit_expression CBRAKET) CBRAKET;

expression returns [Expression result]
    : l=expression bop=CARROT r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(STAR | SLASH) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(PLUS | MINUS) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(OHAIRPIN | CHAIRPIN | OHAIRPINEQUAL | CHAIRPINEQUAL) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | uop=MINUS expression { $result = new UnaryExpression($uop.getText(), $expression.result); }
    | v=BOOLEAN_LITERAL { $result = new BooleanValue($v.getText()); }
    | v=STRING_LITERAL { $result = new StringValue($v.getText()); }
    | n=numeric_value { $result = $n.result; }
    | i=IDENTIFIER { $result = new IdentifierExpression($i.getText()); }
    | i=IDENTIFIER OPAREN { List<Expression> args = new ArrayList<Expression>(); } (
        (
            e=expression COMMA { args.add($e.result); }
        )*
        e=expression { args.add($e.result); }
    )? CPAREN { $result = new FunctionCallExpression($i.getText(), args); }
    | OPAREN expression CPAREN { $result = $expression.result; }
    | OPAREN CPAREN { $result = VoidValue.INSTANCE; }
    | OBRACE NL* { ArrayList<Statement> statements = new ArrayList<Statement>(); } (
        s=statement sep { statements.add($s.result); }
    )* (
        NL* s=statement { statements.add($s.result); }
    )? CBRACE { $result = new BlockExpression(statements); };

numeric_value returns [NumericValue result]
    : v=INTEGER_LITERAL { $result = new IntegerValue($v.getText()); }
    | v=(FLOAT_LITERAL | SCIENTIFIC_FLOAT_LITERAL) { $result = new FloatValue($v.getText()); };

unit_expression returns [UnitExpression result]
    :

sep : SEMICOLON NL* | NL+;
