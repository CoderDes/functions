package com.eugz.functions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;

public class Chart {
    private Parent root;
    private NumberAxis x;
    private NumberAxis y;
    private XYChart.Series allGraphics;
    private ObservableList data;

    private Chart() throws IOException {
        root = new FXMLLoader().load(getClass().getResource("mainWindow.fxml"));
        x = new NumberAxis();
        y = new NumberAxis();

        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
        allGraphics = new XYChart.Series();
        data = FXCollections.observableArrayList();
    }

    public void draw(String mathFunctionName) {

    }
}
