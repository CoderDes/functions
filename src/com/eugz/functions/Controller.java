package com.eugz.functions;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

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

    private Map<String, Integer> getFuncParams(String funcType) {
        Map<String, Integer> params = new HashMap<>();
//        TODO: make a validation of input
        switch (funcType.toLowerCase()) {
            case "linear function":
                int linK = Integer.parseInt(linearK.getText());
                int linB = Integer.parseInt(linearB.getText());
                params.put("k", linK);
                params.put("b", linB);
                break;
            case "quadratic function":
                int quaA = Integer.parseInt(quadraticA.getText());
                int quaB = Integer.parseInt(quadraticB.getText());
                int quaC = Integer.parseInt(quadraticC.getText());
                params.put("a", quaA);
                params.put("b", quaB);
                params.put("c", quaC);
                break;
            case "cubic function":
                int cubA = Integer.parseInt(cubicA.getText());
                int cubB = Integer.parseInt(cubicB.getText());
                int cubC = Integer.parseInt(cubicC.getText());
                int cubD = Integer.parseInt(cubicD.getText());
                params.put("a", cubA);
                params.put("b", cubB);
                params.put("c", cubC);
                params.put("d", cubD);
                break;
            case "power-law function":
                int powerK = Integer.parseInt(powK.getText());
                params.put("k", powerK);
                break;
            case "exponential function":
                int x = Integer.parseInt(expoX.getText());
                params.put("x", x);
                break;
            case "sinus function":
                int sinusA = Integer.parseInt(sinA.getText());
                int sinusK = Integer.parseInt(sinK.getText());
                params.put("a", sinusA);
                params.put("k", sinusK);
                break;
        }
        return params;
    }

    public void handleRenderClick() {
        String selectedFuncType = selectFunc.getSelectionModel().getSelectedItem().toString().trim().toLowerCase();
        Map<String, Integer> funcParams = getFuncParams(selectedFuncType);

        Function func = new Function(selectedFuncType, funcParams);
        stringFuncRepresentation.setText(func.getFunctionRepresentation());
    }
}
