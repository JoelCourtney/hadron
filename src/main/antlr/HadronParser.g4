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
        s=statement SEP { statements.add($s.result); }
    )* (
        s=statement { statements.add($s.result); }
    )? SEP? EOF { $result = new HadronFile(statements); };

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
    | IF c=expression SEP e=expression { $result = new IfStatement($c.result, $e.result); };

expression returns [Expression result]
    : l=expression bop=CARROT r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(STAR | SLASH) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(PLUS | MINUS) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | uop=MINUS expression { $result = new UnaryExpression($uop.getText(), $expression.result); }
    | v=BOOLEAN_LITERAL { $result = new BooleanValue($v.getText()); }
    | v=INTEGER_LITERAL { $result = new IntegerValue($v.getText()); }
    | v=(FLOAT_LITERAL | SCIENTIFIC_FLOAT_LITERAL) { $result = new FloatValue($v.getText()); }
    | v=STRING_LITERAL { $result = new StringValue($v.getText()); }
    | i=IDENTIFIER { $result = new IdentifierExpression($i.getText()); }
    | i=IDENTIFIER OPAREN { List<Expression> args = new ArrayList<Expression>(); } (
        (
            e=expression COMMA { args.add($e.result); }
        )*
        e=expression { args.add($e.result); }
    )? CPAREN { $result = new FunctionCallExpression($i.getText(), args); };
