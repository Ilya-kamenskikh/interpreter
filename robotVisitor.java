// Generated from robot.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link robotParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface robotVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link robotParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull robotParser.MultContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AssignId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignId(@NotNull robotParser.AssignIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AssignUnsigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignUnsigned(@NotNull robotParser.AssignUnsignedContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull robotParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(@NotNull robotParser.StmtsContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull robotParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AssignUnsignedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignUnsignedId(@NotNull robotParser.AssignUnsignedIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#IdWorld}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdWorld(@NotNull robotParser.IdWorldContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#drawing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawing(@NotNull robotParser.DrawingContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull robotParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(@NotNull robotParser.ArgContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull robotParser.ProgContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#World}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorld(@NotNull robotParser.WorldContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycle(@NotNull robotParser.CycleContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#Parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(@NotNull robotParser.ParensContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#DeclMatSigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclMatSigned(@NotNull robotParser.DeclMatSignedContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull robotParser.ConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#DeclMatUnsigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclMatUnsigned(@NotNull robotParser.DeclMatUnsignedContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AddSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(@NotNull robotParser.AddSubContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull robotParser.StmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(@NotNull robotParser.AccessContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#UnsignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumber(@NotNull robotParser.UnsignedNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull robotParser.PrintContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#ConstAssignUnsigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstAssignUnsigned(@NotNull robotParser.ConstAssignUnsignedContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#IdMatrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdMatrix(@NotNull robotParser.IdMatrixContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#ConstAssignSigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstAssignSigned(@NotNull robotParser.ConstAssignSignedContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AssignSigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSigned(@NotNull robotParser.AssignSignedContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#Id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull robotParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull robotParser.BoolContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AssignSignedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSignedId(@NotNull robotParser.AssignSignedIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#SignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNumber(@NotNull robotParser.SignedNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AssignMatrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignMatrix(@NotNull robotParser.AssignMatrixContext ctx);

	/**
	 * Visit a parse tree produced by {@link robotParser#AssignWorld}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignWorld(@NotNull robotParser.AssignWorldContext ctx);
}