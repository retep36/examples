// Generated from C:/Dcko/prekladac/src/main/java/gramatika\gramatika.g4 by ANTLR 4.7.2
package gramatika;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramatikaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramatikaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(gramatikaParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(gramatikaParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(gramatikaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(gramatikaParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(gramatikaParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#if_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_condition(gramatikaParser.If_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_loop(gramatikaParser.While_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#boolean_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_value(gramatikaParser.Boolean_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(gramatikaParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatikaParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(gramatikaParser.AndContext ctx);
}