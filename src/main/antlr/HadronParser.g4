parser grammar HadronParser;

options { tokenVocab = HadronLexer; }

@parser::header {
    import expressions.*;
    import values.*;
    import statements.*;
    import java.util.Map;
    import java.util.HashMap;
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
    : e=expression { $result = new ValueStatement($e.result); }
    | VAL i=IDENTIFIER EQUAL e=expression { $result = new DeclareVarlStatement($i.getText(), $e.result, false); }
    | VAR i=IDENTIFIER EQUAL e=expression { $result = new DeclareVarlStatement($i.getText(), $e.result, true); }
    | i=IDENTIFIER EQUAL e=expression { $result = new AssignVarlStatement($i.getText(), $e.result); }
    | FN id=IDENTIFIER OPAREN { List<String> args = new ArrayList<String>(); } (
        (
            i=IDENTIFIER COMMA { args.add($i.getText()); }
        )*
        i=IDENTIFIER { args.add($i.getText()); }
    )? CPAREN expression { $result = new DeclareFunctionStatement($id.getText(), args, $expression.result); }
    | IF cond=expression sep e=expression { $result = new IfStatement($cond.result, $e.result); }
    | UNIT DIM i=IDENTIFIER { $result = new DeclareBaseDimensionStatement($i.getText()); }
    | UNIT DIM i=IDENTIFIER EQUAL OBRAKET OBRAKET u=unit_expression CBRAKET CBRAKET { $result = new DeclareDerivedDimensionStatement($i.getText(), $u.result); }
    | UNIT i=IDENTIFIER { String prefix = null; } (PREFIX p=IDENTIFIER { prefix = $p.getText(); })? EQUAL
        n=numeric_value OBRAKET u=unit_expression CBRAKET { $result = new DeclareDerivedUnitStatement($i.getText(), $u.result, $n.result, prefix); }
    | UNIT i=IDENTIFIER { String prefix = null; } (PREFIX p=IDENTIFIER { prefix = $p.getText(); })? EQUAL
        OBRAKET OBRAKET u=unit_expression CBRAKET CBRAKET { $result = new DeclareBaseUnitStatement($i.getText(), $u.result, prefix); }
    | UNIT PREFIX id=IDENTIFIER EQUAL OBRAKET NL* { Map<String, NumericValue> prefixes = new HashMap<String, NumericValue>(); } (
        i=IDENTIFIER COLON n=numeric_value sep { prefixes.put($i.getText(), $n.result); }
    )* i=IDENTIFIER COLON n=numeric_value sep? { prefixes.put($i.getText(), $n.result); } CBRAKET { $result = new DeclareUnitPrefixStatement($id.getText(), prefixes); }
    | IMPORT im=import_identifier { $result = new ImportStatement($im.result); };

expression returns [Expression result]
    : l=expression bop=CARROT r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(STAR | SLASH) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(PLUS | MINUS) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(OHAIRPIN | CHAIRPIN | OHAIRPINEQUAL | CHAIRPINEQUAL) r=expression { $result = new BinaryExpression($bop.getText(), $l.result, $r.result); }
    | l=expression bop=(EQUAL | BANG) EQUAL r=expression { $result = new BinaryExpression($bop.getText() + "=", $l.result, $r.result); }
    | uop=MINUS expression { $result = new UnaryExpression($uop.getText(), $expression.result); }
    | v=BOOLEAN_LITERAL { $result = new BooleanValue($v.getText()); }
    | v=STRING_LITERAL { String t = $v.getText(); $result = new StringValue(t.substring(1, t.length()-1)); }
    | n=numeric_value { $result = $n.result; }
    | n=numeric_value OBRAKET u=unit_expression CBRAKET { $result = new UnitNumericExpression($n.result, $u.result); }
    | e=expression TO OBRAKET u=unit_expression CBRAKET { $result = new UnitConvertExpression($e.result, $u.result); }
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
    )? CBRACE { $result = new BlockExpression(statements); }
    | OPAREN e=expression CPAREN { $result = $e.result; };

numeric_value returns [NumericValue result]
    : { boolean neg = false; }(MINUS { neg = true; })? v=INTEGER_LITERAL { $result = new IntegerValue(((neg)?"-":"")+$v.getText()); }
    | { boolean neg = false; }(MINUS { neg = true; })? v=(FLOAT_LITERAL | SCIENTIFIC_FLOAT_LITERAL) { $result = new FloatValue(((neg)?"-":"")+$v.getText()); };

unit_expression returns [UnitExpression result]
    : l=unit_expression bop=CARROT e=numeric_value { $result = new BinaryExpression($bop.getText(), (Expression) $l.result, (Expression) $e.result); }
    | l=unit_expression bop=(STAR | SLASH) r=unit_expression { $result = new BinaryExpression($bop.getText(), (Expression) $l.result, (Expression) $r.result); }
    | i=IDENTIFIER { $result = new IdentifierExpression($i.getText()); };

import_identifier returns [String result]
    : id=IDENTIFIER { $result = $id.getText(); } (MINUS i=IDENTIFIER { $result += "-" + $i.getText(); })*;

sep : SEMICOLON NL* | NL+;
