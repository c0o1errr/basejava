package com.basejava.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[] {"1", "2", "3", "4", "5"};
        String result = "";
        for(String str: strArray){
            result+= str + ", ";
        }
        System.out.println(result);


    }
}
