// Generated from /Users/andresbercowskyrama/Desktop/UNI/5-Cuatri/LP/Práctica_compilador/Compiler/Expr.g by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, COMMENT=13, TYPE=14, NUM=15, LETTER=16, MES=17, 
		MENYS=18, MULT=19, DIV=20, MOD=21, LT=22, LE=23, GT=24, GE=25, DIFF=26, 
		EQ=27, POW=28, LPAR=29, RPAR=30, LBRACKET=31, RBRACKET=32, STRING=33, 
		WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "COMMENT", "TYPE", "NUM", "LETTER", "MES", 
			"MENYS", "MULT", "DIV", "MOD", "LT", "LE", "GT", "GE", "DIFF", "EQ", 
			"POW", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'if'", "'else'", "'while'", "'for'", "';'", "'read'", "'write'", 
			"'array'", "'get'", "'set'", "'='", null, "'void'", null, null, "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'<'", "'<='", "'>'", "'>='", "'<>'", "'=='", 
			"'^'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "COMMENT", "TYPE", "NUM", "LETTER", "MES", "MENYS", "MULT", "DIV", 
			"MOD", "LT", "LE", "GT", "GE", "DIFF", "EQ", "POW", "LPAR", "RPAR", "LBRACKET", 
			"RBRACKET", "STRING", "WS"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00cc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\7\16{\n\16\f\16\16\16~\13\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\5\20\u0088\n\20\3\20\6\20\u008b\n\20\r\20\16\20\u008c"+
		"\3\20\3\20\6\20\u0091\n\20\r\20\16\20\u0092\5\20\u0095\n\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\7\"\u00bf\n\"\f\"\16\"\u00c2"+
		"\13\"\3\"\3\"\3#\6#\u00c7\n#\r#\16#\u00c8\3#\3#\2\2$\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\7\4"+
		"\2\f\f\17\17\3\2\62;\5\2C\\c|\u0082\u0101\3\2$$\4\2\f\f\"\"\2\u00d2\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2"+
		"\5I\3\2\2\2\7L\3\2\2\2\tQ\3\2\2\2\13W\3\2\2\2\r[\3\2\2\2\17]\3\2\2\2\21"+
		"b\3\2\2\2\23h\3\2\2\2\25n\3\2\2\2\27r\3\2\2\2\31v\3\2\2\2\33x\3\2\2\2"+
		"\35\u0081\3\2\2\2\37\u0087\3\2\2\2!\u0096\3\2\2\2#\u0098\3\2\2\2%\u009a"+
		"\3\2\2\2\'\u009c\3\2\2\2)\u009e\3\2\2\2+\u00a0\3\2\2\2-\u00a2\3\2\2\2"+
		"/\u00a4\3\2\2\2\61\u00a7\3\2\2\2\63\u00a9\3\2\2\2\65\u00ac\3\2\2\2\67"+
		"\u00af\3\2\2\29\u00b2\3\2\2\2;\u00b4\3\2\2\2=\u00b6\3\2\2\2?\u00b8\3\2"+
		"\2\2A\u00ba\3\2\2\2C\u00bc\3\2\2\2E\u00c6\3\2\2\2GH\7.\2\2H\4\3\2\2\2"+
		"IJ\7k\2\2JK\7h\2\2K\6\3\2\2\2LM\7g\2\2MN\7n\2\2NO\7u\2\2OP\7g\2\2P\b\3"+
		"\2\2\2QR\7y\2\2RS\7j\2\2ST\7k\2\2TU\7n\2\2UV\7g\2\2V\n\3\2\2\2WX\7h\2"+
		"\2XY\7q\2\2YZ\7t\2\2Z\f\3\2\2\2[\\\7=\2\2\\\16\3\2\2\2]^\7t\2\2^_\7g\2"+
		"\2_`\7c\2\2`a\7f\2\2a\20\3\2\2\2bc\7y\2\2cd\7t\2\2de\7k\2\2ef\7v\2\2f"+
		"g\7g\2\2g\22\3\2\2\2hi\7c\2\2ij\7t\2\2jk\7t\2\2kl\7c\2\2lm\7{\2\2m\24"+
		"\3\2\2\2no\7i\2\2op\7g\2\2pq\7v\2\2q\26\3\2\2\2rs\7u\2\2st\7g\2\2tu\7"+
		"v\2\2u\30\3\2\2\2vw\7?\2\2w\32\3\2\2\2x|\7%\2\2y{\n\2\2\2zy\3\2\2\2{~"+
		"\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\b\16\2\2"+
		"\u0080\34\3\2\2\2\u0081\u0082\7x\2\2\u0082\u0083\7q\2\2\u0083\u0084\7"+
		"k\2\2\u0084\u0085\7f\2\2\u0085\36\3\2\2\2\u0086\u0088\7/\2\2\u0087\u0086"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u008b\t\3\2\2\u008a"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u0094\3\2\2\2\u008e\u0090\7\60\2\2\u008f\u0091\t\3\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0095\3\2\2\2\u0094\u008e\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		" \3\2\2\2\u0096\u0097\t\4\2\2\u0097\"\3\2\2\2\u0098\u0099\7-\2\2\u0099"+
		"$\3\2\2\2\u009a\u009b\7/\2\2\u009b&\3\2\2\2\u009c\u009d\7,\2\2\u009d("+
		"\3\2\2\2\u009e\u009f\7\61\2\2\u009f*\3\2\2\2\u00a0\u00a1\7\'\2\2\u00a1"+
		",\3\2\2\2\u00a2\u00a3\7>\2\2\u00a3.\3\2\2\2\u00a4\u00a5\7>\2\2\u00a5\u00a6"+
		"\7?\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\62\3\2\2\2\u00a9\u00aa"+
		"\7@\2\2\u00aa\u00ab\7?\2\2\u00ab\64\3\2\2\2\u00ac\u00ad\7>\2\2\u00ad\u00ae"+
		"\7@\2\2\u00ae\66\3\2\2\2\u00af\u00b0\7?\2\2\u00b0\u00b1\7?\2\2\u00b18"+
		"\3\2\2\2\u00b2\u00b3\7`\2\2\u00b3:\3\2\2\2\u00b4\u00b5\7*\2\2\u00b5<\3"+
		"\2\2\2\u00b6\u00b7\7+\2\2\u00b7>\3\2\2\2\u00b8\u00b9\7}\2\2\u00b9@\3\2"+
		"\2\2\u00ba\u00bb\7\177\2\2\u00bbB\3\2\2\2\u00bc\u00c0\7$\2\2\u00bd\u00bf"+
		"\n\5\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7$"+
		"\2\2\u00c4D\3\2\2\2\u00c5\u00c7\t\6\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\b#\2\2\u00cbF\3\2\2\2\n\2|\u0087\u008c\u0092\u0094\u00c0\u00c8"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}