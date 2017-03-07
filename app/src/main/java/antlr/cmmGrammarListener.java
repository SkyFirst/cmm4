package antlr;// Generated from D:/java_project/cmm4/src\cmmGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link cmmGrammarParser}.
 */
public interface cmmGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(cmmGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(cmmGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(cmmGrammarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(cmmGrammarParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#stmtblock}.
	 * @param ctx the parse tree
	 */
	void enterStmtblock(cmmGrammarParser.StmtblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#stmtblock}.
	 * @param ctx the parse tree
	 */
	void exitStmtblock(cmmGrammarParser.StmtblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#lbrace}.
	 * @param ctx the parse tree
	 */
	void enterLbrace(cmmGrammarParser.LbraceContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#lbrace}.
	 * @param ctx the parse tree
	 */
	void exitLbrace(cmmGrammarParser.LbraceContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#rbrace}.
	 * @param ctx the parse tree
	 */
	void enterRbrace(cmmGrammarParser.RbraceContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#rbrace}.
	 * @param ctx the parse tree
	 */
	void exitRbrace(cmmGrammarParser.RbraceContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#varstmt}.
	 * @param ctx the parse tree
	 */
	void enterVarstmt(cmmGrammarParser.VarstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#varstmt}.
	 * @param ctx the parse tree
	 */
	void exitVarstmt(cmmGrammarParser.VarstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(cmmGrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(cmmGrammarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#defarray}.
	 * @param ctx the parse tree
	 */
	void enterDefarray(cmmGrammarParser.DefarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#defarray}.
	 * @param ctx the parse tree
	 */
	void exitDefarray(cmmGrammarParser.DefarrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#arrayValue}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(cmmGrammarParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#arrayValue}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(cmmGrammarParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(cmmGrammarParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(cmmGrammarParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(cmmGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(cmmGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(cmmGrammarParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(cmmGrammarParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(cmmGrammarParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(cmmGrammarParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#breakstmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakstmt(cmmGrammarParser.BreakstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#breakstmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakstmt(cmmGrammarParser.BreakstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#readstmt}.
	 * @param ctx the parse tree
	 */
	void enterReadstmt(cmmGrammarParser.ReadstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#readstmt}.
	 * @param ctx the parse tree
	 */
	void exitReadstmt(cmmGrammarParser.ReadstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#writestmt}.
	 * @param ctx the parse tree
	 */
	void enterWritestmt(cmmGrammarParser.WritestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#writestmt}.
	 * @param ctx the parse tree
	 */
	void exitWritestmt(cmmGrammarParser.WritestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(cmmGrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(cmmGrammarParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#writeValue}.
	 * @param ctx the parse tree
	 */
	void enterWriteValue(cmmGrammarParser.WriteValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#writeValue}.
	 * @param ctx the parse tree
	 */
	void exitWriteValue(cmmGrammarParser.WriteValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmGrammarParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignstmt(cmmGrammarParser.AssignstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmGrammarParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignstmt(cmmGrammarParser.AssignstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterCompareEx(cmmGrammarParser.CompareExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitCompareEx(cmmGrammarParser.CompareExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterRealEx(cmmGrammarParser.RealExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitRealEx(cmmGrammarParser.RealExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code braceEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterBraceEx(cmmGrammarParser.BraceExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code braceEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitBraceEx(cmmGrammarParser.BraceExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusNumEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterMinusNumEx(cmmGrammarParser.MinusNumExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusNumEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitMinusNumEx(cmmGrammarParser.MinusNumExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterIntEx(cmmGrammarParser.IntExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitIntEx(cmmGrammarParser.IntExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterValueEx(cmmGrammarParser.ValueExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitValueEx(cmmGrammarParser.ValueExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterAddSubEx(cmmGrammarParser.AddSubExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitAddSubEx(cmmGrammarParser.AddSubExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterTrueEx(cmmGrammarParser.TrueExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitTrueEx(cmmGrammarParser.TrueExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterMulDivEx(cmmGrammarParser.MulDivExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitMulDivEx(cmmGrammarParser.MulDivExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void enterFalseEx(cmmGrammarParser.FalseExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 */
	void exitFalseEx(cmmGrammarParser.FalseExContext ctx);
}