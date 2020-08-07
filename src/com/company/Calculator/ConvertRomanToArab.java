package com.company.Calculator;

import com.company.Interface.Validation;

import java.util.ArrayList;

public class ConvertRomanToArab {
    String expression;

    public ConvertRomanToArab(String expression) {
        this.expression = expression;
    }

    public ArrayList<Integer> convert(){
        ArrayList<Integer> arrayNum = new ArrayList<>();

        String[] strRimNum = expression.split(" ");


        for (String s : strRimNum) {
            char[] chars = s.toCharArray();
            int tmp = 0;
            boolean flag = false;

            if (chars[0] == Validation.MINUS || chars[0] == Validation.DIVISION || chars[0] == Validation.PLUS || chars[0] == Validation.MULTIPLY)
                continue;

            if (chars.length > 1) {
                try {
                    for (int i = chars.length - 1; i > 0; i--) {
                        if (convert(chars[i - 1]) < convert(chars[i])) {
                            tmp += convert(chars[i]) - convert(chars[i - 1]);
                            i -= 1;
                        } else {
                            if (i == 1)
                                flag = true;

                            tmp += convert(chars[i]);
                        }
                    }
                    if (flag)
                        tmp += convert(chars[0]);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                tmp += convert(chars[0]);
            }
            arrayNum.add(tmp);
        }
        return arrayNum;
    }

    public int convert(char r) {
        switch (r) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            default: {
                throw new IllegalArgumentException("Введено неверное значение");
            }
        }
    }
}
