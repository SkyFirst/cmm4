package antlr;// Generated from D:/java_project/cmm4/src\cmmGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class cmmGrammarParser extends Parser {
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
	public static final int
		RULE_prog = 0, RULE_stmt = 1, RULE_stmtblock = 2, RULE_lbrace = 3, RULE_rbrace = 4, 
		RULE_varstmt = 5, RULE_assign = 6, RULE_defarray = 7, RULE_arrayValue = 8, 
		RULE_array = 9, RULE_type = 10, RULE_ifstmt = 11, RULE_whilestmt = 12, 
		RULE_breakstmt = 13, RULE_readstmt = 14, RULE_writestmt = 15, RULE_value = 16, 
		RULE_writeValue = 17, RULE_assignstmt = 18, RULE_exper = 19;
	public static final String[] ruleNames = {
		"prog", "stmt", "stmtblock", "lbrace", "rbrace", "varstmt", "assign", 
		"defarray", "arrayValue", "array", "type", "ifstmt", "whilestmt", "breakstmt", 
		"readstmt", "writestmt", "value", "writeValue", "assignstmt", "exper"
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

	@Override
	public String getGrammarFileName() { return "cmmGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public cmmGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << BREAK) | (1L << INT) | (1L << DOUBLE) | (1L << SEMI) | (1L << LBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(40);
				stmt();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public VarstmtContext varstmt() {
			return getRuleContext(VarstmtContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public WhilestmtContext whilestmt() {
			return getRuleContext(WhilestmtContext.class,0);
		}
		public AssignstmtContext assignstmt() {
			return getRuleContext(AssignstmtContext.class,0);
		}
		public ReadstmtContext readstmt() {
			return getRuleContext(ReadstmtContext.class,0);
		}
		public WritestmtContext writestmt() {
			return getRuleContext(WritestmtContext.class,0);
		}
		public StmtblockContext stmtblock() {
			return getRuleContext(StmtblockContext.class,0);
		}
		public BreakstmtContext breakstmt() {
			return getRuleContext(BreakstmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cmmGrammarParser.SEMI, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(55);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				varstmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				ifstmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				whilestmt();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				assignstmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				readstmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				writestmt();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				stmtblock();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 8);
				{
				setState(53);
				breakstmt();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 9);
				{
				setState(54);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtblockContext extends ParserRuleContext {
		public LbraceContext lbrace() {
			return getRuleContext(LbraceContext.class,0);
		}
		public RbraceContext rbrace() {
			return getRuleContext(RbraceContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterStmtblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitStmtblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitStmtblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtblockContext stmtblock() throws RecognitionException {
		StmtblockContext _localctx = new StmtblockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmtblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			lbrace();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << BREAK) | (1L << INT) | (1L << DOUBLE) | (1L << SEMI) | (1L << LBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(58);
				stmt();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			rbrace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LbraceContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(cmmGrammarParser.LBRACE, 0); }
		public LbraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lbrace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterLbrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitLbrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitLbrace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LbraceContext lbrace() throws RecognitionException {
		LbraceContext _localctx = new LbraceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lbrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(LBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RbraceContext extends ParserRuleContext {
		public TerminalNode RBRACE() { return getToken(cmmGrammarParser.RBRACE, 0); }
		public RbraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rbrace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterRbrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitRbrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitRbrace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RbraceContext rbrace() throws RecognitionException {
		RbraceContext _localctx = new RbraceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rbrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarstmtContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cmmGrammarParser.SEMI, 0); }
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<DefarrayContext> defarray() {
			return getRuleContexts(DefarrayContext.class);
		}
		public DefarrayContext defarray(int i) {
			return getRuleContext(DefarrayContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(cmmGrammarParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(cmmGrammarParser.COM, i);
		}
		public VarstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterVarstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitVarstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitVarstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarstmtContext varstmt() throws RecognitionException {
		VarstmtContext _localctx = new VarstmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			type();
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(71);
				assign();
				}
				break;
			case 2:
				{
				setState(72);
				defarray();
				}
				break;
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(75);
				match(COM);
				setState(78);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(76);
					assign();
					}
					break;
				case 2:
					{
					setState(77);
					defarray();
					}
					break;
				}
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(cmmGrammarParser.ID, 0); }
		public ExperContext exper() {
			return getRuleContext(ExperContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(ID);
			setState(90);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(88);
				match(ASSIGN);
				setState(89);
				exper(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefarrayContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayValueContext arrayValue() {
			return getRuleContext(ArrayValueContext.class,0);
		}
		public DefarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defarray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterDefarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitDefarray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitDefarray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefarrayContext defarray() throws RecognitionException {
		DefarrayContext _localctx = new DefarrayContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defarray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			array();
			setState(94);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(93);
				arrayValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayValueContext extends ParserRuleContext {
		public List<ExperContext> exper() {
			return getRuleContexts(ExperContext.class);
		}
		public ExperContext exper(int i) {
			return getRuleContext(ExperContext.class,i);
		}
		public ArrayValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitArrayValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayValueContext arrayValue() throws RecognitionException {
		ArrayValueContext _localctx = new ArrayValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ASSIGN);
			setState(97);
			match(LBRACE);
			setState(107);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case MINUS:
			case LPARENT:
			case ID:
			case LITERAL_INT:
			case LITERAL_REAL:
				{
				setState(98);
				exper(0);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(99);
					match(COM);
					setState(100);
					exper(0);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RBRACE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(109);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(cmmGrammarParser.ID, 0); }
		public TerminalNode LBRACKET() { return getToken(cmmGrammarParser.LBRACKET, 0); }
		public ExperContext exper() {
			return getRuleContext(ExperContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(cmmGrammarParser.RBRACKET, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(ID);
			setState(112);
			match(LBRACKET);
			setState(113);
			exper(0);
			setState(114);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(cmmGrammarParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(cmmGrammarParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstmtContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(cmmGrammarParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(cmmGrammarParser.IF, i);
		}
		public List<TerminalNode> LPARENT() { return getTokens(cmmGrammarParser.LPARENT); }
		public TerminalNode LPARENT(int i) {
			return getToken(cmmGrammarParser.LPARENT, i);
		}
		public List<ExperContext> exper() {
			return getRuleContexts(ExperContext.class);
		}
		public ExperContext exper(int i) {
			return getRuleContext(ExperContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(cmmGrammarParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(cmmGrammarParser.ELSE, i);
		}
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IF);
			setState(119);
			match(LPARENT);
			setState(120);
			exper(0);
			setState(121);
			match(RPARENT);
			setState(122);
			stmt();
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					match(ELSE);
					setState(124);
					match(IF);
					setState(125);
					match(LPARENT);
					setState(126);
					exper(0);
					setState(127);
					match(RPARENT);
					setState(128);
					stmt();
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(135);
				match(ELSE);
				setState(136);
				stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhilestmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(cmmGrammarParser.WHILE, 0); }
		public TerminalNode LPARENT() { return getToken(cmmGrammarParser.LPARENT, 0); }
		public ExperContext exper() {
			return getRuleContext(ExperContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitWhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(WHILE);
			setState(140);
			match(LPARENT);
			setState(141);
			exper(0);
			setState(142);
			match(RPARENT);
			setState(143);
			stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakstmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(cmmGrammarParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(cmmGrammarParser.SEMI, 0); }
		public BreakstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterBreakstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitBreakstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitBreakstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakstmtContext breakstmt() throws RecognitionException {
		BreakstmtContext _localctx = new BreakstmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_breakstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(BREAK);
			setState(146);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadstmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(cmmGrammarParser.READ, 0); }
		public TerminalNode LPARENT() { return getToken(cmmGrammarParser.LPARENT, 0); }
		public WriteValueContext writeValue() {
			return getRuleContext(WriteValueContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cmmGrammarParser.SEMI, 0); }
		public ReadstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterReadstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitReadstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitReadstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadstmtContext readstmt() throws RecognitionException {
		ReadstmtContext _localctx = new ReadstmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_readstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(READ);
			setState(149);
			match(LPARENT);
			setState(150);
			writeValue();
			setState(151);
			match(RPARENT);
			setState(152);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WritestmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(cmmGrammarParser.WRITE, 0); }
		public TerminalNode LPARENT() { return getToken(cmmGrammarParser.LPARENT, 0); }
		public ExperContext exper() {
			return getRuleContext(ExperContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cmmGrammarParser.SEMI, 0); }
		public WritestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterWritestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitWritestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitWritestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritestmtContext writestmt() throws RecognitionException {
		WritestmtContext _localctx = new WritestmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_writestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(WRITE);
			setState(155);
			match(LPARENT);
			setState(156);
			exper(0);
			setState(157);
			match(RPARENT);
			setState(158);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(cmmGrammarParser.ID, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				array();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(cmmGrammarParser.ID, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public WriteValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterWriteValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitWriteValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitWriteValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteValueContext writeValue() throws RecognitionException {
		WriteValueContext _localctx = new WriteValueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_writeValue);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				array();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignstmtContext extends ParserRuleContext {
		public WriteValueContext writeValue() {
			return getRuleContext(WriteValueContext.class,0);
		}
		public ExperContext exper() {
			return getRuleContext(ExperContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cmmGrammarParser.SEMI, 0); }
		public AssignstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterAssignstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitAssignstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitAssignstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignstmtContext assignstmt() throws RecognitionException {
		AssignstmtContext _localctx = new AssignstmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			writeValue();
			setState(169);
			match(ASSIGN);
			setState(170);
			exper(0);
			setState(171);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExperContext extends ParserRuleContext {
		public ExperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exper; }
	 
		public ExperContext() { }
		public void copyFrom(ExperContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompareExContext extends ExperContext {
		public Token op;
		public List<ExperContext> exper() {
			return getRuleContexts(ExperContext.class);
		}
		public ExperContext exper(int i) {
			return getRuleContext(ExperContext.class,i);
		}
		public TerminalNode LT() { return getToken(cmmGrammarParser.LT, 0); }
		public TerminalNode LET() { return getToken(cmmGrammarParser.LET, 0); }
		public TerminalNode GT() { return getToken(cmmGrammarParser.GT, 0); }
		public TerminalNode GET() { return getToken(cmmGrammarParser.GET, 0); }
		public TerminalNode EQ() { return getToken(cmmGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(cmmGrammarParser.NEQ, 0); }
		public CompareExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterCompareEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitCompareEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitCompareEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealExContext extends ExperContext {
		public TerminalNode LITERAL_REAL() { return getToken(cmmGrammarParser.LITERAL_REAL, 0); }
		public RealExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterRealEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitRealEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitRealEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BraceExContext extends ExperContext {
		public ExperContext exper() {
			return getRuleContext(ExperContext.class,0);
		}
		public BraceExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterBraceEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitBraceEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitBraceEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusNumExContext extends ExperContext {
		public ExperContext exper() {
			return getRuleContext(ExperContext.class,0);
		}
		public MinusNumExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterMinusNumEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitMinusNumEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitMinusNumEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExContext extends ExperContext {
		public TerminalNode LITERAL_INT() { return getToken(cmmGrammarParser.LITERAL_INT, 0); }
		public IntExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterIntEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitIntEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitIntEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExContext extends ExperContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterValueEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitValueEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitValueEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExContext extends ExperContext {
		public Token op;
		public List<ExperContext> exper() {
			return getRuleContexts(ExperContext.class);
		}
		public ExperContext exper(int i) {
			return getRuleContext(ExperContext.class,i);
		}
		public AddSubExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterAddSubEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitAddSubEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitAddSubEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueExContext extends ExperContext {
		public TerminalNode TRUE() { return getToken(cmmGrammarParser.TRUE, 0); }
		public TrueExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterTrueEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitTrueEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitTrueEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivExContext extends ExperContext {
		public Token op;
		public List<ExperContext> exper() {
			return getRuleContexts(ExperContext.class);
		}
		public ExperContext exper(int i) {
			return getRuleContext(ExperContext.class,i);
		}
		public MulDivExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterMulDivEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitMulDivEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitMulDivEx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseExContext extends ExperContext {
		public TerminalNode FALSE() { return getToken(cmmGrammarParser.FALSE, 0); }
		public FalseExContext(ExperContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).enterFalseEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmGrammarListener ) ((cmmGrammarListener)listener).exitFalseEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmGrammarVisitor ) return ((cmmGrammarVisitor<? extends T>)visitor).visitFalseEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExperContext exper() throws RecognitionException {
		return exper(0);
	}

	private ExperContext exper(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExperContext _localctx = new ExperContext(_ctx, _parentState);
		ExperContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exper, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new MinusNumExContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(174);
				match(MINUS);
				setState(175);
				exper(10);
				}
				break;
			case LPARENT:
				{
				_localctx = new BraceExContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(LPARENT);
				setState(177);
				exper(0);
				setState(178);
				match(RPARENT);
				}
				break;
			case TRUE:
				{
				_localctx = new TrueExContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				_localctx = new FalseExContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(FALSE);
				}
				break;
			case ID:
				{
				_localctx = new ValueExContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				value();
				}
				break;
			case LITERAL_INT:
				{
				_localctx = new IntExContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(LITERAL_INT);
				}
				break;
			case LITERAL_REAL:
				{
				_localctx = new RealExContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(LITERAL_REAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(196);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExContext(new ExperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exper);
						setState(187);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(188);
						((MulDivExContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivExContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(189);
						exper(10);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExContext(new ExperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exper);
						setState(190);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(191);
						((AddSubExContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubExContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(192);
						exper(9);
						}
						break;
					case 3:
						{
						_localctx = new CompareExContext(new ExperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exper);
						setState(193);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(194);
						((CompareExContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LET) | (1L << LT) | (1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << GET))) != 0)) ) {
							((CompareExContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(195);
						exper(8);
						}
						break;
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return exper_sempred((ExperContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exper_sempred(ExperContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u00cc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7L\n\7\3\7\3\7\3\7\5\7Q\n\7\7\7S\n"+
		"\7\f\7\16\7V\13\7\3\7\3\7\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\5\ta\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\7\nh\n\n\f\n\16\nk\13\n\3\n\5\nn\n\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u0085\n\r\f\r\16\r\u0088\13\r\3\r\3\r\5\r\u008c\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00a5\n\22\3\23\3\23\5\23\u00a9"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u00bc\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u00c7\n\25\f\25\16\25\u00ca\13\25\3\25\2\3(\26\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\6\3\2\13\f\3\2\21\23\3\2\17\20"+
		"\4\2\25\30\36\37\u00d5\2-\3\2\2\2\49\3\2\2\2\6;\3\2\2\2\bD\3\2\2\2\nF"+
		"\3\2\2\2\fH\3\2\2\2\16Y\3\2\2\2\20^\3\2\2\2\22b\3\2\2\2\24q\3\2\2\2\26"+
		"v\3\2\2\2\30x\3\2\2\2\32\u008d\3\2\2\2\34\u0093\3\2\2\2\36\u0096\3\2\2"+
		"\2 \u009c\3\2\2\2\"\u00a4\3\2\2\2$\u00a8\3\2\2\2&\u00aa\3\2\2\2(\u00bb"+
		"\3\2\2\2*,\5\4\3\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\3\3\2\2\2"+
		"/-\3\2\2\2\60:\5\f\7\2\61:\5\30\r\2\62:\5\32\16\2\63:\5&\24\2\64:\5\36"+
		"\20\2\65:\5 \21\2\66:\5\6\4\2\67:\5\34\17\28:\7\33\2\29\60\3\2\2\29\61"+
		"\3\2\2\29\62\3\2\2\29\63\3\2\2\29\64\3\2\2\29\65\3\2\2\29\66\3\2\2\29"+
		"\67\3\2\2\298\3\2\2\2:\5\3\2\2\2;?\5\b\5\2<>\5\4\3\2=<\3\2\2\2>A\3\2\2"+
		"\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\5\n\6\2C\7\3\2\2\2DE\7\34"+
		"\2\2E\t\3\2\2\2FG\7\35\2\2G\13\3\2\2\2HK\5\26\f\2IL\5\16\b\2JL\5\20\t"+
		"\2KI\3\2\2\2KJ\3\2\2\2LT\3\2\2\2MP\7\"\2\2NQ\5\16\b\2OQ\5\20\t\2PN\3\2"+
		"\2\2PO\3\2\2\2QS\3\2\2\2RM\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2"+
		"\2\2VT\3\2\2\2WX\7\33\2\2X\r\3\2\2\2Y\\\7$\2\2Z[\7\24\2\2[]\5(\25\2\\"+
		"Z\3\2\2\2\\]\3\2\2\2]\17\3\2\2\2^`\5\24\13\2_a\5\22\n\2`_\3\2\2\2`a\3"+
		"\2\2\2a\21\3\2\2\2bc\7\24\2\2cm\7\34\2\2di\5(\25\2ef\7\"\2\2fh\5(\25\2"+
		"ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jn\3\2\2\2ki\3\2\2\2ln\3\2\2\2"+
		"md\3\2\2\2ml\3\2\2\2no\3\2\2\2op\7\35\2\2p\23\3\2\2\2qr\7$\2\2rs\7 \2"+
		"\2st\5(\25\2tu\7!\2\2u\25\3\2\2\2vw\t\2\2\2w\27\3\2\2\2xy\7\5\2\2yz\7"+
		"\31\2\2z{\5(\25\2{|\7\32\2\2|\u0086\5\4\3\2}~\7\6\2\2~\177\7\5\2\2\177"+
		"\u0080\7\31\2\2\u0080\u0081\5(\25\2\u0081\u0082\7\32\2\2\u0082\u0083\5"+
		"\4\3\2\u0083\u0085\3\2\2\2\u0084}\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008b\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\7\6\2\2\u008a\u008c\5\4\3\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\31\3\2\2\2\u008d\u008e\7\7\2\2\u008e\u008f\7\31\2\2\u008f\u0090"+
		"\5(\25\2\u0090\u0091\7\32\2\2\u0091\u0092\5\4\3\2\u0092\33\3\2\2\2\u0093"+
		"\u0094\7\n\2\2\u0094\u0095\7\33\2\2\u0095\35\3\2\2\2\u0096\u0097\7\b\2"+
		"\2\u0097\u0098\7\31\2\2\u0098\u0099\5$\23\2\u0099\u009a\7\32\2\2\u009a"+
		"\u009b\7\33\2\2\u009b\37\3\2\2\2\u009c\u009d\7\t\2\2\u009d\u009e\7\31"+
		"\2\2\u009e\u009f\5(\25\2\u009f\u00a0\7\32\2\2\u00a0\u00a1\7\33\2\2\u00a1"+
		"!\3\2\2\2\u00a2\u00a5\7$\2\2\u00a3\u00a5\5\24\13\2\u00a4\u00a2\3\2\2\2"+
		"\u00a4\u00a3\3\2\2\2\u00a5#\3\2\2\2\u00a6\u00a9\7$\2\2\u00a7\u00a9\5\24"+
		"\13\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9%\3\2\2\2\u00aa\u00ab"+
		"\5$\23\2\u00ab\u00ac\7\24\2\2\u00ac\u00ad\5(\25\2\u00ad\u00ae\7\33\2\2"+
		"\u00ae\'\3\2\2\2\u00af\u00b0\b\25\1\2\u00b0\u00b1\7\20\2\2\u00b1\u00bc"+
		"\5(\25\f\u00b2\u00b3\7\31\2\2\u00b3\u00b4\5(\25\2\u00b4\u00b5\7\32\2\2"+
		"\u00b5\u00bc\3\2\2\2\u00b6\u00bc\7\r\2\2\u00b7\u00bc\7\16\2\2\u00b8\u00bc"+
		"\5\"\22\2\u00b9\u00bc\7%\2\2\u00ba\u00bc\7&\2\2\u00bb\u00af\3\2\2\2\u00bb"+
		"\u00b2\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bb\u00b8\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00c8\3\2\2\2\u00bd"+
		"\u00be\f\13\2\2\u00be\u00bf\t\3\2\2\u00bf\u00c7\5(\25\f\u00c0\u00c1\f"+
		"\n\2\2\u00c1\u00c2\t\4\2\2\u00c2\u00c7\5(\25\13\u00c3\u00c4\f\t\2\2\u00c4"+
		"\u00c5\t\5\2\2\u00c5\u00c7\5(\25\n\u00c6\u00bd\3\2\2\2\u00c6\u00c0\3\2"+
		"\2\2\u00c6\u00c3\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9)\3\2\2\2\u00ca\u00c8\3\2\2\2\23-9?KPT\\`im\u0086"+
		"\u008b\u00a4\u00a8\u00bb\u00c6\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}