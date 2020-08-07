package com.company.Calculator;

import com.company.Interface.Validation;

public class DataValidation implements Validation {
    @Override
    public void validation(String expression) {
        boolean bool;
        try {
            int var = Integer.parseInt(String.valueOf(expression.charAt(0)));
            bool = true;
        } catch (NumberFormatException e) {
            bool = false;
        }

        if (bool){
            ArabCalculator arabCalculator = new ArabCalculator(expression);
            System.out.println(arabCalculator.count());
        } else {
            ConvertRomanToArab convertRomanToArab = new ConvertRomanToArab(expression);

            RomanCalculator romanCalculator = new RomanCalculator(expression, convertRomanToArab.convert());
            System.out.println(romanCalculator.convert());
        }

    }
}




























/*
    public void validation(String expression) {
        boolean bool;
        try {                                                                      //Найти нормальное решение узнать
            int var = Integer.parseInt(String.valueOf(expression.charAt(0)));      //какой метод подсчета выбрать
            bool = true;                                                           //Арабский или Римский!
        } catch (NumberFormatException e) {
            bool = false;

        }

        if (bool)
            System.out.println(parseArabNum(expression));
        else
            System.out.println(parseRimNum(expression));
    }

    public double parseArabNum(String expression) {
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


    public String parseRimNum(String expression) {
        String result = "";
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


        int numResult = amount(strRimNum[1], arrayNum);
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
            }
            else if (numResult % 10 != 0) {
                tmp = numResult % 10;
                numResult=0;
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


    public int amount(String s, ArrayList<Integer> array) {
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
}*/
