parser grammar Parser;

options { tokenVocab = Lexer; }

@parser::header {

}

file returns [HadronFile result]
    : { ArrayList<Statement> statements = new ArrayList<Statement>(); } (
        s=statement SEP { statements.add($s.result); }
    )* (
        s=statement { statements.add($s.result); }
    )? { $result = new HadronFile(statements); };

statement returns [Statement result]
    : value { $result = new ValueStatement($value.result); }
    | VAL i=IDENTIFIER EQUAL value { $result = new DeclareAssignStatement($i.getText(), $value.result, false); }
    | VAR i=IDENTIFIER EQUAL value { $result = new DeclareAssignStatement($i.getText(), $value.result, true); }
    | FN i=IDENTIFIER OPAREN CPAREN value { $result = new DeclareFunctionStatement($i.getText(), $value.result); }
    | IF c=value SEP v=value { $result = new IfStatement($c.result, $v.result); };

value returns [Value result]
    : l=value bop=CARROT r=value { $result = new BinaryValue($bop.getText(), $l.result, $r.result); }
    | l=value bop=(STAR | SLASH) r=value { $result = new BinaryValue($bop.getText(), $l.result, $r.result); }
    | l=value bop=(PLUS | MINUS) r=value { $result = new BinaryValue($bop.getText(), $l.result, $r.result); }
    | uop=MINUS value { $result = new UnaryValue($uop.getText(), $value.result); }
    | v=BOOLEAN_LITERAL { $result = new BooleanValue($i.getText()); }
    | v=INTEGER_LITERAL { $result = new IntegerValue($i.getText()); }
    | v=(FLOAT_LITERAL | SCIENTIFIC_FLOAT_LITERAL) { $result = new FloatValue($i.getText()); }
    | v=STRING_LITERAL { $result = new StringValue($i.getText()); };
