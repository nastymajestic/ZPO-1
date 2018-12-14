import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

public static  TableView<Rowerzysta> najlepszeWyniki = new TableView<Rowerzysta>();
public static TableView<Rowerzysta> ostatni = new TableView<Rowerzysta>();
    @Override
    public void start(Stage stage) {

        AnchorPane tlo = new AnchorPane();     // tlo wszystkiego


        // -------------------------------------------------------------------------------------------- czolowka
        TableColumn<Rowerzysta,Integer> kolarz = new TableColumn<Rowerzysta,Integer>("Kolarz:");
        kolarz.setMinWidth(100);
        kolarz.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Rowerzysta,Integer> czasRowerzysty = new TableColumn<Rowerzysta,Integer>("czas:");
        czasRowerzysty.setMaxWidth(50);
        czasRowerzysty.setCellValueFactory(new PropertyValueFactory<>("poczatkowy_time"));
        najlepszeWyniki.getColumns().addAll(kolarz,czasRowerzysty);
        //----------------------------------------------------------------------------------------------


        Label czolowkaRow = new Label("AKTUALNA CZOŁÓWKA:");
        czolowkaRow.setLayoutX(125);
        czolowkaRow.setLayoutY(200);
        czolowkaRow.setFont(Font.font("Calibri", 15));
        //=============================================================================================
        VBox root = new VBox();
        root.getChildren().add(najlepszeWyniki);
        root.setLayoutX(125);
        root.setLayoutY(230);
        root.setPrefSize(150,140 );
        // -----------------------------------------------------------------ostatni czas zawodnika ktory ukonczyl wyscig
        StackPane ostatniRowerzystaTlo = new StackPane();
        ostatniRowerzystaTlo.setLayoutX(125);
        ostatniRowerzystaTlo.setLayoutY(70);
        TableColumn<Rowerzysta,Integer> ostatniKolarz = new TableColumn<Rowerzysta,Integer>("Kolarz:");
        ostatniKolarz.setMinWidth(100);
        ostatniKolarz.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Rowerzysta,Integer> czasOstatniego = new TableColumn<Rowerzysta,Integer>("czas:");
        czasOstatniego.setMaxWidth(50);
        czasOstatniego.setCellValueFactory(new PropertyValueFactory<>("poczatkowy_time"));

        ostatniRowerzystaTlo.setPrefSize(150, 80);

        ostatni.getColumns().addAll(ostatniKolarz,czasOstatniego);
        ostatniRowerzystaTlo.getChildren().add(ostatni);


        // ------------------------------------------------------------------ LABEL OSTATNI KOLARZ
        Label ostatniKolarzLabel = new Label("OSTATNI KOLARZ:");
        ostatniKolarzLabel.setLayoutX(125);
        ostatniKolarzLabel.setLayoutY(40);
        ostatniKolarzLabel.setFont(Font.font("Calibri", 15));


        tlo.getChildren().addAll(root,czolowkaRow,ostatniRowerzystaTlo,ostatniKolarzLabel);

        Scene scene = new Scene(tlo, 400, 600);
        stage.setScene(scene);
        stage.setTitle("Wyscig kolarski");
        stage.show();

    }
    public static void main(String[] args) {
        Wyscig.start();
        launch(args);
    }


}
