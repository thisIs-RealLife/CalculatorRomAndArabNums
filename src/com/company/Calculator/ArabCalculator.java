package com.company.Calculator;

public class ArabCalculator {
    String expression;

    public ArabCalculator(String expression){
        this.expression = expression;
    }

    public double count() {
        double result = 0;
        String[] strNum = expression.split(" ");
        switch (strNum[1]) {
            case "*":
                result = Integer.parseInt(strNum[0]) * Integer.parseInt(strNum[2]);
                break;
            case "-":
                result = Integer.parseInt(strNum[0]) - Integer.parseInt(strNum[2]);
                break;
            case "+":
                result = Integer.parseInt(strNum[0]) + Integer.parseInt(strNum[2]);
                break;
            case "/":
                result = Double.parseDouble(strNum[0]) / Integer.parseInt(strNum[2]);
                break;
        }
        return result;
    }
}
