// Generated from robot.g4 by ANTLR 4.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class robotLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, WS=9, 
		CONST=10, SIGNED=11, UNSIGNED=12, CELL=13, MATRIX=14, TOP=15, RIGHT=16, 
		DOWN=17, LEFT=18, NTOP=19, NRIGHT=20, NDOWN=21, NLEFT=22, TESTREP=23, 
		TESTONCE=24, CALL=25, START=26, FUNC=27, IDENT=28, UNUMBER=29, SNUMBER=30, 
		SEMICOLON=31, MUL=32, DIV=33, ADD=34, SUB=35, MOD=36, MORE=37, LESS=38, 
		EQUALLY=39, ELSE=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "'mapping'", "','", "'['", "'('", "'put'", "'<-'", "WS", 
		"'const'", "'signed'", "'unsigned'", "'cell'", "'matrix'", "'top'", "'right'", 
		"'down'", "'left'", "'ntop'", "'nright'", "'ndown'", "'nleft'", "'testrep'", 
		"'testonce'", "'call'", "'start'", "'func'", "IDENT", "UNUMBER", "SNUMBER", 
		"';'", "'*'", "'/'", "'+'", "'-'", "'%'", "'>'", "'<'", "'='", "'else'"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "LETTER", 
		"DIGIT", "WS", "CONST", "SIGNED", "UNSIGNED", "CELL", "MATRIX", "TOP", 
		"RIGHT", "DOWN", "LEFT", "NTOP", "NRIGHT", "NDOWN", "NLEFT", "TESTREP", 
		"TESTONCE", "CALL", "START", "FUNC", "IDENT", "UNUMBER", "SNUMBER", "SEMICOLON", 
		"MUL", "DIV", "ADD", "SUB", "MOD", "MORE", "LESS", "EQUALLY", "ELSE"
	};


	public robotLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "robot.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u0114\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\6\13t\n\13\r\13\16\13u\3\f\6"+
		"\fy\n\f\r\f\16\fz\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u00f1\n\37\f\37\16\37\u00f4\13\37"+
		"\3 \3 \3 \3!\5!\u00fa\n!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\2\25\2\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26"+
		"/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*\3"+
		"\2\4\5\2C\\aac|\5\2\13\f\17\17\"\"\u0116\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7[\3\2\2\2\tc\3\2\2\2\13"+
		"e\3\2\2\2\rg\3\2\2\2\17i\3\2\2\2\21m\3\2\2\2\23p\3\2\2\2\25s\3\2\2\2\27"+
		"x\3\2\2\2\31~\3\2\2\2\33\u0084\3\2\2\2\35\u008b\3\2\2\2\37\u0094\3\2\2"+
		"\2!\u0099\3\2\2\2#\u00a0\3\2\2\2%\u00a4\3\2\2\2\'\u00aa\3\2\2\2)\u00af"+
		"\3\2\2\2+\u00b4\3\2\2\2-\u00b9\3\2\2\2/\u00c0\3\2\2\2\61\u00c6\3\2\2\2"+
		"\63\u00cc\3\2\2\2\65\u00d4\3\2\2\2\67\u00dd\3\2\2\29\u00e2\3\2\2\2;\u00e8"+
		"\3\2\2\2=\u00ed\3\2\2\2?\u00f5\3\2\2\2A\u00f9\3\2\2\2C\u00fd\3\2\2\2E"+
		"\u00ff\3\2\2\2G\u0101\3\2\2\2I\u0103\3\2\2\2K\u0105\3\2\2\2M\u0107\3\2"+
		"\2\2O\u0109\3\2\2\2Q\u010b\3\2\2\2S\u010d\3\2\2\2U\u010f\3\2\2\2WX\7_"+
		"\2\2X\4\3\2\2\2YZ\7+\2\2Z\6\3\2\2\2[\\\7o\2\2\\]\7c\2\2]^\7r\2\2^_\7r"+
		"\2\2_`\7k\2\2`a\7p\2\2ab\7i\2\2b\b\3\2\2\2cd\7.\2\2d\n\3\2\2\2ef\7]\2"+
		"\2f\f\3\2\2\2gh\7*\2\2h\16\3\2\2\2ij\7r\2\2jk\7w\2\2kl\7v\2\2l\20\3\2"+
		"\2\2mn\7>\2\2no\7/\2\2o\22\3\2\2\2pq\t\2\2\2q\24\3\2\2\2rt\4\62;\2sr\3"+
		"\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2v\26\3\2\2\2wy\t\3\2\2xw\3\2\2\2y"+
		"z\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\b\f\2\2}\30\3\2\2\2~\177\7e"+
		"\2\2\177\u0080\7q\2\2\u0080\u0081\7p\2\2\u0081\u0082\7u\2\2\u0082\u0083"+
		"\7v\2\2\u0083\32\3\2\2\2\u0084\u0085\7u\2\2\u0085\u0086\7k\2\2\u0086\u0087"+
		"\7i\2\2\u0087\u0088\7p\2\2\u0088\u0089\7g\2\2\u0089\u008a\7f\2\2\u008a"+
		"\34\3\2\2\2\u008b\u008c\7w\2\2\u008c\u008d\7p\2\2\u008d\u008e\7u\2\2\u008e"+
		"\u008f\7k\2\2\u008f\u0090\7i\2\2\u0090\u0091\7p\2\2\u0091\u0092\7g\2\2"+
		"\u0092\u0093\7f\2\2\u0093\36\3\2\2\2\u0094\u0095\7e\2\2\u0095\u0096\7"+
		"g\2\2\u0096\u0097\7n\2\2\u0097\u0098\7n\2\2\u0098 \3\2\2\2\u0099\u009a"+
		"\7o\2\2\u009a\u009b\7c\2\2\u009b\u009c\7v\2\2\u009c\u009d\7t\2\2\u009d"+
		"\u009e\7k\2\2\u009e\u009f\7z\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7v\2\2\u00a1"+
		"\u00a2\7q\2\2\u00a2\u00a3\7r\2\2\u00a3$\3\2\2\2\u00a4\u00a5\7t\2\2\u00a5"+
		"\u00a6\7k\2\2\u00a6\u00a7\7i\2\2\u00a7\u00a8\7j\2\2\u00a8\u00a9\7v\2\2"+
		"\u00a9&\3\2\2\2\u00aa\u00ab\7f\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7y\2"+
		"\2\u00ad\u00ae\7p\2\2\u00ae(\3\2\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7"+
		"g\2\2\u00b1\u00b2\7h\2\2\u00b2\u00b3\7v\2\2\u00b3*\3\2\2\2\u00b4\u00b5"+
		"\7p\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7r\2\2\u00b8"+
		",\3\2\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7k\2\2\u00bc"+
		"\u00bd\7i\2\2\u00bd\u00be\7j\2\2\u00be\u00bf\7v\2\2\u00bf.\3\2\2\2\u00c0"+
		"\u00c1\7p\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7y\2\2"+
		"\u00c4\u00c5\7p\2\2\u00c5\60\3\2\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7"+
		"n\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7v\2\2\u00cb\62"+
		"\3\2\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7u\2\2\u00cf"+
		"\u00d0\7v\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7r\2\2"+
		"\u00d3\64\3\2\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7"+
		"u\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7p\2\2\u00da\u00db"+
		"\7e\2\2\u00db\u00dc\7g\2\2\u00dc\66\3\2\2\2\u00dd\u00de\7e\2\2\u00de\u00df"+
		"\7c\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7n\2\2\u00e18\3\2\2\2\u00e2\u00e3"+
		"\7u\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7t\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7:\3\2\2\2\u00e8\u00e9\7h\2\2\u00e9\u00ea\7w\2\2\u00ea"+
		"\u00eb\7p\2\2\u00eb\u00ec\7e\2\2\u00ec<\3\2\2\2\u00ed\u00f2\5\23\n\2\u00ee"+
		"\u00f1\5\23\n\2\u00ef\u00f1\5\25\13\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		">\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\5\25\13\2\u00f6\u00f7\7w\2\2"+
		"\u00f7@\3\2\2\2\u00f8\u00fa\7/\2\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\5\25\13\2\u00fcB\3\2\2\2\u00fd\u00fe"+
		"\7=\2\2\u00feD\3\2\2\2\u00ff\u0100\7,\2\2\u0100F\3\2\2\2\u0101\u0102\7"+
		"\61\2\2\u0102H\3\2\2\2\u0103\u0104\7-\2\2\u0104J\3\2\2\2\u0105\u0106\7"+
		"/\2\2\u0106L\3\2\2\2\u0107\u0108\7\'\2\2\u0108N\3\2\2\2\u0109\u010a\7"+
		"@\2\2\u010aP\3\2\2\2\u010b\u010c\7>\2\2\u010cR\3\2\2\2\u010d\u010e\7?"+
		"\2\2\u010eT\3\2\2\2\u010f\u0110\7g\2\2\u0110\u0111\7n\2\2\u0111\u0112"+
		"\7u\2\2\u0112\u0113\7g\2\2\u0113V\3\2\2\2\b\2uz\u00f0\u00f2\u00f9\3\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}