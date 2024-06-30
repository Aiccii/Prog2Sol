package be.kdg.prog12.chart.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;

public class PieChartView extends BorderPane {
	private PieChart pie;

	public PieChartView() {
		initialiseNodes();
		layoutNodes();
	}

	private void initialiseNodes() {
		ObservableList<PieChart.Data> pieChartData =
			FXCollections.observableArrayList(
				new PieChart.Data("Text", 1),
				new PieChart.Data("Code", 19),
				new PieChart.Data(";)", 80));
		this.pie = new PieChart(pieChartData);

	}


	private void layoutNodes() {

		this.pie.setTitle("Where do I type semicolons?");
		this.setCenter(this.pie);
	}

	// package-private Getters
	// for controls used by Presenter

}
