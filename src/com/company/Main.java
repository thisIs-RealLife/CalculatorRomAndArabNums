package com.company;


import com.company.Interface.DataEntryInterface;
import com.company.Calculator.DataValidation;
import com.company.input.InputDataClass;


public class Main {

    public static void main(String[] args) {
        DataEntryInterface input = new InputDataClass();

        DataValidation dataValidation = new DataValidation();
        dataValidation.validation(input.inputData());
    }
}




