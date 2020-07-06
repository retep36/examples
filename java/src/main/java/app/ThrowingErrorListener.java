package app;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Trieda obsahujúca výpis chybovej správy
 */
public class ThrowingErrorListener extends BaseErrorListener {
    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();
    private String newMsg;

    /**
     * Metóda, ktorá slúži na vypísanie chybovej správy pri syntakticky nesprávne zadanom vstupnom programe.
     * @param recognizer
     * @param offendingSymbol
     * @param line oznaèuje chybný riadok.
     * @param charPositionInLine je pozícia chyby v riadku.
     * @param msg predstavuje chybovú správu.
     * @param e
     * @throws ParseCancellationException
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        String origMsg = msg;
//        int findChar = msg.indexOf("'");
//        msg = msg.substring(0,findChar);
//        System.out.println(msg);
//        System.out.println(origMsg);

        if(origMsg.contains("expecting 'else'")){
            newMsg = "mismatched input '<EOF>' expecting 'else'";
        }
        else if(origMsg.contains("no viable alternative at input '") && origMsg.contains(":='")){
            newMsg = "mismatched input ':=' expecting: '=='";
        }
        else if(origMsg.contains("mismatched input '") && origMsg.contains("expecting {'if', 'while', 'skip', NAME}")){
            newMsg = "mismatched input expecting NAME before ':='";
        }
        else if(origMsg.contains("no viable alternative at input '=")){
            newMsg = "mismatched input expecting: ':='";
        }
        else if(origMsg.contains("mismatched input '<EOF>' expecting {'tt', 'ff', NAME, NUMBER, '!'}")){
            newMsg = "mismatched input '<EOF>' expecting NAME or NUMBER";
        }
        else if(origMsg.contains("mismatched input ':=' expecting {'if', 'while', 'skip', NAME}")){
            newMsg = "mismatched input ':=' expecting NAME";
        }
        else if(origMsg.contains("extraneous input ':=' expecting {'if', 'while', 'skip', NAME}")){
            newMsg = "extraneous input ':=' expecting NAME";
        }
        else if(origMsg.contains("token recognition error at: '=")){
            newMsg = "mismatched input expecting ':=' in command or '==' in condition";
        }
        else if(origMsg.contains("mismatched input ')' expecting {'(', 'tt', 'ff', NAME, NUMBER, '!'}")){
            newMsg = "mismatched input ')' expecting 'tt', 'ff', NAME, NUMBER, '!'";
        }
        else if(origMsg.contains("mismatched input ')' expecting COMP_SYMBOL")){
            newMsg = "mismatched input ')' expecting '<', '>', '==', '<=', '>=' and NAME or NUMBER";
        }
        else if(origMsg.contains("token recognition error at: '&")){
            newMsg = "mismatched input '&' expecting '&&'";
        }
        else if(origMsg.contains("missing 'do' at")){
            newMsg = "missing key 'do'";
        }
        else {
            newMsg = origMsg;
        }

        throw new ParseCancellationException("line " + line + ':' + charPositionInLine + " " + newMsg);
    }
}
