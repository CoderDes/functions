package com.eugz.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Function {
    private String name;
    private Map<String, Integer> parameters = new HashMap();
    private List<Point> points;

    public Function(String mathFunctionName) {
        name = mathFunctionName;
    }

    public void setParameters(Map<String, Integer> parameters) {
        this.parameters = parameters;
    }

    private void generatePoints() {
        switch (name) {
            case "linear function":
                for (int i = 0; i < 100; i++) {

                }
        }
    }
}
