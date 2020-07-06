package app;

import gramatika.gramatikaBaseVisitor;
import gramatika.gramatikaParser;
import model.*;

import java.util.*;

/**
 * Trieda obsahuje met�dy, ktor� sa vyu��vaj� pri prechode abstraktn�m syntaktick�m stromom.
 */
public class GramatikaVisitor extends gramatikaBaseVisitor {
    private int neg = 0;

    /**
     * Met�da, ktor� vstupn� program rozdel� na zadan� pr�kazy.
     * Zavol� met�du visitCommand a ka�d� samostatn� pr�kaz vlo�� ako parameter.
     * V�sledok volania met�dy visitCommand ulo�� do zoznamu typu Command.
     * @param ctx sekvencie prikazov je vstupom met�dy.
     * @return Met�da vracia zoznam pr�kazov.
     */
    @Override
    public List<Command> visitSequence(gramatikaParser.SequenceContext ctx) {
        List<Command> commands = new ArrayList<>();
        if (ctx.command() != null) {
            for (gramatikaParser.CommandContext command : ctx.command()) {
                commands.add(visitCommand(command));
            }
        }
        return commands;
    }

    /**
     * Met�da je zavolan� vtedy, ak je zadan� vstupnom programe prira�ovac� pr�kaz.
     * Na �avej strane priradenia je n�zov premennej, na pravej nejak� hodnota.
     * Met�da zis�uje, ak� typ hodnoty je na pravej strane a na z�klade zistenia typu hodnoty zavol� prisluchaj�cu met�du.
     * V�sledok z tejto met�dy ulo�� do premennej value a vlo�� ju ako parameter spolu s n�zvom premennej
     * do novovytvoren�ho objektu typu Assignment.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu Assignment.
     */
    @Override
    public Assignment visitAssignment(gramatikaParser.AssignmentContext ctx) {
        AssignmentValue value;
        if (ctx.boolean_value() != null) {
            value = visitBoolean_value(ctx.boolean_value());
        } else {
            value = visitOperation(ctx.operation());
        }
        return new Assignment(ctx.NAME().getText(), value);
    }

    /**
     * Met�da sl��i na anal�zu porovn�vacieho pr�kazu.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu Comparison.
     */
    @Override
    public Comparison visitComparison(gramatikaParser.ComparisonContext ctx) {
        Operation value1 = visitOperation(ctx.operation(0));
        Operation value2 = visitOperation(ctx.operation(1));
        return new Comparison(
                ctx.NEG().size(), value1, value2, ctx.COMP_SYMBOL().getText());
    }

    /**
     * Pri pr�kaze typu and sa vytvor� nov� objekt typu And.
     * Pomocou parametra je vlo�en� po�et zadan�ch neg�ci�, obe hodnoty a boolean hodnota, toho, �i sa v pr�kaze nach�dzaj� z�tvorky.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu Operation.
     */
    @Override
    public And visitAnd(gramatikaParser.AndContext ctx) {
        if (ctx.boolean_value() != null) {
            return visitBoolean_value(ctx.boolean_value());
        } else if (ctx.comparison() != null) {
            return visitComparison(ctx.comparison());
        } else if (ctx.and().size() > 1) {
            return new And(
                    ctx.NEG().size(),
                    visitAnd(ctx.and(0)),
                    visitAnd(ctx.and(1)),
                    false
            );
        } else {
            gramatikaParser.AndContext andContext = ctx.and(0);
            And and = new And();
            and.setHasParenthesis(true);
            if (andContext.boolean_value() != null) {
                return visitBoolean_value(andContext.boolean_value());
            }
            else if (andContext.comparison() != null) {
                return visitComparison(andContext.comparison());
            } else if (andContext.and().size() > 1) {
                and.setValue1(visitAnd(andContext.and(0)));
                and.setValue2(visitAnd(andContext.and(1)));
                and.setIsNeg(ctx.NEG().size());
                return and;
            } else {
                return visitAnd(ctx.and(0));
            }
        }
    }

    /**
     * Met�da vytvor� nov� objekt typu Value. Hodnotu m��e predstavova� ��slo alebo n�zov premennej.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu Value.
     */
    @Override
    public Value visitValue(gramatikaParser.ValueContext ctx) {
        return new Value(
                ctx.NAME() != null ? ctx.NAME().getText() : null,
                ctx.NUMBER() != null ? Integer.parseInt(ctx.NUMBER().getText()) : 0);
    }

    /**
     * Met�da vytvor� nov� objekt typu BooleanValue s potrebn�mi parametrami.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu BooleanValue.
     */
    @Override
    public BooleanValue visitBoolean_value(gramatikaParser.Boolean_valueContext ctx) {
        if (ctx.TRUE() != null) {
            return new BooleanValue(ctx.NEG().size(), ctx.TRUE().getText());
        } else if (ctx.FALSE() != null){
            return new BooleanValue(ctx.NEG().size(), ctx.FALSE().getText());
        } else {
            return new BooleanValue(ctx.NEG().size(), ctx.NAME().getText());
        }
    }


    /**
     * Pri pr�kaze typu oper�cia sa vytvor� nov� objekt typu Operation.
     * Pomocou parametra s� vlo�en� obe hodnoty a znamienko oper�cie a boolean hodnota, toho, �i sa v pr�kaze nach�dzaj� z�tvorky.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu Operation.
     */
    @Override
    public Operation visitOperation(gramatikaParser.OperationContext ctx) {
        if (ctx.value() != null)  {
            return visitValue(ctx.value());
        } else if (ctx.operation().size() > 1) {
            return new Operation(
                    visitOperation(ctx.operation(0)),
                    visitOperation(ctx.operation(1)),
                    ctx.SYMBOL() != null ? ctx.SYMBOL().getText() : ctx.MULT().getText(),
                    false
            );
        } else {
            gramatikaParser.OperationContext operationContext = ctx.operation(0);
            Operation operation = new Operation();
            operation.setHasParenthesis(true);
            if (operationContext.value() != null)  {
                return visitValue(operationContext.value());
            } else if (operationContext.operation().size() > 1) {
                operation.setValue1(visitOperation(operationContext.operation(0)));
                operation.setValue2(visitOperation(operationContext.operation(1)));
                operation.setSymbol(operationContext.SYMBOL() != null ? operationContext.SYMBOL().getText() : operationContext.MULT().getText());
                return operation;
            } else {
                return visitOperation(ctx.operation(0));
            }
        }
    }

    /**
     * Met�da rozdel� pr�kaz vetvenia na tri �asti.
     * Do jedn�ho zoznamu ulo�� v�sledn� hodnotu z met�dy visitSequenceOrCommand() pre pr�kazy za k�u�ov�m slovom then.
     * Do druh�ho zoznamu taktie� ulo�� v�sledn� hodnoty z met�dy visitSequenceOrCommand() pre pr�kazy za k�u�ov�m slovom else.
     * N�sledne zist� typ pr�kazu v podmienke na z�klade contextu.
     * Nakoniec vytvor� nov� objekt typu IfCondition, kde tieto �daje vlo��.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu IfCondition.
     */
    @Override
    public IfCondition visitIf_condition(gramatikaParser.If_conditionContext ctx) {
        Condition condition = null;
        List<Command> thenCommands = visitSequenceOrCommand(ctx, true);
        List<Command> elseCommands = visitSequenceOrCommand(ctx, false);
        if(ctx.and() != null){
            condition = visitAnd(ctx.and());
        } else if(ctx.boolean_value() != null){
            condition = visitBoolean_value(ctx.boolean_value());
        } else if (ctx.comparison() != null) {
            condition = visitComparison(ctx.comparison());
        }
        return new IfCondition(condition, thenCommands, elseCommands);
    }

    /**
     * Met�da rozdel� mo�n� sekvenciu pr�kazov za k���ov�mi slovami then a else.
     * Na z�klade boolean hodnoty rozli�uje �i rozde�uje sekvenciu pr�kazov za k���ov�m slovom then alebo else.
     * Vracia zoznam pr�kazov do met�dy visitIf_condition().
     * @param ctx je vstupn�m parametrom met�dy.
     * @param value sl��i na rozl�enie toho, �i uklad�me pr�kazy do zoznamu za k���ov�m slovom then alebo else.
     * @return pr�kazy, ktor� s� ulo�en� do zoznamu.
     */
    private List<Command> visitSequenceOrCommand(gramatikaParser.If_conditionContext ctx, boolean value) {
        List<Command> commands = new ArrayList<>();
        if (ctx.sequence().size() == 2) {
            commands.addAll(visitSequence(ctx.sequence(value ? 0 : 1)));
        } else if (ctx.command().size() == 2) {
            commands.add(visitCommand(ctx.command(value ? 0 : 1)));
        } else if (ctx.children.indexOf(ctx.command(0)) < ctx.children.indexOf(ctx.sequence(0))) {
            if (value) {
                commands.add(visitCommand(ctx.command(0)));
            } else {
                commands.addAll(visitSequence(ctx.sequence(0)));
            }
        } else {
            if (value) {
                commands.addAll(visitSequence(ctx.sequence(0)));
            } else {
                commands.add(visitCommand(ctx.command(0)));
            }
        }
        return commands;
    }

    /**
     * Met�da sl��i na ur�enie typu zadan�ho pr�kazu na z�klade vstupn�ho parametra
     * Po ur�en� typu pr�kazu je zavolan� met�da prisl�chaj�ca tomuto typu pr�kazu.
     * @param ctx vstupn� parameter.
     * @return null
     */
    @Override
    public Command visitCommand(gramatikaParser.CommandContext ctx) {
        if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment());
        } else if (ctx.if_condition() != null) {
            return visitIf_condition(ctx.if_condition());
        } else if (ctx.while_loop() != null) {
            return visitWhile_loop(ctx.while_loop());
        } else if (ctx.comparison() != null) {
            return visitComparison(ctx.comparison());
        } else if (ctx.operation() != null) {
            return visitOperation(ctx.operation());
        } else if (ctx.SKIP_RULE() != null) {
            return new Skip();
        }
        return null;
    }

    /**
     * Met�da rozdel� while pr�kaz na pr�kaz v podmienke a zoznam pr�kazov za k���ov�m slovom do.
     * Vytvor� nov� objekt typu WhileLoop, kde tieto �daje vlo��.
     * @param ctx je vstupn�m parametrom met�dy.
     * @return v�pis v spr�vnom tvare z novovytvoren�jo objektu typu WhileLoop.
     */
    @Override
    public WhileLoop visitWhile_loop(gramatikaParser.While_loopContext ctx) {
        Condition condition = null;
        List<Command> doCommands = new ArrayList<>();
        if (ctx.and() != null) {
            condition = visitAnd(ctx.and());
        } else if (ctx.boolean_value() != null){
            condition = visitBoolean_value(ctx.boolean_value());
        } else {
            condition = visitComparison(ctx.comparison());
        }
        if (ctx.command() != null) {
            doCommands.add(visitCommand(ctx.command()));
        } else {
            doCommands.addAll(visitSequence(ctx.sequence()));
        }
        return new WhileLoop(condition, doCommands);
    }
}


