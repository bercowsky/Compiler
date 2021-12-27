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
		T__9=10, T__10=11, T__11=12, ML_COMMENT=13, COMMENT=14, TYPE=15, NUM=16, 
		LETTER=17, MES=18, MENYS=19, MULT=20, DIV=21, MOD=22, LT=23, LE=24, GT=25, 
		GE=26, DIFF=27, EQ=28, POW=29, LPAR=30, RPAR=31, LBRACKET=32, RBRACKET=33, 
		STRING=34, WS=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ML_COMMENT", "COMMENT", "TYPE", "NUM", "LETTER", 
			"MES", "MENYS", "MULT", "DIV", "MOD", "LT", "LE", "GT", "GE", "DIFF", 
			"EQ", "POW", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'if'", "'else'", "'while'", "'for'", "';'", "'read'", "'write'", 
			"'array'", "'get'", "'set'", "'='", null, null, "'void'", null, null, 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'<='", "'>'", "'>='", "'<>'", 
			"'=='", "'^'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ML_COMMENT", "COMMENT", "TYPE", "NUM", "LETTER", "MES", "MENYS", 
			"MULT", "DIV", "MOD", "LT", "LE", "GT", "GE", "DIFF", "EQ", "POW", "LPAR", 
			"RPAR", "LBRACKET", "RBRACKET", "STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00dd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u0080\n\16\f\16\16\16\u0083"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\7\17\u008c\n\17\f\17\16\17\u008f"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\5\21\u0099\n\21\3\21\6"+
		"\21\u009c\n\21\r\21\16\21\u009d\3\21\3\21\6\21\u00a2\n\21\r\21\16\21\u00a3"+
		"\5\21\u00a6\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\7#\u00d0"+
		"\n#\f#\16#\u00d3\13#\3#\3#\3$\6$\u00d8\n$\r$\16$\u00d9\3$\3$\3\u0081\2"+
		"%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%\3\2\7\4\2\f\f\17\17\3\2\62;\5\2C\\c|\u0082\u0101\3\2$$\4"+
		"\2\f\f\"\"\2\u00e5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5K\3\2\2\2\7N\3\2\2\2\tS\3\2\2\2\13Y\3"+
		"\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21d\3\2\2\2\23j\3\2\2\2\25p\3\2\2\2\27t"+
		"\3\2\2\2\31x\3\2\2\2\33z\3\2\2\2\35\u0089\3\2\2\2\37\u0092\3\2\2\2!\u0098"+
		"\3\2\2\2#\u00a7\3\2\2\2%\u00a9\3\2\2\2\'\u00ab\3\2\2\2)\u00ad\3\2\2\2"+
		"+\u00af\3\2\2\2-\u00b1\3\2\2\2/\u00b3\3\2\2\2\61\u00b5\3\2\2\2\63\u00b8"+
		"\3\2\2\2\65\u00ba\3\2\2\2\67\u00bd\3\2\2\29\u00c0\3\2\2\2;\u00c3\3\2\2"+
		"\2=\u00c5\3\2\2\2?\u00c7\3\2\2\2A\u00c9\3\2\2\2C\u00cb\3\2\2\2E\u00cd"+
		"\3\2\2\2G\u00d7\3\2\2\2IJ\7.\2\2J\4\3\2\2\2KL\7k\2\2LM\7h\2\2M\6\3\2\2"+
		"\2NO\7g\2\2OP\7n\2\2PQ\7u\2\2QR\7g\2\2R\b\3\2\2\2ST\7y\2\2TU\7j\2\2UV"+
		"\7k\2\2VW\7n\2\2WX\7g\2\2X\n\3\2\2\2YZ\7h\2\2Z[\7q\2\2[\\\7t\2\2\\\f\3"+
		"\2\2\2]^\7=\2\2^\16\3\2\2\2_`\7t\2\2`a\7g\2\2ab\7c\2\2bc\7f\2\2c\20\3"+
		"\2\2\2de\7y\2\2ef\7t\2\2fg\7k\2\2gh\7v\2\2hi\7g\2\2i\22\3\2\2\2jk\7c\2"+
		"\2kl\7t\2\2lm\7t\2\2mn\7c\2\2no\7{\2\2o\24\3\2\2\2pq\7i\2\2qr\7g\2\2r"+
		"s\7v\2\2s\26\3\2\2\2tu\7u\2\2uv\7g\2\2vw\7v\2\2w\30\3\2\2\2xy\7?\2\2y"+
		"\32\3\2\2\2z{\7%\2\2{|\7,\2\2|\u0081\3\2\2\2}\u0080\13\2\2\2~\u0080\t"+
		"\2\2\2\177}\3\2\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0081\177\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\7,\2\2\u0085\u0086\7%\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\16\2\2\u0088"+
		"\34\3\2\2\2\u0089\u008d\7%\2\2\u008a\u008c\n\2\2\2\u008b\u008a\3\2\2\2"+
		"\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\b\17\2\2\u0091\36\3\2\2\2\u0092"+
		"\u0093\7x\2\2\u0093\u0094\7q\2\2\u0094\u0095\7k\2\2\u0095\u0096\7f\2\2"+
		"\u0096 \3\2\2\2\u0097\u0099\7/\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\3\2\2\2\u009a\u009c\t\3\2\2\u009b\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a5\3\2"+
		"\2\2\u009f\u00a1\7\60\2\2\u00a0\u00a2\t\3\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2"+
		"\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\"\3\2\2\2\u00a7\u00a8"+
		"\t\4\2\2\u00a8$\3\2\2\2\u00a9\u00aa\7-\2\2\u00aa&\3\2\2\2\u00ab\u00ac"+
		"\7/\2\2\u00ac(\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae*\3\2\2\2\u00af\u00b0\7"+
		"\61\2\2\u00b0,\3\2\2\2\u00b1\u00b2\7\'\2\2\u00b2.\3\2\2\2\u00b3\u00b4"+
		"\7>\2\2\u00b4\60\3\2\2\2\u00b5\u00b6\7>\2\2\u00b6\u00b7\7?\2\2\u00b7\62"+
		"\3\2\2\2\u00b8\u00b9\7@\2\2\u00b9\64\3\2\2\2\u00ba\u00bb\7@\2\2\u00bb"+
		"\u00bc\7?\2\2\u00bc\66\3\2\2\2\u00bd\u00be\7>\2\2\u00be\u00bf\7@\2\2\u00bf"+
		"8\3\2\2\2\u00c0\u00c1\7?\2\2\u00c1\u00c2\7?\2\2\u00c2:\3\2\2\2\u00c3\u00c4"+
		"\7`\2\2\u00c4<\3\2\2\2\u00c5\u00c6\7*\2\2\u00c6>\3\2\2\2\u00c7\u00c8\7"+
		"+\2\2\u00c8@\3\2\2\2\u00c9\u00ca\7}\2\2\u00caB\3\2\2\2\u00cb\u00cc\7\177"+
		"\2\2\u00ccD\3\2\2\2\u00cd\u00d1\7$\2\2\u00ce\u00d0\n\5\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7$\2\2\u00d5F\3\2\2\2\u00d6"+
		"\u00d8\t\6\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b$\2\2\u00dc"+
		"H\3\2\2\2\f\2\177\u0081\u008d\u0098\u009d\u00a3\u00a5\u00d1\u00d9\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}