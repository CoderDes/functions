package com.eugz.functions;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.*;

public class Controller {

    @FXML
    private ComboBox selectFunc;

    @FXML
    private GridPane linearParams;

    @FXML
    private TextField linearK;

    @FXML
    private TextField linearB;

    @FXML
    private GridPane quadraticParams;

    @FXML
    private TextField quadraticA;

    @FXML
    private TextField quadraticB;

    @FXML
    private TextField quadraticC;

    @FXML
    private GridPane cubicParams;

    @FXML
    private TextField cubicA;

    @FXML
    private TextField cubicB;

    @FXML
    private TextField cubicC;

    @FXML
    private TextField cubicD;

    @FXML
    private GridPane powerLawParams;

    @FXML
    private TextField powK;

    @FXML
    private GridPane expoParams;

    @FXML
    private TextField expoX;

    @FXML
    private GridPane sinusParams;

    @FXML
    private TextField sinA;

    @FXML
    private TextField sinK;

    @FXML
    private Label stringFuncRepresentation;

    @FXML
    private LineChart lineGraph;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private List<Graph> graphs = new ArrayList();

    public void initialize() {
        linearParams.setVisible(true);
        quadraticParams.setVisible(false);
        cubicParams.setVisible(false);
        powerLawParams.setVisible(false);
        expoParams.setVisible(false);
        sinusParams.setVisible(false);

        linearParams.managedProperty().bind(linearParams.visibleProperty());
        quadraticParams.managedProperty().bind(quadraticParams.visibleProperty());
        cubicParams.managedProperty().bind(cubicParams.visibleProperty());
        expoParams.managedProperty().bind(expoParams.visibleProperty());
        powerLawParams.managedProperty().bind(powerLawParams.visibleProperty());
        sinusParams.managedProperty().bind(sinusParams.visibleProperty());
    }

    public void selectFuncHandler() {
        renderParamsFields();
        stringFuncRepresentation.setText("");
    }

    private void renderParamsFields() {
        String selectedFuncType = selectFunc.getSelectionModel().getSelectedItem().toString().trim().toLowerCase();
        switch (selectedFuncType) {
            case "linear function":
                linearParams.setVisible(true);
                quadraticParams.setVisible(false);
                cubicParams.setVisible(false);
                powerLawParams.setVisible(false);
                expoParams.setVisible(false);
                sinusParams.setVisible(false);
                break;
            case "quadratic function":
                linearParams.setVisible(false);
                quadraticParams.setVisible(true);
                cubicParams.setVisible(false);
                powerLawParams.setVisible(false);
                expoParams.setVisible(false);
                sinusParams.setVisible(false);
                break;
            case "cubic function":
                linearParams.setVisible(false);
                quadraticParams.setVisible(false);
                cubicParams.setVisible(true);
                powerLawParams.setVisible(false);
                expoParams.setVisible(false);
                sinusParams.setVisible(false);
                break;
            case "power-law function":
                linearParams.setVisible(false);
                quadraticParams.setVisible(false);
                cubicParams.setVisible(false);
                powerLawParams.setVisible(true);
                expoParams.setVisible(false);
                sinusParams.setVisible(false);
                break;
            case "exponential function":
                linearParams.setVisible(false);
                quadraticParams.setVisible(false);
                cubicParams.setVisible(false);
                powerLawParams.setVisible(false);
                expoParams.setVisible(true);
                sinusParams.setVisible(false);
                break;
            case "sinus function":
                linearParams.setVisible(false);
                quadraticParams.setVisible(false);
                cubicParams.setVisible(false);
                powerLawParams.setVisible(false);
                expoParams.setVisible(false);
                sinusParams.setVisible(true);
                break;
        }
    }

    private Map<String, Double> getFuncParams(String funcType) {
        Map<String, Double> params = new HashMap<>();

        switch (funcType.toLowerCase()) {
            case "linear function":
                double linK = Double.parseDouble(linearK.getText());
                double linB = Double.parseDouble(linearB.getText());
                params.put("k", linK);
                params.put("b", linB);
                break;
            case "quadratic function":
                double quaA = Double.parseDouble(quadraticA.getText());
                double quaB = Double.parseDouble(quadraticB.getText());
                double quaC = Double.parseDouble(quadraticC.getText());
                params.put("a", quaA);
                params.put("b", quaB);
                params.put("c", quaC);
                break;
            case "cubic function":
                double cubA = Double.parseDouble(cubicA.getText());
                double cubB = Double.parseDouble(cubicB.getText());
                double cubC = Double.parseDouble(cubicC.getText());
                double cubD = Double.parseDouble(cubicD.getText());
                params.put("a", cubA);
                params.put("b", cubB);
                params.put("c", cubC);
                params.put("d", cubD);
                break;
            case "power-law function":
                double powerK = Double.parseDouble(powK.getText());
                params.put("k", powerK);
                break;
            case "exponential function":
                double x = Double.parseDouble(expoX.getText());
                params.put("x", x);
                break;
            case "sinus function":
                double sinusA = Double.parseDouble(sinA.getText());
                double sinusK = Double.parseDouble(sinK.getText());
                params.put("a", sinusA);
                params.put("k", sinusK);
                break;
        }
        return params;
    }

    public void handleRenderClick() {
        String selectedFuncType = selectFunc.getSelectionModel().getSelectedItem().toString().trim().toLowerCase();
        Map<String, Double> funcParams = getFuncParams(selectedFuncType);

        Function func = new Function(selectedFuncType, funcParams);
        stringFuncRepresentation.setText(func.getFunctionRepresentation());

        xAxis.setUpperBound(func.getRange());
        xAxis.setLowerBound(-func.getRange());
        yAxis.setUpperBound(func.getRange());
        yAxis.setLowerBound(-func.getRange());

        Graph myGraph = new Graph(lineGraph, func);
        graphs.add(myGraph);
        myGraph.plotLine();
    }

    public void handleClearClick() {
        if (graphs.isEmpty()) {
            System.out.println("IS EMPTY");
            return;
        }

        Iterator<Graph> iter = graphs.iterator();

        while (iter.hasNext()) {
            Graph graph = iter.next();
            graph.clear();
            iter.remove();
        }

        clearTheForm();
    }

    public void clearTheForm() {
        linearK.setText("");
        linearB.setText("");
        quadraticA.setText("");
        quadraticB.setText("");
        quadraticC.setText("");
        cubicA.setText("");
        cubicB.setText("");
        cubicC.setText("");
        cubicD.setText("");
        powK.setText("");
        expoX.setText("");
        sinA.setText("");
        sinK.setText("");
        stringFuncRepresentation.setText("");
    }
}
