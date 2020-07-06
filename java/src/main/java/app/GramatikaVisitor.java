package app;

import gramatika.gramatikaBaseVisitor;
import gramatika.gramatikaParser;
import model.*;

import java.util.*;

/**
 * Trieda obsahuje metódy, ktoré sa využívajú pri prechode abstraktným syntaktickým stromom.
 */
public class GramatikaVisitor extends gramatikaBaseVisitor {
    private int neg = 0;

    /**
     * Metóda, ktorá vstupný program rozdelí na zadané príkazy.
     * Zavolá metódu visitCommand a každý samostatný príkaz vloží ako parameter.
     * Výsledok volania metódy visitCommand uloží do zoznamu typu Command.
     * @param ctx sekvencie prikazov je vstupom metódy.
     * @return Metóda vracia zoznam príkazov.
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
     * Metóda je zavolaná vtedy, ak je zadaný vstupnom programe priraïovací príkaz.
     * Na ¾avej strane priradenia je názov premennej, na pravej nejaká hodnota.
     * Metóda zisuje, aký typ hodnoty je na pravej strane a na základe zistenia typu hodnoty zavolá prisluchajúcu metódu.
     * Výsledok z tejto metódy uloží do premennej value a vloží ju ako parameter spolu s názvom premennej
     * do novovytvoreného objektu typu Assignment.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu Assignment.
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
     * Metóda slúži na analýzu porovnávacieho príkazu.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu Comparison.
     */
    @Override
    public Comparison visitComparison(gramatikaParser.ComparisonContext ctx) {
        Operation value1 = visitOperation(ctx.operation(0));
        Operation value2 = visitOperation(ctx.operation(1));
        return new Comparison(
                ctx.NEG().size(), value1, value2, ctx.COMP_SYMBOL().getText());
    }

    /**
     * Pri príkaze typu and sa vytvorí nový objekt typu And.
     * Pomocou parametra je vložený poèet zadaných negácií, obe hodnoty a boolean hodnota, toho, èi sa v príkaze nachádzajú zátvorky.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu Operation.
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
     * Metóda vytvorí nový objekt typu Value. Hodnotu môže predstavova èíslo alebo názov premennej.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu Value.
     */
    @Override
    public Value visitValue(gramatikaParser.ValueContext ctx) {
        return new Value(
                ctx.NAME() != null ? ctx.NAME().getText() : null,
                ctx.NUMBER() != null ? Integer.parseInt(ctx.NUMBER().getText()) : 0);
    }

    /**
     * Metóda vytvorí nový objekt typu BooleanValue s potrebnými parametrami.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu BooleanValue.
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
     * Pri príkaze typu operácia sa vytvorí nový objekt typu Operation.
     * Pomocou parametra sú vložené obe hodnoty a znamienko operácie a boolean hodnota, toho, èi sa v príkaze nachádzajú zátvorky.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu Operation.
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
     * Metóda rozdelí príkaz vetvenia na tri èasti.
     * Do jedného zoznamu uloží výslednú hodnotu z metódy visitSequenceOrCommand() pre príkazy za k¾uèovým slovom then.
     * Do druhého zoznamu taktiež uloží výsledné hodnoty z metódy visitSequenceOrCommand() pre príkazy za k¾uèovým slovom else.
     * Následne zistí typ príkazu v podmienke na základe contextu.
     * Nakoniec vytvorí nový objekt typu IfCondition, kde tieto údaje vloží.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu IfCondition.
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
     * Metóda rozdelí možnú sekvenciu príkazov za k¾úèovými slovami then a else.
     * Na základe boolean hodnoty rozlišuje èi rozde¾uje sekvenciu príkazov za k¾úèovým slovom then alebo else.
     * Vracia zoznam príkazov do metódy visitIf_condition().
     * @param ctx je vstupným parametrom metódy.
     * @param value slúži na rozlíšenie toho, èi ukladáme príkazy do zoznamu za k¾úèovým slovom then alebo else.
     * @return príkazy, ktoré sú uložené do zoznamu.
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
     * Metóda slúži na urèenie typu zadaného príkazu na základe vstupného parametra
     * Po urèení typu príkazu je zavolaná metóda prislúchajúca tomuto typu príkazu.
     * @param ctx vstupný parameter.
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
     * Metóda rozdelí while príkaz na príkaz v podmienke a zoznam príkazov za k¾úèovým slovom do.
     * Vytvorí nový objekt typu WhileLoop, kde tieto údaje vloží.
     * @param ctx je vstupným parametrom metódy.
     * @return výpis v správnom tvare z novovytvorenéjo objektu typu WhileLoop.
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


