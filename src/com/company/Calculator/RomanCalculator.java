package com.company.Calculator;

import java.util.ArrayList;

public class RomanCalculator {
    private String expression;
    private ArrayList<Integer> arrayNum;


    public RomanCalculator(String expression, ArrayList<Integer> arrayNum) {
        this.expression = expression;
        this.arrayNum = arrayNum;
    }


    public String convert() {
        String result = "";
        String[] arrayStr = expression.split(" ");
        String sign = arrayStr[1];

        int numResult = amount(sign, arrayNum);
        int tmp;

        while (numResult > 0) {
            if (numResult / 100 != 0) {
                tmp = numResult / 100;
                numResult %= 100;
                if (tmp <= 3) {
                    for (int i = 0; i < tmp; i++) {
                        result += "C";
                    }
                } else if (tmp == 4) {
                    result += "CD";
                } else if (tmp == 5) {
                    result += "D";
                } else if (tmp > 5) {
                    result += "D";
                    for (int i = 0; i < tmp - 5; i++) {
                        result += "C";
                    }
                }
            } else if (numResult / 10 != 0) {
                tmp = numResult / 10;
                numResult %= 10;
                if (tmp <= 3) {
                    for (int i = 0; i < tmp; i++) {
                        result += "X";
                    }
                } else if (tmp == 4) {
                    result += "XL";
                } else if (tmp == 5) {
                    result += "L";
                } else if (tmp > 5) {
                    result += "L";
                    for (int i = 0; i < tmp - 5; i++) {
                        result += "X";
                    }
                } else if (tmp == 9) {
                    result += "XC";
                } else if (tmp == 10)
                    result += "C";
            } else if (numResult % 10 != 0) {
                tmp = numResult % 10;
                numResult = 0;
                if (tmp <= 3) {
                    for (int i = 0; i < tmp; i++) {
                        result += "I";
                    }
                } else if (tmp == 4) {
                    result += "IV";
                } else if (tmp == 5) {
                    result += "V";
                } else if (tmp > 5 && tmp != 9) {
                    result += "V";
                    for (int i = 0; i < tmp - 5; i++) {
                        result += "I";
                    }
                } else if (tmp == 9) {
                    result += "IX";
                }
            }
        }
        return result;
    }


    public int amount(String s,ArrayList<Integer> array) {
        int symm = 0;
        switch (s) {
            case "+":
                symm = array.get(0) + array.get(1);
                break;
            case "-":
                symm = array.get(0) - array.get(1);
                break;
            case "*":
                symm = array.get(0) * array.get(1);
                break;
            case "/":
                symm = array.get(0) / array.get(1);
        }
        return symm;
    }
}
