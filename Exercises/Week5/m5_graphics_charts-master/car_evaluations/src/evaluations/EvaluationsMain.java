package evaluations;

import evaluations.model.Evaluation;
import evaluations.model.Evaluations;
import evaluations.view.EvaluationsView;
import evaluations.view.EvaluationsPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EvaluationsMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        Evaluations model = new Evaluations();
        fillModel( model);
        EvaluationsView view = new EvaluationsView();
        new EvaluationsPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Car Evaluations");
        primaryStage.setWidth(800.0);
        primaryStage.setHeight(600.0);
        primaryStage.show();
    }

    private void fillModel(Evaluations model) {
        model.add("Fiat", new Evaluation(3.0, 5.0, 5.0));
        model.add("Audi", new Evaluation(6.0, 10.0, 4.0));
        model.add("Ford", new Evaluation(2.0, 3.0, 6.0));

    }

    public static void main(String[] args) {
        launch(args);
    }
}
