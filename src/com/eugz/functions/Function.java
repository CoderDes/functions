package com.eugz.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Function {
    private String name;
    private Map<String, Integer> parameters;
    private String stringFuncRepresentation;
    private List<Point> points;

    public Function(String mathFunctionName, Map<String, Integer> parameters) {
        this.name = mathFunctionName;
        this.parameters = parameters;
        this.points = new ArrayList<>();
        buildFunctionRepresentation();
        generatePoints();
    }

    private void buildFunctionRepresentation() {
        if (this.parameters.size() == 0) {
            System.out.println("There is no parameters");
            return;
        }

        String formattedName = this.name.toLowerCase().trim();
        if (formattedName.equals("linear function")) {
            double k = this.parameters.get("k");
            double b = this.parameters.get("b");
            this.stringFuncRepresentation =  "f(x) = " + k + "x " + "+ " + b;
        } else if (formattedName.equals("quadratic function")) {
            double a = this.parameters.get("a");
            double b = this.parameters.get("b");
            double c = this.parameters.get("c");
            this.stringFuncRepresentation = "f(x) = " + a + "x^2" + " + " + b + "x" + " + " + c;
        } else if (formattedName.equals("cubic function")) {
            double a = this.parameters.get("a");
            double b = this.parameters.get("b");
            double c = this.parameters.get("c");
            double d = this.parameters.get("d");
            this.stringFuncRepresentation = "f(x) = " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d;
        } else if (formattedName.equals("power-law function")) {
            double k = this.parameters.get("k");
            this.stringFuncRepresentation = "f(x) = " + k + "^x";
        } else if (formattedName.equals("exponential function")) {
            double x = this.parameters.get("x");
            this.stringFuncRepresentation = "f(x) = e^" + x;
        } else if (formattedName.equals("sinus function")) {
            double a = this.parameters.get("a");
            double k = this.parameters.get("k");
            this.stringFuncRepresentation = "f(x) = " + k + "sin" + a + "x";
        }
    }

    public String getFunctionRepresentation() {
        return this.stringFuncRepresentation;
    }

    private void generatePoints() {
        switch (this.name) {
            case "linear function":
                for (double i = -100; i <= 100; i++) {
                    double y = this.parameters.get("k") * i + this.parameters.get("b");
                    this.points.add(new Point(i, y));
                }
                break;
            case "quadratic function":
                for (double i = -100; i <= 100; i++) {
                    double y = this.parameters.get("a") * Math.pow(i, 2.0) + this.parameters.get("b") * i + this.parameters.get("c");
                    this.points.add(new Point(i, y));
                }
            case "cubic function":
                for (double i = -100; i <= 100; i++) {
                    double y =
                            this.parameters.get("a") * Math.pow(i, 3.0) +
                            this.parameters.get("b") * Math.pow(i, 2.0) +
                            this.parameters.get("c") * i +
                            this.parameters.get("d");
                    this.points.add(new Point(i, y));
                }
                break;
            case "power-law function":
                for (double i = -100; i <= 100; i++) {
                    double y = Math.pow(this.parameters.get("k"), i);
                    this.points.add(new Point(i, y));
                }
                break;
            case "exponential function":
//                TODO: do something with x parameter here
                for (double i = -100; i <= 100; i++) {
                    double y = Math.pow(Math.E, i);
                    this.points.add(new Point(i, y));
                }
                break;
            case "sinus function":
                for (double i = -1.0; i <= 1.0; i += 0.01) {
                    double y = this.parameters.get("a") * Math.sin(this.parameters.get("k") * i);
                    this.points.add(new Point(i, y));
                }
                break;
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
