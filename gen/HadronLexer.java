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
		CARROT=11, EQUAL=12, OPAREN=13, CPAREN=14, OBRACE=15, CBRACE=16, SEP=17, 
		WS=18, COMMENT=19, LINE_COMMENT=20, NL=21, BOOLEAN_LITERAL=22, STRING_LITERAL=23, 
		SCIENTIFIC_FLOAT_LITERAL=24, FLOAT_LITERAL=25, INTEGER_LITERAL=26, IDENTIFIER=27;
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
			"SEP", "WS", "COMMENT", "LINE_COMMENT", "NL", "BOOLEAN_LITERAL", "STRING_LITERAL", 
			"SCIENTIFIC_FLOAT_LITERAL", "FLOAT_LITERAL", "INTEGER_LITERAL", "IDENTIFIER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", 
			"'^'", "'='", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FN", "VAR", "VAL", "IF", "ELSE", "ELSEIF", "PLUS", "MINUS", "STAR", 
			"SLASH", "CARROT", "EQUAL", "OPAREN", "CPAREN", "OBRACE", "CBRACE", "SEP", 
			"WS", "COMMENT", "LINE_COMMENT", "NL", "BOOLEAN_LITERAL", "STRING_LITERAL", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u0186\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\3\2\5\2\177\n\2\3\3\3\3\3\4\3\4\3\5\5\5\u0086\n\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%"+
		"\3%\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*"+
		"\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\3\64\7\64\u00f4\n\64\f\64\16\64\u00f7\13\64\3\64\6\64\u00fa\n\64"+
		"\r\64\16\64\u00fb\5\64\u00fe\n\64\3\65\6\65\u0101\n\65\r\65\16\65\u0102"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u010b\n\66\f\66\16\66\u010e\13\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u0119\n\67\f\67\16"+
		"\67\u011c\13\67\3\67\3\67\38\38\39\39\39\39\39\39\39\39\39\39\39\59\u012d"+
		"\n9\3:\3:\7:\u0131\n:\f:\16:\u0134\13:\3:\3:\3;\6;\u0139\n;\r;\16;\u013a"+
		"\3;\6;\u013e\n;\r;\16;\u013f\3;\3;\7;\u0144\n;\f;\16;\u0147\13;\3;\7;"+
		"\u014a\n;\f;\16;\u014d\13;\3;\3;\6;\u0151\n;\r;\16;\u0152\5;\u0155\n;"+
		"\3;\3;\5;\u0159\n;\3;\6;\u015c\n;\r;\16;\u015d\3<\6<\u0161\n<\r<\16<\u0162"+
		"\3<\3<\7<\u0167\n<\f<\16<\u016a\13<\3<\7<\u016d\n<\f<\16<\u0170\13<\3"+
		"<\3<\6<\u0174\n<\r<\16<\u0175\5<\u0178\n<\3=\6=\u017b\n=\r=\16=\u017c"+
		"\3>\3>\3>\7>\u0182\n>\f>\16>\u0185\13>\3\u010c\2?\3\2\5\2\7\2\t\2\13\2"+
		"\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-"+
		"\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\3I\4K\5M\6O\7Q\bS\tU\n"+
		"W\13Y\f[\r]\16_\17a\20c\21e\22g\23i\24k\25m\26o\27q\30s\31u\32w\33y\34"+
		"{\35\3\2$\6\2&&C\\aac|\3\2\63;\3\2\62;\5\2\62;CHch\3\2\629\6\2\f\f\17"+
		"\17$$^^\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJ"+
		"jj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||\5\2\13\13\16\16\"\"\4\2\f\f\17\17\2\u017c\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3"+
		"~\3\2\2\2\5\u0080\3\2\2\2\7\u0082\3\2\2\2\t\u0085\3\2\2\2\13\u0087\3\2"+
		"\2\2\r\u0089\3\2\2\2\17\u008b\3\2\2\2\21\u008d\3\2\2\2\23\u008f\3\2\2"+
		"\2\25\u0091\3\2\2\2\27\u0093\3\2\2\2\31\u0095\3\2\2\2\33\u0097\3\2\2\2"+
		"\35\u0099\3\2\2\2\37\u009b\3\2\2\2!\u009d\3\2\2\2#\u009f\3\2\2\2%\u00a1"+
		"\3\2\2\2\'\u00a3\3\2\2\2)\u00a5\3\2\2\2+\u00a7\3\2\2\2-\u00a9\3\2\2\2"+
		"/\u00ab\3\2\2\2\61\u00ad\3\2\2\2\63\u00af\3\2\2\2\65\u00b1\3\2\2\2\67"+
		"\u00b3\3\2\2\29\u00b5\3\2\2\2;\u00b7\3\2\2\2=\u00b9\3\2\2\2?\u00bb\3\2"+
		"\2\2A\u00bd\3\2\2\2C\u00bf\3\2\2\2E\u00c1\3\2\2\2G\u00c3\3\2\2\2I\u00c6"+
		"\3\2\2\2K\u00ca\3\2\2\2M\u00ce\3\2\2\2O\u00d1\3\2\2\2Q\u00d6\3\2\2\2S"+
		"\u00dd\3\2\2\2U\u00df\3\2\2\2W\u00e1\3\2\2\2Y\u00e3\3\2\2\2[\u00e5\3\2"+
		"\2\2]\u00e7\3\2\2\2_\u00e9\3\2\2\2a\u00eb\3\2\2\2c\u00ed\3\2\2\2e\u00ef"+
		"\3\2\2\2g\u00fd\3\2\2\2i\u0100\3\2\2\2k\u0106\3\2\2\2m\u0114\3\2\2\2o"+
		"\u011f\3\2\2\2q\u012c\3\2\2\2s\u012e\3\2\2\2u\u0154\3\2\2\2w\u0177\3\2"+
		"\2\2y\u017a\3\2\2\2{\u017e\3\2\2\2}\177\t\2\2\2~}\3\2\2\2\177\4\3\2\2"+
		"\2\u0080\u0081\t\3\2\2\u0081\6\3\2\2\2\u0082\u0083\t\4\2\2\u0083\b\3\2"+
		"\2\2\u0084\u0086\t\5\2\2\u0085\u0084\3\2\2\2\u0086\n\3\2\2\2\u0087\u0088"+
		"\t\6\2\2\u0088\f\3\2\2\2\u0089\u008a\4\62\63\2\u008a\16\3\2\2\2\u008b"+
		"\u008c\7\13\2\2\u008c\20\3\2\2\2\u008d\u008e\n\7\2\2\u008e\22\3\2\2\2"+
		"\u008f\u0090\t\b\2\2\u0090\24\3\2\2\2\u0091\u0092\t\t\2\2\u0092\26\3\2"+
		"\2\2\u0093\u0094\t\n\2\2\u0094\30\3\2\2\2\u0095\u0096\t\13\2\2\u0096\32"+
		"\3\2\2\2\u0097\u0098\t\f\2\2\u0098\34\3\2\2\2\u0099\u009a\t\r\2\2\u009a"+
		"\36\3\2\2\2\u009b\u009c\t\16\2\2\u009c \3\2\2\2\u009d\u009e\t\17\2\2\u009e"+
		"\"\3\2\2\2\u009f\u00a0\t\20\2\2\u00a0$\3\2\2\2\u00a1\u00a2\t\21\2\2\u00a2"+
		"&\3\2\2\2\u00a3\u00a4\t\22\2\2\u00a4(\3\2\2\2\u00a5\u00a6\t\23\2\2\u00a6"+
		"*\3\2\2\2\u00a7\u00a8\t\24\2\2\u00a8,\3\2\2\2\u00a9\u00aa\t\25\2\2\u00aa"+
		".\3\2\2\2\u00ab\u00ac\t\26\2\2\u00ac\60\3\2\2\2\u00ad\u00ae\t\27\2\2\u00ae"+
		"\62\3\2\2\2\u00af\u00b0\t\30\2\2\u00b0\64\3\2\2\2\u00b1\u00b2\t\31\2\2"+
		"\u00b2\66\3\2\2\2\u00b3\u00b4\t\32\2\2\u00b48\3\2\2\2\u00b5\u00b6\t\33"+
		"\2\2\u00b6:\3\2\2\2\u00b7\u00b8\t\34\2\2\u00b8<\3\2\2\2\u00b9\u00ba\t"+
		"\35\2\2\u00ba>\3\2\2\2\u00bb\u00bc\t\36\2\2\u00bc@\3\2\2\2\u00bd\u00be"+
		"\t\37\2\2\u00beB\3\2\2\2\u00bf\u00c0\t \2\2\u00c0D\3\2\2\2\u00c1\u00c2"+
		"\t!\2\2\u00c2F\3\2\2\2\u00c3\u00c4\5\35\17\2\u00c4\u00c5\5-\27\2\u00c5"+
		"H\3\2\2\2\u00c6\u00c7\5=\37\2\u00c7\u00c8\5\23\n\2\u00c8\u00c9\5\65\33"+
		"\2\u00c9J\3\2\2\2\u00ca\u00cb\5=\37\2\u00cb\u00cc\5\23\n\2\u00cc\u00cd"+
		"\5)\25\2\u00cdL\3\2\2\2\u00ce\u00cf\5#\22\2\u00cf\u00d0\5\35\17\2\u00d0"+
		"N\3\2\2\2\u00d1\u00d2\5\33\16\2\u00d2\u00d3\5)\25\2\u00d3\u00d4\5\67\34"+
		"\2\u00d4\u00d5\5\33\16\2\u00d5P\3\2\2\2\u00d6\u00d7\5\33\16\2\u00d7\u00d8"+
		"\5)\25\2\u00d8\u00d9\5\67\34\2\u00d9\u00da\5\33\16\2\u00da\u00db\5#\22"+
		"\2\u00db\u00dc\5\35\17\2\u00dcR\3\2\2\2\u00dd\u00de\7-\2\2\u00deT\3\2"+
		"\2\2\u00df\u00e0\7/\2\2\u00e0V\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2X\3\2\2"+
		"\2\u00e3\u00e4\7\61\2\2\u00e4Z\3\2\2\2\u00e5\u00e6\7`\2\2\u00e6\\\3\2"+
		"\2\2\u00e7\u00e8\7?\2\2\u00e8^\3\2\2\2\u00e9\u00ea\7*\2\2\u00ea`\3\2\2"+
		"\2\u00eb\u00ec\7+\2\2\u00ecb\3\2\2\2\u00ed\u00ee\7}\2\2\u00eed\3\2\2\2"+
		"\u00ef\u00f0\7\177\2\2\u00f0f\3\2\2\2\u00f1\u00f5\7=\2\2\u00f2\u00f4\5"+
		"o8\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00fe\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fa\5o"+
		"8\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00f1\3\2\2\2\u00fd\u00f9\3\2"+
		"\2\2\u00feh\3\2\2\2\u00ff\u0101\t\"\2\2\u0100\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\b\65\2\2\u0105j\3\2\2\2\u0106\u0107\7\61\2\2\u0107\u0108\7,\2\2"+
		"\u0108\u010c\3\2\2\2\u0109\u010b\13\2\2\2\u010a\u0109\3\2\2\2\u010b\u010e"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0110\7,\2\2\u0110\u0111\7\61\2\2\u0111\u0112\3\2"+
		"\2\2\u0112\u0113\b\66\2\2\u0113l\3\2\2\2\u0114\u0115\7\61\2\2\u0115\u0116"+
		"\7\61\2\2\u0116\u011a\3\2\2\2\u0117\u0119\n#\2\2\u0118\u0117\3\2\2\2\u0119"+
		"\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011d\u011e\b\67\2\2\u011en\3\2\2\2\u011f\u0120"+
		"\t#\2\2\u0120p\3\2\2\2\u0121\u0122\59\35\2\u0122\u0123\5\65\33\2\u0123"+
		"\u0124\5;\36\2\u0124\u0125\5\33\16\2\u0125\u012d\3\2\2\2\u0126\u0127\5"+
		"\35\17\2\u0127\u0128\5\23\n\2\u0128\u0129\5)\25\2\u0129\u012a\5\67\34"+
		"\2\u012a\u012b\5\33\16\2\u012b\u012d\3\2\2\2\u012c\u0121\3\2\2\2\u012c"+
		"\u0126\3\2\2\2\u012dr\3\2\2\2\u012e\u0132\7$\2\2\u012f\u0131\5\21\t\2"+
		"\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7$\2\2\u0136"+
		"t\3\2\2\2\u0137\u0139\5\7\4\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2"+
		"\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0155\3\2\2\2\u013c\u013e"+
		"\5\7\4\2\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0145\7\60\2\2\u0142\u0144\5"+
		"\7\4\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0155\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014a\5\7"+
		"\4\2\u0149\u0148\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0150\7\60"+
		"\2\2\u014f\u0151\5\7\4\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0138\3\2"+
		"\2\2\u0154\u013d\3\2\2\2\u0154\u014b\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0158\5\33\16\2\u0157\u0159\5U+\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u015b\3\2\2\2\u015a\u015c\5\7\4\2\u015b\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015ev\3\2\2\2"+
		"\u015f\u0161\5\7\4\2\u0160\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160"+
		"\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0168\7\60\2\2"+
		"\u0165\u0167\5\7\4\2\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166"+
		"\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0178\3\2\2\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016d\5\7\4\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171"+
		"\u0173\7\60\2\2\u0172\u0174\5\7\4\2\u0173\u0172\3\2\2\2\u0174\u0175\3"+
		"\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177"+
		"\u0160\3\2\2\2\u0177\u016e\3\2\2\2\u0178x\3\2\2\2\u0179\u017b\5\7\4\2"+
		"\u017a\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d"+
		"\3\2\2\2\u017dz\3\2\2\2\u017e\u0183\5\3\2\2\u017f\u0182\5\3\2\2\u0180"+
		"\u0182\5\7\4\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2"+
		"\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184|\3\2\2\2\u0185\u0183"+
		"\3\2\2\2\35\2~\u0085\u00f5\u00fb\u00fd\u0102\u010c\u011a\u012c\u0132\u013a"+
		"\u013f\u0145\u014b\u0152\u0154\u0158\u015d\u0162\u0168\u016e\u0175\u0177"+
		"\u017c\u0181\u0183\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}