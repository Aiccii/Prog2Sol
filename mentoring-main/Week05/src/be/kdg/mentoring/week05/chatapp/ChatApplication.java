package be.kdg.mentoring.week05.chatapp;

import be.kdg.mentoring.week05.chatapp.model.ChatModel;
import be.kdg.mentoring.week05.chatapp.view.MainPresenter;
import be.kdg.mentoring.week05.chatapp.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MainView view = new MainView();
        ChatModel model = new ChatModel();
        stage.setTitle("ACS Chat Program!");
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        MainPresenter presenter = new MainPresenter(model, view);
        stage.setScene(new Scene(view));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
