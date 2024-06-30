package be.kdg.mentoring.week05.chatapp.view.sender;


import be.kdg.mentoring.week05.chatapp.model.ChatModel;

public class SenderPresenter {

    private final ChatModel model;
    private final SenderView view;

    public SenderPresenter(ChatModel model, SenderView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getButton().setOnAction( event -> {
            // 1- read the message from the text area
            // 2- send the message by invoking model.addMessage()
            String msg = view.getMessagesArea().getText();
            model.addMessage(msg);
            view.getMessagesArea().setText("");
        });
    }
}
