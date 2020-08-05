package com.eugz.functions;

import java.util.List;
import java.util.Map;

public class Function {
    private String name;
    private Map<String, Integer> parameters;
    private String functionRepresentation;
    private List<Point> points;

    public Function(String mathFunctionName, Map<String, Integer> parameters) {
        this.name = mathFunctionName;
        this.parameters = parameters;
        buildFunctionRepresentation();
    }

    private void buildFunctionRepresentation() {
        if (parameters.size() == 0) {
            System.out.println("There is no parameters");
            return;
        }

        String formattedName = name.toLowerCase().trim();
        if (formattedName.equals("linear function")) {
            int k = parameters.get("k");
            int b = parameters.get("b");
            this.functionRepresentation =  "f(x) = " + k + "x " + "+ " + b;
        } else if (formattedName.equals("quadratic function")) {
            int a = parameters.get("a");
            int b = parameters.get("b");
            int c = parameters.get("c");
            this.functionRepresentation = "f(x) = " + a + "x^2" + " + " + b + "x" + " + " + c;
        } else if (formattedName.equals("cubic function")) {
            int a = parameters.get("a");
            int b = parameters.get("b");
            int c = parameters.get("c");
            int d = parameters.get("d");
            this.functionRepresentation = "f(x) = " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d;
        } else if (formattedName.equals("power-law function")) {
            int k = parameters.get("k");
            this.functionRepresentation = "f(x) = " + k + "^x";
        } else if (formattedName.equals("exponential function")) {
            int x = parameters.get("x");
            this.functionRepresentation = "f(x) = e^" + x;
        } else if (formattedName.equals("sinus function")) {
            int a = parameters.get("a");
            int k = parameters.get("k");
            this.functionRepresentation = "f(x) = " + k + "sin" + a + "x";
        }
    }

    public String getFunctionRepresentation() {
        return this.functionRepresentation;
    }

    private void generatePoints() {
        switch (name) {
            case "linear function":
                for (int i = 0; i < 100; i++) {

                }
        }
    }
}
