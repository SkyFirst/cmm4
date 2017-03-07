package antlr;// Generated from D:/java_project/cmm4/src\cmmGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link cmmGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface cmmGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(cmmGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(cmmGrammarParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#stmtblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtblock(cmmGrammarParser.StmtblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#lbrace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLbrace(cmmGrammarParser.LbraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#rbrace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRbrace(cmmGrammarParser.RbraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#varstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarstmt(cmmGrammarParser.VarstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(cmmGrammarParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#defarray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefarray(cmmGrammarParser.DefarrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#arrayValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(cmmGrammarParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(cmmGrammarParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(cmmGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(cmmGrammarParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(cmmGrammarParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#breakstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakstmt(cmmGrammarParser.BreakstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#readstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadstmt(cmmGrammarParser.ReadstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#writestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritestmt(cmmGrammarParser.WritestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(cmmGrammarParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#writeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteValue(cmmGrammarParser.WriteValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmGrammarParser#assignstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstmt(cmmGrammarParser.AssignstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareEx(cmmGrammarParser.CompareExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealEx(cmmGrammarParser.RealExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code braceEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraceEx(cmmGrammarParser.BraceExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusNumEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusNumEx(cmmGrammarParser.MinusNumExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntEx(cmmGrammarParser.IntExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEx(cmmGrammarParser.ValueExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubEx(cmmGrammarParser.AddSubExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueEx(cmmGrammarParser.TrueExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivEx(cmmGrammarParser.MulDivExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseEx}
	 * labeled alternative in {@link cmmGrammarParser#exper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseEx(cmmGrammarParser.FalseExContext ctx);
}