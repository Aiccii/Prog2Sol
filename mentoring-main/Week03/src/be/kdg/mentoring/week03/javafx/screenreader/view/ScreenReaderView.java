package be.kdg.mentoring.week03.javafx.screenreader.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class ScreenReaderView extends BorderPane {
    private Button readButton;
    private TextArea textArea;
    public ScreenReaderView() {
        initialiseNodes();
        layoutNodes();
//        addEventHandlers();
    }

//    private void addEventHandlers() {
//        readButton.setOnAction(event -> {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText("Not Now!");
//            alert.setTitle("Screen Reader");
//            alert.showAndWait();
//        });
//    }

//    private void addEventHandlers() {
//        readButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setHeaderText("Not Now!");
//                alert.setTitle("Screen Reader");
//                alert.showAndWait();
//            }
//        });
//    }

    private void initialiseNodes() {
        readButton = new Button("Read Aloud");
        textArea = new TextArea("Enter text to read");
    }

    private void layoutNodes() {
        setCenter(textArea);
        setBottom(readButton);
        BorderPane.setAlignment(readButton, Pos.CENTER);
        BorderPane.setMargin(readButton, new Insets(10, 10, 10, 10));
    }

    public Button getReadButton() {
        return readButton;
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
