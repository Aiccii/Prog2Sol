package be.kdg.mentoring.week05.chatapp.view.receiver;

import java.util.List;

import be.kdg.mentoring.week05.chatapp.model.ChatModel;


public class ReceiverPresenter {

    private final ChatModel model;
    private final ReceiverView view;

    public ReceiverPresenter(ChatModel model, ReceiverView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getButton().setOnAction( event -> {
            // 1- Get the messages from the model
            // 2- put the messages in the text area!
            List<String> messages = model.getMessages();
            view.getMessagesArea().clear();
            for (String message : messages) {
                view.getMessagesArea().setText(
                        view.getMessagesArea().getText() + message + "\n");
            }

        });
    }
}
