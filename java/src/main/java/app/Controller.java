package app;

import gramatika.gramatikaLexer;
import gramatika.gramatikaParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.Sequence;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Trieda je premosten�m medzi pou��vate�sk�m rozhran�m a jednotliv�mi met�dami.
 */
public class Controller {
    /**
     * Pr�zdny kon�truktor.
     */
    public Controller() {
    }

    @FXML
    private Button btn_calculate;
    @FXML
    private Button btn_delete;
    @FXML
    private TextArea textAreaIN;
    @FXML
    private TextArea textAreaOUT;
    @FXML
    private Label message;
    @FXML
    private ToggleButton all;
    @FXML
    private ToggleButton result;
    @FXML
    private Button btn_copy;
    @FXML
    private Button btn_load;
    @FXML
    private Button btn_export;

    private String firstToSave;
    private String secondToSave;


//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }


    /**
     * Met�da sl��i na vytvorenie in�tanci� pre lexer, parser a visitor.
     * N�sledne sa vykon� preklad.
     * Po vykonan� prekladu s� �daje vlo�en� sp�, upraven� a vyp�san� do textov�ho po�a v�stupn�ho programu.
     * @throws Exception na odchytenie syntaktickej chyby.
     */
    @FXML
    private void calculate() throws Exception {
        try {
            ThrowingErrorListener throwingErrorListener = new ThrowingErrorListener();

            String input = textAreaIN.getText();
            CharStream stream = CharStreams.fromString(input);
            gramatikaLexer lexer = new gramatikaLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            gramatikaParser parser = new gramatikaParser(tokenStream);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

//            System.out.println("input " + input.replace(" ",""));

            if(input.replace(" ","").contains("skip:=")){
                message.setText("CHYBA line 1:0 mismatched input 'skip' expecting {'assignment', 'if', 'while', NAME, NUMBER}");
                message.setTextFill(Color.RED);
            } else {

                GramatikaVisitor visitor = new GramatikaVisitor();
                Sequence sequence = new Sequence(visitor.visitSequence(parser.sequence()));
                sequence.print();

                String vysledok = sequence.getCommands();
                vysledok = vysledok.substring(4);
                int cislo = vysledok.lastIndexOf("=");
                firstToSave = vysledok.substring(0, cislo + 2);
                secondToSave = vysledok.substring(cislo + 2);

                String firstToShow = firstToSave.replace("TE", Symbols.LETTER_T + Symbols.LETTER_E)
                        .replace("TS", Symbols.LETTER_T + Symbols.LETTER_S)
                        .replace("TB", Symbols.LETTER_T + Symbols.LETTER_B)
                        .replace("[", Symbols.LBRAC)
                        .replace("]", Symbols.RBRAC);

                String secondToShow = secondToSave.replace("TE", Symbols.LETTER_T + Symbols.LETTER_E)
                        .replace("TS", Symbols.LETTER_T + Symbols.LETTER_S)
                        .replace("TB", Symbols.LETTER_T + Symbols.LETTER_B)
                        .replace("[", Symbols.LBRAC)
                        .replace("]", Symbols.RBRAC);

                if (all.isSelected()) {
                    textAreaOUT.setText(firstToShow + secondToShow);
                }
                if (result.isSelected()) {
                    textAreaOUT.setText(secondToShow);
                }
                message.setText("OK");
                message.setTextFill(Color.GREEN);
            }
        } catch (ParseCancellationException pe) {
            textAreaOUT.setText("");
            message.setText("CHYBA " + pe.getMessage());
            message.setTextFill(Color.RED);
            throw new Exception(pe.getMessage(), pe);
        }
    }

    /**
     * Met�da vynuluje v�etky polia po stla�en� pr�slu�n�ho tla�idla.
     */
    @FXML
    private void clear(){
        textAreaIN.setText("");
        textAreaOUT.setText("");
        message.setText("");
    }

    /**
     * Met�da na ulo�enie pr�kladu do textov�ho s�boru. Obsahuje preddefinovan� n�zov s�boru a typ s�boru.
     * @param actionEvent informuje o type objektu.
     */
    @FXML
    private void export(ActionEvent actionEvent){
        String vstup = textAreaIN.getText();
        String vystup = firstToSave + secondToSave;

        FileChooser fileChooser = new FileChooser();
        Window stage = ((Node) actionEvent.getSource()).getScene().getWindow();

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setInitialFileName("preklad.txt");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setSelectedExtensionFilter(extFilter);
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                saveTextToFile(vstup, vystup, file);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "S�bor sa nepodarilo ulo�i�.", ButtonType.OK);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    /**
     * Na z�klade stavu ToggleButton skop�ruje do schr�nky v�stupn� program v kr�tkej alebo dlhej forme.
     */
    @FXML
    private void copy(){
        if (all.isSelected()) {
            StringSelection selection = new StringSelection(firstToSave + secondToSave);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents( selection, selection );
        }
        if(result.isSelected()){
            StringSelection selection = new StringSelection(secondToSave);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents( selection, selection );
        }

    }

    /**
     * Met�da sl��i na na��tanie vstupn�ho programu z textov�ho s�boru.
     * V pr�pade, �e d�ta boli �spe�ne pre��tane, vlo�� ich do pr�slu�n�ho textov�ho po�a.
     * V opa�nom pr�pade zobraz� upozornenie.
     * @param actionEvent informuje o type objektu.
     */
    @FXML
    private void loadFile(ActionEvent actionEvent){
        String data = null;
        FileChooser fileChooser = new FileChooser();
        Window stage = ((Node) actionEvent.getSource()).getScene().getWindow();

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);

        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "S�bor nen�jden�.", ButtonType.OK);
            alert.showAndWait();
            e.printStackTrace();
        }
        while (Objects.requireNonNull(reader).hasNextLine()) {
            data = reader.nextLine();
        }
        reader.close();

        if (data != null){
            textAreaIN.setText(data);
        }
    }

    /**
     * V tejto met�de prebieha samotn� z�pis �dajov do textov�ho s�boru.
     * @param input predstavuje vstupn� program v jazyku Jane.
     * @param output predstavuje v�stupn� program in�trukci� abstraktn�ho stroja.
     * @param file je s�bor, ktor�ho d�ta zapisujeme.
     * @throws FileNotFoundException v�nimku pri nen�jden� s�boru.
     */
    private void saveTextToFile(String input, String output, File file) throws FileNotFoundException {
        PrintWriter writer;
        writer = new PrintWriter(file);
        writer.println("vstup: " + input);
        writer.println("vystup: " + output);
        writer.close();
    }
}
