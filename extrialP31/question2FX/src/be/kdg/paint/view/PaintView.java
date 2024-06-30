package be.kdg.paint.view;

import be.kdg.paint.model.Component;
import be.kdg.paint.model.Size;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Arrays;

public class PaintView extends BorderPane {
	private final ColorPicker colorPicker = new ColorPicker();
	private final ComboBox<String> shapePicker = new ComboBox<>();
	private final ComboBox<String> sizePicker = new ComboBox<>();
	private final Canvas canvas = new Canvas();
	private final VBox optionPane = new VBox();
	private final Button undo = new Button("Undo");


	public PaintView() {
		initialiseNodes();
		layoutNodes();
	}

	private void initialiseNodes() {
		colorPicker.setValue(Color.BLACK);
		shapePicker.setItems(FXCollections.observableArrayList("Line", "Square", "Circle"));
		ObservableList<String> sizes = FXCollections.observableArrayList();
		// TODO fill sizes List

		sizes.add(String.valueOf(Size.LARGE));
		sizes.add(String.valueOf(Size.MEDIUM));
		sizes.add(String.valueOf(Size.SMALL));
		sizePicker.setItems(sizes); // adds the sizes List to the Combobox

		shapePicker.getSelectionModel().selectFirst();

		sizePicker.getSelectionModel().selectFirst(); // makes the first selection a default

		canvas.setHeight(400);
		canvas.setWidth(400);
		clear();
	}

	private void layoutNodes() {
		optionPane.getChildren().addAll(colorPicker, shapePicker,sizePicker,undo);
		optionPane.setSpacing(20);
		optionPane.setPadding(new Insets(20));
		setLeft(optionPane);
		setCenter(canvas);

	}


	// the getters need to be package private, so no public
	Button getUndo() {
		return undo;
	}

	ColorPicker getColorPicker() {
		return colorPicker;
	}

	ComboBox<String> getSizePicker() {
		return sizePicker;
	}

	ComboBox<String> getShapePicker() {
		return shapePicker;
	}

	Canvas getCanvas() {
		return canvas;
	}


	public void clear() {
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		ctx.setFill(Color.WHITE);
		ctx.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
}
