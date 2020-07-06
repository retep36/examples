// Generated from C:/Dcko/prekladac/src/main/java/gramatika\gramatika.g4 by ANTLR 4.7.2
package gramatika;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramatikaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, TRUE=15, FALSE=16, SKIP_RULE=17, 
		SYMBOL=18, COMP_SYMBOL=19, NAME=20, NUMBER=21, WS=22, NEG=23, AND=24, 
		MULT=25;
	public static final int
		RULE_sequence = 0, RULE_command = 1, RULE_assignment = 2, RULE_operation = 3, 
		RULE_value = 4, RULE_if_condition = 5, RULE_while_loop = 6, RULE_boolean_value = 7, 
		RULE_comparison = 8, RULE_and = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"sequence", "command", "assignment", "operation", "value", "if_condition", 
			"while_loop", "boolean_value", "comparison", "and"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':='", "'('", "')'", "'if'", "'then'", "'else'", "'fi'", 
			"'endif'", "'while'", "'do'", "'begin'", "'od'", "'endwhile'", "'true'", 
			"'false'", "'skip'", null, null, null, null, null, "'!'", "'&&'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "TRUE", "FALSE", "SKIP_RULE", "SYMBOL", "COMP_SYMBOL", 
			"NAME", "NUMBER", "WS", "NEG", "AND", "MULT"
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

	@Override
	public String getGrammarFileName() { return "gramatika.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramatikaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SequenceContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sequence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			command();
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(21);
					match(T__0);
					setState(22);
					command();
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(28);
				match(T__0);
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

	public static class CommandContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public If_conditionContext if_condition() {
			return getRuleContext(If_conditionContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode SKIP_RULE() { return getToken(gramatikaParser.SKIP_RULE, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				if_condition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				while_loop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				comparison();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(35);
				operation(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(36);
				match(SKIP_RULE);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(gramatikaParser.NAME, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Boolean_valueContext boolean_value() {
			return getRuleContext(Boolean_valueContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(NAME);
			setState(40);
			match(T__1);
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(41);
				operation(0);
				}
				break;
			case 2:
				{
				setState(42);
				boolean_value();
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

	public static class OperationContext extends ParserRuleContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode MULT() { return getToken(gramatikaParser.MULT, 0); }
		public TerminalNode SYMBOL() { return getToken(gramatikaParser.SYMBOL, 0); }
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		return operation(0);
	}

	private OperationContext operation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperationContext _localctx = new OperationContext(_ctx, _parentState);
		OperationContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_operation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(46);
				match(T__2);
				setState(47);
				operation(0);
				setState(48);
				match(T__3);
				}
				break;
			case NAME:
			case NUMBER:
				{
				setState(50);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(59);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new OperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(53);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(54);
						match(MULT);
						setState(55);
						operation(3);
						}
						break;
					case 2:
						{
						_localctx = new OperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(56);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(57);
						match(SYMBOL);
						setState(58);
						operation(2);
						}
						break;
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(gramatikaParser.NAME, 0); }
		public TerminalNode NUMBER() { return getToken(gramatikaParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class If_conditionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public Boolean_valueContext boolean_value() {
			return getRuleContext(Boolean_valueContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<SequenceContext> sequence() {
			return getRuleContexts(SequenceContext.class);
		}
		public SequenceContext sequence(int i) {
			return getRuleContext(SequenceContext.class,i);
		}
		public If_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterIf_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitIf_condition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitIf_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_conditionContext if_condition() throws RecognitionException {
		If_conditionContext _localctx = new If_conditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__4);
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(67);
				comparison();
				}
				break;
			case 2:
				{
				setState(68);
				boolean_value();
				}
				break;
			case 3:
				{
				setState(69);
				and(0);
				}
				break;
			}
			setState(72);
			match(T__5);
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(73);
				match(T__2);
				setState(74);
				sequence();
				setState(75);
				match(T__3);
				}
				}
				break;
			case 2:
				{
				setState(77);
				command();
				}
				break;
			}
			setState(80);
			match(T__6);
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				{
				setState(81);
				match(T__2);
				setState(82);
				sequence();
				setState(83);
				match(T__3);
				}
				}
				break;
			case 2:
				{
				setState(85);
				command();
				}
				break;
			}
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class While_loopContext extends ParserRuleContext {
		public Boolean_valueContext boolean_value() {
			return getRuleContext(Boolean_valueContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterWhile_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitWhile_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitWhile_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_while_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__9);
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(92);
				boolean_value();
				}
				break;
			case 2:
				{
				setState(93);
				comparison();
				}
				break;
			case 3:
				{
				setState(94);
				and(0);
				}
				break;
			}
			setState(97);
			match(T__10);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(98);
				match(T__11);
				}
			}

			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				{
				setState(101);
				match(T__2);
				setState(102);
				sequence();
				setState(103);
				match(T__3);
				}
				}
				break;
			case 2:
				{
				setState(105);
				command();
				}
				break;
			}
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(108);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class Boolean_valueContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(gramatikaParser.NAME, 0); }
		public List<TerminalNode> NEG() { return getTokens(gramatikaParser.NEG); }
		public TerminalNode NEG(int i) {
			return getToken(gramatikaParser.NEG, i);
		}
		public TerminalNode TRUE() { return getToken(gramatikaParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(gramatikaParser.FALSE, 0); }
		public Boolean_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterBoolean_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitBoolean_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitBoolean_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_valueContext boolean_value() throws RecognitionException {
		Boolean_valueContext _localctx = new Boolean_valueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_boolean_value);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEG) {
					{
					{
					setState(111);
					match(NEG);
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(112);
						match(T__2);
						}
					}

					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(NAME);
				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(121);
					match(T__3);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(TRUE);
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(125);
					match(T__3);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(FALSE);
				setState(130);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(129);
					match(T__3);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEG) {
					{
					{
					setState(132);
					match(NEG);
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(133);
						match(T__2);
						}
						break;
					}
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(T__2);
				setState(142);
				match(NAME);
				setState(143);
				match(T__3);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode COMP_SYMBOL() { return getToken(gramatikaParser.COMP_SYMBOL, 0); }
		public List<TerminalNode> NEG() { return getTokens(gramatikaParser.NEG); }
		public TerminalNode NEG(int i) {
			return getToken(gramatikaParser.NEG, i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comparison);
		int _la;
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEG) {
					{
					{
					setState(146);
					match(NEG);
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						setState(147);
						match(T__2);
						}
						break;
					}
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(155);
				operation(0);
				setState(156);
				match(COMP_SYMBOL);
				setState(157);
				operation(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(T__2);
				{
				setState(160);
				operation(0);
				setState(161);
				match(COMP_SYMBOL);
				setState(162);
				operation(0);
				}
				setState(164);
				match(T__3);
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

	public static class AndContext extends ParserRuleContext {
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<TerminalNode> NEG() { return getTokens(gramatikaParser.NEG); }
		public TerminalNode NEG(int i) {
			return getToken(gramatikaParser.NEG, i);
		}
		public Boolean_valueContext boolean_value() {
			return getRuleContext(Boolean_valueContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode AND() { return getToken(gramatikaParser.AND, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatikaListener ) ((gramatikaListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatikaVisitor ) return ((gramatikaVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		return and(0);
	}

	private AndContext and(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndContext _localctx = new AndContext(_ctx, _parentState);
		AndContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_and, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEG) {
					{
					{
					setState(169);
					match(NEG);
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						setState(170);
						match(T__2);
						}
						break;
					}
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(178);
				match(T__2);
				setState(179);
				and(0);
				setState(180);
				match(T__3);
				}
				break;
			case 2:
				{
				setState(182);
				boolean_value();
				}
				break;
			case 3:
				{
				setState(183);
				comparison();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and);
					setState(186);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(187);
					match(AND);
					setState(188);
					and(3);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		case 3:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 9:
			return and_sempred((AndContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean operation_sempred(OperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean and_sempred(AndContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00c5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\5\2 \n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3(\n\3\3\4\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\66\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\5\7I\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7Q\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7Y\n\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b\5\bb\n\b\3\b\3\b\5\b"+
		"f\n\b\3\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\b\5\bp\n\b\3\t\3\t\5\tt\n\t\7\tv"+
		"\n\t\f\t\16\ty\13\t\3\t\3\t\5\t}\n\t\3\t\3\t\5\t\u0081\n\t\3\t\3\t\5\t"+
		"\u0085\n\t\3\t\3\t\5\t\u0089\n\t\7\t\u008b\n\t\f\t\16\t\u008e\13\t\3\t"+
		"\3\t\3\t\5\t\u0093\n\t\3\n\3\n\5\n\u0097\n\n\7\n\u0099\n\n\f\n\16\n\u009c"+
		"\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a9\n\n\3\13\3"+
		"\13\3\13\5\13\u00ae\n\13\7\13\u00b0\n\13\f\13\16\13\u00b3\13\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u00bb\n\13\3\13\3\13\3\13\7\13\u00c0\n\13"+
		"\f\13\16\13\u00c3\13\13\3\13\2\4\b\24\f\2\4\6\b\n\f\16\20\22\24\2\5\3"+
		"\2\26\27\3\2\n\13\3\2\17\20\2\u00e1\2\26\3\2\2\2\4\'\3\2\2\2\6)\3\2\2"+
		"\2\b\65\3\2\2\2\nB\3\2\2\2\fD\3\2\2\2\16]\3\2\2\2\20\u0092\3\2\2\2\22"+
		"\u00a8\3\2\2\2\24\u00ba\3\2\2\2\26\33\5\4\3\2\27\30\7\3\2\2\30\32\5\4"+
		"\3\2\31\27\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\37\3\2"+
		"\2\2\35\33\3\2\2\2\36 \7\3\2\2\37\36\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!("+
		"\5\6\4\2\"(\5\f\7\2#(\5\16\b\2$(\5\22\n\2%(\5\b\5\2&(\7\23\2\2\'!\3\2"+
		"\2\2\'\"\3\2\2\2\'#\3\2\2\2\'$\3\2\2\2\'%\3\2\2\2\'&\3\2\2\2(\5\3\2\2"+
		"\2)*\7\26\2\2*-\7\4\2\2+.\5\b\5\2,.\5\20\t\2-+\3\2\2\2-,\3\2\2\2.\7\3"+
		"\2\2\2/\60\b\5\1\2\60\61\7\5\2\2\61\62\5\b\5\2\62\63\7\6\2\2\63\66\3\2"+
		"\2\2\64\66\5\n\6\2\65/\3\2\2\2\65\64\3\2\2\2\66?\3\2\2\2\678\f\5\2\28"+
		"9\7\33\2\29>\5\b\5\5:;\f\4\2\2;<\7\24\2\2<>\5\b\5\4=\67\3\2\2\2=:\3\2"+
		"\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\t\3\2\2\2A?\3\2\2\2BC\t\2\2\2C\13"+
		"\3\2\2\2DH\7\7\2\2EI\5\22\n\2FI\5\20\t\2GI\5\24\13\2HE\3\2\2\2HF\3\2\2"+
		"\2HG\3\2\2\2IJ\3\2\2\2JP\7\b\2\2KL\7\5\2\2LM\5\2\2\2MN\7\6\2\2NQ\3\2\2"+
		"\2OQ\5\4\3\2PK\3\2\2\2PO\3\2\2\2QR\3\2\2\2RX\7\t\2\2ST\7\5\2\2TU\5\2\2"+
		"\2UV\7\6\2\2VY\3\2\2\2WY\5\4\3\2XS\3\2\2\2XW\3\2\2\2Y[\3\2\2\2Z\\\t\3"+
		"\2\2[Z\3\2\2\2[\\\3\2\2\2\\\r\3\2\2\2]a\7\f\2\2^b\5\20\t\2_b\5\22\n\2"+
		"`b\5\24\13\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2bc\3\2\2\2ce\7\r\2\2df\7\16"+
		"\2\2ed\3\2\2\2ef\3\2\2\2fl\3\2\2\2gh\7\5\2\2hi\5\2\2\2ij\7\6\2\2jm\3\2"+
		"\2\2km\5\4\3\2lg\3\2\2\2lk\3\2\2\2mo\3\2\2\2np\t\4\2\2on\3\2\2\2op\3\2"+
		"\2\2p\17\3\2\2\2qs\7\31\2\2rt\7\5\2\2sr\3\2\2\2st\3\2\2\2tv\3\2\2\2uq"+
		"\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z|\7\26\2\2"+
		"{}\7\6\2\2|{\3\2\2\2|}\3\2\2\2}\u0093\3\2\2\2~\u0080\7\21\2\2\177\u0081"+
		"\7\6\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0093\3\2\2\2\u0082"+
		"\u0084\7\22\2\2\u0083\u0085\7\6\2\2\u0084\u0083\3\2\2\2\u0084\u0085\3"+
		"\2\2\2\u0085\u0093\3\2\2\2\u0086\u0088\7\31\2\2\u0087\u0089\7\5\2\2\u0088"+
		"\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0086\3\2"+
		"\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\5\2\2\u0090\u0091\7\26"+
		"\2\2\u0091\u0093\7\6\2\2\u0092w\3\2\2\2\u0092~\3\2\2\2\u0092\u0082\3\2"+
		"\2\2\u0092\u008c\3\2\2\2\u0093\21\3\2\2\2\u0094\u0096\7\31\2\2\u0095\u0097"+
		"\7\5\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0094\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\5\b\5\2\u009e"+
		"\u009f\7\25\2\2\u009f\u00a0\5\b\5\2\u00a0\u00a9\3\2\2\2\u00a1\u00a2\7"+
		"\5\2\2\u00a2\u00a3\5\b\5\2\u00a3\u00a4\7\25\2\2\u00a4\u00a5\5\b\5\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\7\6\2\2\u00a7\u00a9\3\2\2\2\u00a8\u009a\3\2"+
		"\2\2\u00a8\u00a1\3\2\2\2\u00a9\23\3\2\2\2\u00aa\u00b1\b\13\1\2\u00ab\u00ad"+
		"\7\31\2\2\u00ac\u00ae\7\5\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2"+
		"\u00ae\u00b0\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00b5\7\5\2\2\u00b5\u00b6\5\24\13\2\u00b6\u00b7\7\6\2\2\u00b7\u00bb\3"+
		"\2\2\2\u00b8\u00bb\5\20\t\2\u00b9\u00bb\5\22\n\2\u00ba\u00aa\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00c1\3\2\2\2\u00bc\u00bd\f\5"+
		"\2\2\u00bd\u00be\7\32\2\2\u00be\u00c0\5\24\13\5\u00bf\u00bc\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\25\3\2\2"+
		"\2\u00c3\u00c1\3\2\2\2 \33\37\'-\65=?HPX[aelosw|\u0080\u0084\u0088\u008c"+
		"\u0092\u0096\u009a\u00a8\u00ad\u00b1\u00ba\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}