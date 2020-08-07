package com.company.Interface;

public interface Validation {
    char PLUS = '+';
    char MINUS = '-';
    char MULTIPLY = '*';
    char DIVISION = '/';

    char[] arrayArabNum = {'1','2','3','4','5','6','7','8','9','0'};
    char[] arrayRimNum = {'I','V','X','L','C'};
    String[] stringArrayArabNum = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

    void validation(String expression) throws IllegalAccessException;
}
