package be.kdg.time.view;

import be.kdg.time.model.TimeModel;

import java.time.LocalTime;

public class Presenter {

    TimeModel model;
    TimeView view;

    public Presenter(TimeModel model, TimeView view) {
        setModel(model);
        setView(view);
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getSlider().setOnMouseDragged(e -> {
            double value = view.getSlider().getValue();

            int hour = (int) Math.floor(value);
            int minute = (int) ((value - hour) * 60);
            model.setCurrentTime(LocalTime.of(hour, minute));

            updateView();
        });
    }


    private void updateView() {
        view.applyDaylightSun(model.getDaylightPercentage(), model.getSunHeight(), model.getSunPositionX());

        double hours = model.getCurrentTime().getHour();
        double minute = (double) model.getCurrentTime().getMinute() / 60;
        double time = hours + minute;


        view.getSlider().setValue(time);


    }




    private void setModel(TimeModel model) {
        this.model = model;
    }

    private void setView(TimeView view) {
        this.view = view;
    }
}
