package com.eugz.functions;

import javafx.scene.chart.XYChart;

public class Graph {
    private XYChart<Double, Double> graph;
    private final Function func;

    public Graph(final XYChart<Double, Double> graph, Function func) {
        this.graph = graph;
        this.func = func;
    }

    public void plotLine() {
        final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
        for (Point point : this.func.getPoints()) {
            series.getData().add(new XYChart.Data<Double, Double>(point.getX(), point.getY()));
        }
        graph.getData().add(series);
    }

    public void clear() {
        graph.getData().clear();
    }
}
