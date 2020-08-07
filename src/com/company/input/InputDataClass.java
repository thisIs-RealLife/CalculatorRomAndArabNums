package com.company.input;

import com.company.Interface.DataEntryInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputDataClass implements DataEntryInterface {
    public String inputData() {
        String result ="";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            result = bufferedReader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
