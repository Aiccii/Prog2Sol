package be.kdg.mentoring.week03.javafx.screenreader.view;

import be.kdg.mentoring.week03.javafx.screenreader.model.ScreenReader;

public class ScreenReaderPresenter {
    private final ScreenReader model;
    private final ScreenReaderView view;

    public ScreenReaderPresenter(ScreenReader model, ScreenReaderView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {
        view.getTextArea().setText(model.getText());
    }

    private void addEventHandlers() {
        view.getReadButton().setOnAction(event -> {
            model.setText(view.getTextArea().getText());
            model.readAloud();
            updateView();
        });
    }
}
