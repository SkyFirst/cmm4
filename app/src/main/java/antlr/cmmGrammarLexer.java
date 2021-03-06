package antlr;// Generated from D:/java_project/cmm4/src\cmmGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class cmmGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MUL_COMMENT=1, SINGLE_COMMENT=2, IF=3, ELSE=4, WHILE=5, READ=6, WRITE=7, 
		BREAK=8, INT=9, DOUBLE=10, TRUE=11, FALSE=12, PLUS=13, MINUS=14, MUL=15, 
		DIV=16, MOD=17, ASSIGN=18, LET=19, LT=20, EQ=21, NEQ=22, LPARENT=23, RPARENT=24, 
		SEMI=25, LBRACE=26, RBRACE=27, GT=28, GET=29, LBRACKET=30, RBRACKET=31, 
		COM=32, DOT=33, ID=34, LITERAL_INT=35, LITERAL_REAL=36, WS=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Alpha", "AlphaAndNum", "NEWLINE", "MUL_COMMENT", "SINGLE_COMMENT", "IF", 
		"ELSE", "WHILE", "READ", "WRITE", "BREAK", "INT", "DOUBLE", "TRUE", "FALSE", 
		"PLUS", "MINUS", "MUL", "DIV", "MOD", "ASSIGN", "LET", "LT", "EQ", "NEQ", 
		"LPARENT", "RPARENT", "SEMI", "LBRACE", "RBRACE", "GT", "GET", "LBRACKET", 
		"RBRACKET", "COM", "DOT", "ID", "LITERAL_INT", "LITERAL_REAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'if'", "'else'", "'while'", "'read'", "'write'", "'break'", 
		"'int'", "'real'", "'true'", "'false'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'='", "'<='", "'<'", "'=='", "'!='", "'('", "')'", "';'", "'{'", "'}'", 
		"'>'", "'>='", "'['", "']'", "','", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "MUL_COMMENT", "SINGLE_COMMENT", "IF", "ELSE", "WHILE", "READ", 
		"WRITE", "BREAK", "INT", "DOUBLE", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", 
		"DIV", "MOD", "ASSIGN", "LET", "LT", "EQ", "NEQ", "LPARENT", "RPARENT", 
		"SEMI", "LBRACE", "RBRACE", "GT", "GET", "LBRACKET", "RBRACKET", "COM", 
		"DOT", "ID", "LITERAL_INT", "LITERAL_REAL", "WS"
	};
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


	public cmmGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "cmmGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u0116\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\5\3X\n\3\3\4\5\4[\n\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5c\n\5\f\5\16\5f\13"+
		"\5\3\5\3\5\3\5\5\5k\n\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6s\n\6\f\6\16\6v\13"+
		"\6\3\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\7&\u00e3\n&"+
		"\f&\16&\u00e6\13&\3&\3&\7&\u00ea\n&\f&\16&\u00ed\13&\3&\5&\u00f0\n&\3"+
		"\'\3\'\3\'\3\'\5\'\u00f6\n\'\3\'\3\'\7\'\u00fa\n\'\f\'\16\'\u00fd\13\'"+
		"\3\'\5\'\u0100\n\'\3(\3(\3(\3(\5(\u0106\n(\3(\3(\3(\7(\u010b\n(\f(\16"+
		"(\u010e\13(\3)\6)\u0111\n)\r)\16)\u0112\3)\3)\3d\2*\3\2\5\2\7\2\t\3\13"+
		"\4\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22"+
		")\23+\24-\25/\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#"+
		"K$M%O&Q\'\3\2\b\4\2C\\c|\3\2\62;\4\2\f\f\17\17\3\2\63;\3\2\62\62\5\2\13"+
		"\f\17\17\"\"\u0124\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5W\3\2\2\2\7Z\3\2\2"+
		"\2\t^\3\2\2\2\13n\3\2\2\2\r\177\3\2\2\2\17\u0082\3\2\2\2\21\u0087\3\2"+
		"\2\2\23\u008d\3\2\2\2\25\u0092\3\2\2\2\27\u0098\3\2\2\2\31\u009e\3\2\2"+
		"\2\33\u00a2\3\2\2\2\35\u00a7\3\2\2\2\37\u00ac\3\2\2\2!\u00b2\3\2\2\2#"+
		"\u00b4\3\2\2\2%\u00b6\3\2\2\2\'\u00b8\3\2\2\2)\u00ba\3\2\2\2+\u00bc\3"+
		"\2\2\2-\u00be\3\2\2\2/\u00c1\3\2\2\2\61\u00c3\3\2\2\2\63\u00c6\3\2\2\2"+
		"\65\u00c9\3\2\2\2\67\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00cf\3\2\2\2=\u00d1"+
		"\3\2\2\2?\u00d3\3\2\2\2A\u00d5\3\2\2\2C\u00d8\3\2\2\2E\u00da\3\2\2\2G"+
		"\u00dc\3\2\2\2I\u00de\3\2\2\2K\u00e0\3\2\2\2M\u00ff\3\2\2\2O\u0105\3\2"+
		"\2\2Q\u0110\3\2\2\2ST\t\2\2\2T\4\3\2\2\2UX\5\3\2\2VX\t\3\2\2WU\3\2\2\2"+
		"WV\3\2\2\2X\6\3\2\2\2Y[\7\17\2\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\f"+
		"\2\2]\b\3\2\2\2^_\7\61\2\2_`\7,\2\2`d\3\2\2\2ac\13\2\2\2ba\3\2\2\2cf\3"+
		"\2\2\2de\3\2\2\2db\3\2\2\2ej\3\2\2\2fd\3\2\2\2gh\7,\2\2hk\7\61\2\2ik\7"+
		"\2\2\3jg\3\2\2\2ji\3\2\2\2kl\3\2\2\2lm\b\5\2\2m\n\3\2\2\2no\7\61\2\2o"+
		"p\7\61\2\2pt\3\2\2\2qs\n\4\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2"+
		"uz\3\2\2\2vt\3\2\2\2wy\5\7\4\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{}\3\2\2\2|z\3\2\2\2}~\b\6\2\2~\f\3\2\2\2\177\u0080\7k\2\2\u0080\u0081"+
		"\7h\2\2\u0081\16\3\2\2\2\u0082\u0083\7g\2\2\u0083\u0084\7n\2\2\u0084\u0085"+
		"\7u\2\2\u0085\u0086\7g\2\2\u0086\20\3\2\2\2\u0087\u0088\7y\2\2\u0088\u0089"+
		"\7j\2\2\u0089\u008a\7k\2\2\u008a\u008b\7n\2\2\u008b\u008c\7g\2\2\u008c"+
		"\22\3\2\2\2\u008d\u008e\7t\2\2\u008e\u008f\7g\2\2\u008f\u0090\7c\2\2\u0090"+
		"\u0091\7f\2\2\u0091\24\3\2\2\2\u0092\u0093\7y\2\2\u0093\u0094\7t\2\2\u0094"+
		"\u0095\7k\2\2\u0095\u0096\7v\2\2\u0096\u0097\7g\2\2\u0097\26\3\2\2\2\u0098"+
		"\u0099\7d\2\2\u0099\u009a\7t\2\2\u009a\u009b\7g\2\2\u009b\u009c\7c\2\2"+
		"\u009c\u009d\7m\2\2\u009d\30\3\2\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7"+
		"p\2\2\u00a0\u00a1\7v\2\2\u00a1\32\3\2\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4"+
		"\7g\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7n\2\2\u00a6\34\3\2\2\2\u00a7\u00a8"+
		"\7v\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7w\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\36\3\2\2\2\u00ac\u00ad\7h\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7n\2\2\u00af"+
		"\u00b0\7u\2\2\u00b0\u00b1\7g\2\2\u00b1 \3\2\2\2\u00b2\u00b3\7-\2\2\u00b3"+
		"\"\3\2\2\2\u00b4\u00b5\7/\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7,\2\2\u00b7"+
		"&\3\2\2\2\u00b8\u00b9\7\61\2\2\u00b9(\3\2\2\2\u00ba\u00bb\7\'\2\2\u00bb"+
		"*\3\2\2\2\u00bc\u00bd\7?\2\2\u00bd,\3\2\2\2\u00be\u00bf\7>\2\2\u00bf\u00c0"+
		"\7?\2\2\u00c0.\3\2\2\2\u00c1\u00c2\7>\2\2\u00c2\60\3\2\2\2\u00c3\u00c4"+
		"\7?\2\2\u00c4\u00c5\7?\2\2\u00c5\62\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c8"+
		"\7?\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7*\2\2\u00ca\66\3\2\2\2\u00cb\u00cc"+
		"\7+\2\2\u00cc8\3\2\2\2\u00cd\u00ce\7=\2\2\u00ce:\3\2\2\2\u00cf\u00d0\7"+
		"}\2\2\u00d0<\3\2\2\2\u00d1\u00d2\7\177\2\2\u00d2>\3\2\2\2\u00d3\u00d4"+
		"\7@\2\2\u00d4@\3\2\2\2\u00d5\u00d6\7@\2\2\u00d6\u00d7\7?\2\2\u00d7B\3"+
		"\2\2\2\u00d8\u00d9\7]\2\2\u00d9D\3\2\2\2\u00da\u00db\7_\2\2\u00dbF\3\2"+
		"\2\2\u00dc\u00dd\7.\2\2\u00ddH\3\2\2\2\u00de\u00df\7\60\2\2\u00dfJ\3\2"+
		"\2\2\u00e0\u00ef\5\3\2\2\u00e1\u00e3\5\5\3\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00f0\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea\5\5\3\2\u00e8\u00ea\7a\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00f0\5\5\3\2\u00ef\u00e4\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0L\3\2\2\2"+
		"\u00f1\u00f2\7\62\2\2\u00f2\u00f6\7z\2\2\u00f3\u00f4\7\62\2\2\u00f4\u00f6"+
		"\7Z\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00fb\t\5\2\2\u00f8\u00fa\t\3\2\2\u00f9\u00f8\3\2"+
		"\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u0100\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0100\t\6\2\2\u00ff\u00f5\3\2"+
		"\2\2\u00ff\u00fe\3\2\2\2\u0100N\3\2\2\2\u0101\u0102\7\62\2\2\u0102\u0106"+
		"\7z\2\2\u0103\u0104\7\62\2\2\u0104\u0106\7Z\2\2\u0105\u0101\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\5M"+
		"\'\2\u0108\u010c\7\60\2\2\u0109\u010b\5M\'\2\u010a\u0109\3\2\2\2\u010b"+
		"\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010dP\3\2\2\2"+
		"\u010e\u010c\3\2\2\2\u010f\u0111\t\7\2\2\u0110\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\b)\2\2\u0115R\3\2\2\2\23\2WZdjtz\u00e4\u00e9\u00eb\u00ef\u00f5"+
		"\u00fb\u00ff\u0105\u010c\u0112\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}