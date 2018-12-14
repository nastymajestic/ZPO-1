package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        String word = "random";
        AnchorPane background = new AnchorPane();

        Label translateWord = new Label("Przetłumacz słowo na angielski:");
        translateWord.setLayoutX(100);
        translateWord.setLayoutY(30);
        //=================================================================
        Label translateWordVar = new Label(word);
        translateWord.setFont(Font.font("System", 15));
        translateWordVar.setLayoutX(180);
        translateWordVar.setLayoutY(60);
        translateWordVar.setFont(Font.font("System", FontWeight.BOLD, 20));

        //=================================================================

        TextField enterWord = new TextField("wpisz słowo");
        enterWord.setLayoutX(100);
        enterWord.setLayoutY(100);

        background.getChildren().addAll(enterWord,translateWord,translateWordVar);
        primaryStage.setTitle("Test");

        primaryStage.setScene(new Scene(background, 400, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Test.runTest();
        launch(args);


    }
}
