package be.kdg.mentoring.week03.javafx.dice.view;

import be.kdg.mentoring.week03.javafx.dice.model.Dice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DiceSettingPresenter {
    private static final String IMAGES_DIR = "/images/dice";
    private final Dice model;
    private final DiceView view;

    public DiceSettingPresenter(Dice model, DiceView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getRollButton().setOnAction(new DiceHandler());
        view.getScene().getWindow().setOnCloseRequest(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
            alert.setTitle("Warning! Confirm to exit!");
            alert.showAndWait();

            if (alert.getResult() == null || alert.getResult().equals(ButtonType.CANCEL)) {
                System.out.println("Clicked: " + alert.getResult());
                e.consume();
            } else {
                view.getScene().getWindow().hide();
            }
        });
    }

    private void updateView() {/* fills view*/
        int i = 0;
        for (ImageView iv : view.getDiceView()) {
            setDiceImage(iv,model.getFaceValue(i++));
        }
    }

    void setDiceImage(ImageView diceView, int diceValue) {
        diceView.setImage(new Image(IMAGES_DIR + "/dice" + diceValue + ".png"));
    }

    private boolean isRolling = false;

    class DiceHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if(isRolling) {
                isRolling = false;
                view.getRollButton().setText("Roll");
                view.getInfoLabel().setText("Total: " + model.getTotalFaceValues());
                return;
            }
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    isRolling = true;
                    while (isRolling) {
                        model.roll();
                        updateView();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
            view.getRollButton().setText("Stop Rolling...");
            view.getInfoLabel().setText("");
            new Thread(r,"Roll-Simulation").start();

        }
    }
}
