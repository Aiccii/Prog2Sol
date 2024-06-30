package be.kdg.mentoring.week03.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Label helloLabel = new Label("Hello JavaFX!");
    BorderPane root = new BorderPane(helloLabel);
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
