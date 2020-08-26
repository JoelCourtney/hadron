// Generated from /home/joel/repos/hadron/src/main/antlr/HadronLexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HadronLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FN=1, VAR=2, VAL=3, IF=4, ELSE=5, ELSEIF=6, PLUS=7, MINUS=8, STAR=9, SLASH=10, 
		CARROT=11, EQUAL=12, OPAREN=13, CPAREN=14, OBRACE=15, CBRACE=16, COMMA=17, 
		SEP=18, WS=19, COMMENT=20, LINE_COMMENT=21, NL=22, BOOLEAN_LITERAL=23, 
		STRING_LITERAL=24, SCIENTIFIC_FLOAT_LITERAL=25, FLOAT_LITERAL=26, INTEGER_LITERAL=27, 
		IDENTIFIER=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETTER", "NON_ZERO_DIGIT", "DIGIT", "HEX_DIGIT", "OCT_DIGIT", "BINARY_DIGIT", 
			"TAB", "STRING_CHAR", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
			"Y", "Z", "FN", "VAR", "VAL", "IF", "ELSE", "ELSEIF", "PLUS", "MINUS", 
			"STAR", "SLASH", "CARROT", "EQUAL", "OPAREN", "CPAREN", "OBRACE", "CBRACE", 
			"COMMA", "SEP", "WS", "COMMENT", "LINE_COMMENT", "NL", "BOOLEAN_LITERAL", 
			"STRING_LITERAL", "SCIENTIFIC_FLOAT_LITERAL", "FLOAT_LITERAL", "INTEGER_LITERAL", 
			"IDENTIFIER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", 
			"'^'", "'='", "'('", "')'", "'{'", "'}'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FN", "VAR", "VAL", "IF", "ELSE", "ELSEIF", "PLUS", "MINUS", "STAR", 
			"SLASH", "CARROT", "EQUAL", "OPAREN", "CPAREN", "OBRACE", "CBRACE", "COMMA", 
			"SEP", "WS", "COMMENT", "LINE_COMMENT", "NL", "BOOLEAN_LITERAL", "STRING_LITERAL", 
			"SCIENTIFIC_FLOAT_LITERAL", "FLOAT_LITERAL", "INTEGER_LITERAL", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public HadronLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HadronLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u018a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\3\2\5\2\u0081\n\2\3\3\3\3\3\4\3\4\3\5\5\5\u0088\n\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3"+
		")\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\3\65\3\65\7\65\u00f8\n\65\f\65\16\65\u00fb\13\65\3"+
		"\65\6\65\u00fe\n\65\r\65\16\65\u00ff\5\65\u0102\n\65\3\66\6\66\u0105\n"+
		"\66\r\66\16\66\u0106\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u010f\n\67\f\67"+
		"\16\67\u0112\13\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\78\u011d\n8\f"+
		"8\168\u0120\138\38\38\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u0131"+
		"\n:\3;\3;\7;\u0135\n;\f;\16;\u0138\13;\3;\3;\3<\6<\u013d\n<\r<\16<\u013e"+
		"\3<\6<\u0142\n<\r<\16<\u0143\3<\3<\7<\u0148\n<\f<\16<\u014b\13<\3<\7<"+
		"\u014e\n<\f<\16<\u0151\13<\3<\3<\6<\u0155\n<\r<\16<\u0156\5<\u0159\n<"+
		"\3<\3<\5<\u015d\n<\3<\6<\u0160\n<\r<\16<\u0161\3=\6=\u0165\n=\r=\16=\u0166"+
		"\3=\3=\7=\u016b\n=\f=\16=\u016e\13=\3=\7=\u0171\n=\f=\16=\u0174\13=\3"+
		"=\3=\6=\u0178\n=\r=\16=\u0179\5=\u017c\n=\3>\6>\u017f\n>\r>\16>\u0180"+
		"\3?\3?\3?\7?\u0186\n?\f?\16?\u0189\13?\3\u0110\2@\3\2\5\2\7\2\t\2\13\2"+
		"\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-"+
		"\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\3I\4K\5M\6O\7Q\bS\tU\n"+
		"W\13Y\f[\r]\16_\17a\20c\21e\22g\23i\24k\25m\26o\27q\30s\31u\32w\33y\34"+
		"{\35}\36\3\2$\6\2&&C\\aac|\3\2\63;\3\2\62;\5\2\62;CHch\3\2\629\6\2\f\f"+
		"\17\17$$^^\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2"+
		"JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4"+
		"\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{"+
		"{\4\2\\\\||\5\2\13\13\16\16\"\"\4\2\f\f\17\17\2\u0180\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3"+
		"\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2"+
		"\2\2}\3\2\2\2\3\u0080\3\2\2\2\5\u0082\3\2\2\2\7\u0084\3\2\2\2\t\u0087"+
		"\3\2\2\2\13\u0089\3\2\2\2\r\u008b\3\2\2\2\17\u008d\3\2\2\2\21\u008f\3"+
		"\2\2\2\23\u0091\3\2\2\2\25\u0093\3\2\2\2\27\u0095\3\2\2\2\31\u0097\3\2"+
		"\2\2\33\u0099\3\2\2\2\35\u009b\3\2\2\2\37\u009d\3\2\2\2!\u009f\3\2\2\2"+
		"#\u00a1\3\2\2\2%\u00a3\3\2\2\2\'\u00a5\3\2\2\2)\u00a7\3\2\2\2+\u00a9\3"+
		"\2\2\2-\u00ab\3\2\2\2/\u00ad\3\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2\2"+
		"\65\u00b3\3\2\2\2\67\u00b5\3\2\2\29\u00b7\3\2\2\2;\u00b9\3\2\2\2=\u00bb"+
		"\3\2\2\2?\u00bd\3\2\2\2A\u00bf\3\2\2\2C\u00c1\3\2\2\2E\u00c3\3\2\2\2G"+
		"\u00c5\3\2\2\2I\u00c8\3\2\2\2K\u00cc\3\2\2\2M\u00d0\3\2\2\2O\u00d3\3\2"+
		"\2\2Q\u00d8\3\2\2\2S\u00df\3\2\2\2U\u00e1\3\2\2\2W\u00e3\3\2\2\2Y\u00e5"+
		"\3\2\2\2[\u00e7\3\2\2\2]\u00e9\3\2\2\2_\u00eb\3\2\2\2a\u00ed\3\2\2\2c"+
		"\u00ef\3\2\2\2e\u00f1\3\2\2\2g\u00f3\3\2\2\2i\u0101\3\2\2\2k\u0104\3\2"+
		"\2\2m\u010a\3\2\2\2o\u0118\3\2\2\2q\u0123\3\2\2\2s\u0130\3\2\2\2u\u0132"+
		"\3\2\2\2w\u0158\3\2\2\2y\u017b\3\2\2\2{\u017e\3\2\2\2}\u0182\3\2\2\2\177"+
		"\u0081\t\2\2\2\u0080\177\3\2\2\2\u0081\4\3\2\2\2\u0082\u0083\t\3\2\2\u0083"+
		"\6\3\2\2\2\u0084\u0085\t\4\2\2\u0085\b\3\2\2\2\u0086\u0088\t\5\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\n\3\2\2\2\u0089\u008a\t\6\2\2\u008a\f\3\2\2\2\u008b"+
		"\u008c\4\62\63\2\u008c\16\3\2\2\2\u008d\u008e\7\13\2\2\u008e\20\3\2\2"+
		"\2\u008f\u0090\n\7\2\2\u0090\22\3\2\2\2\u0091\u0092\t\b\2\2\u0092\24\3"+
		"\2\2\2\u0093\u0094\t\t\2\2\u0094\26\3\2\2\2\u0095\u0096\t\n\2\2\u0096"+
		"\30\3\2\2\2\u0097\u0098\t\13\2\2\u0098\32\3\2\2\2\u0099\u009a\t\f\2\2"+
		"\u009a\34\3\2\2\2\u009b\u009c\t\r\2\2\u009c\36\3\2\2\2\u009d\u009e\t\16"+
		"\2\2\u009e \3\2\2\2\u009f\u00a0\t\17\2\2\u00a0\"\3\2\2\2\u00a1\u00a2\t"+
		"\20\2\2\u00a2$\3\2\2\2\u00a3\u00a4\t\21\2\2\u00a4&\3\2\2\2\u00a5\u00a6"+
		"\t\22\2\2\u00a6(\3\2\2\2\u00a7\u00a8\t\23\2\2\u00a8*\3\2\2\2\u00a9\u00aa"+
		"\t\24\2\2\u00aa,\3\2\2\2\u00ab\u00ac\t\25\2\2\u00ac.\3\2\2\2\u00ad\u00ae"+
		"\t\26\2\2\u00ae\60\3\2\2\2\u00af\u00b0\t\27\2\2\u00b0\62\3\2\2\2\u00b1"+
		"\u00b2\t\30\2\2\u00b2\64\3\2\2\2\u00b3\u00b4\t\31\2\2\u00b4\66\3\2\2\2"+
		"\u00b5\u00b6\t\32\2\2\u00b68\3\2\2\2\u00b7\u00b8\t\33\2\2\u00b8:\3\2\2"+
		"\2\u00b9\u00ba\t\34\2\2\u00ba<\3\2\2\2\u00bb\u00bc\t\35\2\2\u00bc>\3\2"+
		"\2\2\u00bd\u00be\t\36\2\2\u00be@\3\2\2\2\u00bf\u00c0\t\37\2\2\u00c0B\3"+
		"\2\2\2\u00c1\u00c2\t \2\2\u00c2D\3\2\2\2\u00c3\u00c4\t!\2\2\u00c4F\3\2"+
		"\2\2\u00c5\u00c6\5\35\17\2\u00c6\u00c7\5-\27\2\u00c7H\3\2\2\2\u00c8\u00c9"+
		"\5=\37\2\u00c9\u00ca\5\23\n\2\u00ca\u00cb\5\65\33\2\u00cbJ\3\2\2\2\u00cc"+
		"\u00cd\5=\37\2\u00cd\u00ce\5\23\n\2\u00ce\u00cf\5)\25\2\u00cfL\3\2\2\2"+
		"\u00d0\u00d1\5#\22\2\u00d1\u00d2\5\35\17\2\u00d2N\3\2\2\2\u00d3\u00d4"+
		"\5\33\16\2\u00d4\u00d5\5)\25\2\u00d5\u00d6\5\67\34\2\u00d6\u00d7\5\33"+
		"\16\2\u00d7P\3\2\2\2\u00d8\u00d9\5\33\16\2\u00d9\u00da\5)\25\2\u00da\u00db"+
		"\5\67\34\2\u00db\u00dc\5\33\16\2\u00dc\u00dd\5#\22\2\u00dd\u00de\5\35"+
		"\17\2\u00deR\3\2\2\2\u00df\u00e0\7-\2\2\u00e0T\3\2\2\2\u00e1\u00e2\7/"+
		"\2\2\u00e2V\3\2\2\2\u00e3\u00e4\7,\2\2\u00e4X\3\2\2\2\u00e5\u00e6\7\61"+
		"\2\2\u00e6Z\3\2\2\2\u00e7\u00e8\7`\2\2\u00e8\\\3\2\2\2\u00e9\u00ea\7?"+
		"\2\2\u00ea^\3\2\2\2\u00eb\u00ec\7*\2\2\u00ec`\3\2\2\2\u00ed\u00ee\7+\2"+
		"\2\u00eeb\3\2\2\2\u00ef\u00f0\7}\2\2\u00f0d\3\2\2\2\u00f1\u00f2\7\177"+
		"\2\2\u00f2f\3\2\2\2\u00f3\u00f4\7.\2\2\u00f4h\3\2\2\2\u00f5\u00f9\7=\2"+
		"\2\u00f6\u00f8\5q9\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u0102\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00fe\5q9\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2"+
		"\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00f5\3\2\2\2\u0101\u00fd"+
		"\3\2\2\2\u0102j\3\2\2\2\u0103\u0105\t\"\2\2\u0104\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u0109\b\66\2\2\u0109l\3\2\2\2\u010a\u010b\7\61\2\2\u010b\u010c"+
		"\7,\2\2\u010c\u0110\3\2\2\2\u010d\u010f\13\2\2\2\u010e\u010d\3\2\2\2\u010f"+
		"\u0112\3\2\2\2\u0110\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\3\2"+
		"\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7,\2\2\u0114\u0115\7\61\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\b\67\2\2\u0117n\3\2\2\2\u0118\u0119\7\61\2"+
		"\2\u0119\u011a\7\61\2\2\u011a\u011e\3\2\2\2\u011b\u011d\n#\2\2\u011c\u011b"+
		"\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\b8\2\2\u0122p\3\2\2\2\u0123"+
		"\u0124\t#\2\2\u0124r\3\2\2\2\u0125\u0126\59\35\2\u0126\u0127\5\65\33\2"+
		"\u0127\u0128\5;\36\2\u0128\u0129\5\33\16\2\u0129\u0131\3\2\2\2\u012a\u012b"+
		"\5\35\17\2\u012b\u012c\5\23\n\2\u012c\u012d\5)\25\2\u012d\u012e\5\67\34"+
		"\2\u012e\u012f\5\33\16\2\u012f\u0131\3\2\2\2\u0130\u0125\3\2\2\2\u0130"+
		"\u012a\3\2\2\2\u0131t\3\2\2\2\u0132\u0136\7$\2\2\u0133\u0135\5\21\t\2"+
		"\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\7$\2\2\u013a"+
		"v\3\2\2\2\u013b\u013d\5\7\4\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2"+
		"\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0159\3\2\2\2\u0140\u0142"+
		"\5\7\4\2\u0141\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0149\7\60\2\2\u0146\u0148\5"+
		"\7\4\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u0159\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014e\5\7"+
		"\4\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\7\60"+
		"\2\2\u0153\u0155\5\7\4\2\u0154\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u013c\3\2"+
		"\2\2\u0158\u0141\3\2\2\2\u0158\u014f\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015c\5\33\16\2\u015b\u015d\5U+\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d\u015f\3\2\2\2\u015e\u0160\5\7\4\2\u015f\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162x\3\2\2\2"+
		"\u0163\u0165\5\7\4\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016c\7\60\2\2"+
		"\u0169\u016b\5\7\4\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u017c\3\2\2\2\u016e\u016c\3\2\2\2\u016f"+
		"\u0171\5\7\4\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175"+
		"\u0177\7\60\2\2\u0176\u0178\5\7\4\2\u0177\u0176\3\2\2\2\u0178\u0179\3"+
		"\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b"+
		"\u0164\3\2\2\2\u017b\u0172\3\2\2\2\u017cz\3\2\2\2\u017d\u017f\5\7\4\2"+
		"\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181"+
		"\3\2\2\2\u0181|\3\2\2\2\u0182\u0187\5\3\2\2\u0183\u0186\5\3\2\2\u0184"+
		"\u0186\5\7\4\2\u0185\u0183\3\2\2\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2"+
		"\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188~\3\2\2\2\u0189\u0187"+
		"\3\2\2\2\35\2\u0080\u0087\u00f9\u00ff\u0101\u0106\u0110\u011e\u0130\u0136"+
		"\u013e\u0143\u0149\u014f\u0156\u0158\u015c\u0161\u0166\u016c\u0172\u0179"+
		"\u017b\u0180\u0185\u0187\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}