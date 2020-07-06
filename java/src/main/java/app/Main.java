package app;

import gramatika.gramatikaLexer;
import gramatika.gramatikaParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Sequence;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Hlavn� trieda obsahuj�ca nastavenia zobrazovan�ho okna.
 */
public class Main extends Application {

    /**
     * Met�da sa vykon� pri spusten� aplik�cie. Obsahuje nastavenia zobrazovan�ho okna a jeho vlastnosti.
     * @param primaryStage je pridelen� okno aplik�cia a funkcia zobrazenia okna
     * @throws Exception kv�li odchyten� v�nimky pri nena��tan� s�boru fxml.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/window.fxml"));
        primaryStage.setTitle("Gener�tor in�trukci� abstraktn�ho stroja");

        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton all = new ToggleButton("cel� postup");
        ToggleButton result = new ToggleButton("v�sledok");

        all.setToggleGroup(toggleGroup);
        result.setToggleGroup(toggleGroup);

        all.setSelected(true);

        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Met�da na��ta a inicializuje d�ta z parametra
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}


//public class Main {
//    public static void main(String[] args) {
//        String input = "x:=4";
////        String input = "x+2-6";
////        String input = "(x+2)-6";
////        System.out.println(input);
//
////        CharStream stream = CharStreams.fromString(input);
////        gramatikaLexer lexer = new gramatikaLexer(stream);
////        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
////        gramatikaParser parser = new gramatikaParser(tokenStream);
////        GramatikaVisitor visitor = new GramatikaVisitor();
////        System.out.println(visitor.visitSequence(parser.sequence()));
////
////        visitor.printCommands();
//
//        CharStream stream = CharStreams.fromString(input);
//        gramatikaLexer lexer = new gramatikaLexer(stream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//        gramatikaParser parser = new gramatikaParser(tokenStream);
//        GramatikaVisitor visitor = new GramatikaVisitor();
//        Sequence sequence = new Sequence(visitor.visitSequence(parser.sequence()));
////        System.out.println(sequence);
//        sequence.print();
//    }
//}
