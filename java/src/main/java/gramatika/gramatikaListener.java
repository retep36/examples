// Generated from C:/Dcko/prekladac/src/main/java/gramatika\gramatika.g4 by ANTLR 4.7.2
package gramatika;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramatikaParser}.
 */
public interface gramatikaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(gramatikaParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(gramatikaParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(gramatikaParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(gramatikaParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(gramatikaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(gramatikaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(gramatikaParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(gramatikaParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(gramatikaParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(gramatikaParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void enterIf_condition(gramatikaParser.If_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void exitIf_condition(gramatikaParser.If_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void enterWhile_loop(gramatikaParser.While_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void exitWhile_loop(gramatikaParser.While_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#boolean_value}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_value(gramatikaParser.Boolean_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#boolean_value}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_value(gramatikaParser.Boolean_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(gramatikaParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(gramatikaParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatikaParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(gramatikaParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatikaParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(gramatikaParser.AndContext ctx);
}