package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

import static java.awt.Color.BLUE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // stage --> scena --> borderpane
        BorderPane root = new BorderPane();
        AnchorPane bottomView = new AnchorPane();
        Pane centerView = new Pane();

        bottomView.setPrefSize(400,400 );

        Slider R = new Slider(0,255,130);
        Slider G = new Slider(0,255,130);
        Slider B = new Slider(0,255,130);


        R.setShowTickLabels(true);
        B.setShowTickLabels(true);
        G.setShowTickLabels(true);

        final Label RValue = new Label(Double.toString(R.getValue()));
        final Label GValue = new Label(Double.toString(R.getValue()));
        final Label BValue = new Label(Double.toString(R.getValue()));

        final Label Rlabel = new Label("R");
        final Label Glabel = new Label("G");
        final Label Blabel = new Label("B");

        Rectangle rectangle = new Rectangle(100,100);



        R.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                RValue.setText(String.format("%.0f", new_val));
                String warunek = String.format("%.0f", new_val);
                Integer xd = Integer.valueOf(warunek);

                if(xd>100){
                    rectangle.setFill(Color.RED);
                }else {
                    rectangle.setFill(Color.BLUE);
                }

            }
        });

        G.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                GValue.setText(String.format("%.0f", new_val));
            }
        });

        B.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                BValue.setText(String.format("%.0f", new_val));
                System.out.println("dzialam");
            }
        });




      bottomView.getChildren().addAll(R,B,G,RValue,BValue,GValue,Rlabel,Blabel,Glabel);

        //Color Red = new Color(, , )

      B.setLayoutX(130);
      B.setLayoutY(320);
      BValue.setLayoutX(275);
      BValue.setLayoutY(317);
      Blabel.setLayoutX(120);
      Blabel.setLayoutY(317);

      G.setLayoutX(130);
      G.setLayoutY(280);

      GValue.setLayoutX(275);
      GValue.setLayoutY(277);
      Glabel.setLayoutX(120);
      Glabel.setLayoutY(277);

      R.setLayoutX(130);
      R.setLayoutY(240);
      RValue.setLayoutX(275);
      RValue.setLayoutY(237);
      Rlabel.setLayoutX(120);
      Rlabel.setLayoutY(237);

      centerView.getChildren().add(rectangle);
      rectangle.setX(150);
      rectangle.setY(50);


      root.setBottom(bottomView);
      root.setCenter(centerView);


        Scene scena = new Scene(root,400,400);


        primaryStage.setScene(scena);
        primaryStage.setTitle("Hello World");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
