package com.Converter.converter;

import java.util.HashMap;
import java.util.Map;

public class HexaDecimalConverter {
    
    public String convertFromHexaDecimalToDecimal(String number){
        number = number.toUpperCase();
        Map<String,Integer> map = new HashMap<>();
        map.put("A",10);
        map.put("B",11);
        map.put("C",12);
        map.put("D",13);
        map.put("E",14);
        map.put("F",15);
        
        if (number.contains(".")){
            String[] number_arr = number.split("\\.");
            int size = number_arr[0].length()-1;
            int sum = 0;
            StringBuilder output = new StringBuilder();
            for (char i: number_arr[0].toCharArray()){
                if (map.containsKey(Character.toString(i))){
                    sum = sum + (int) (map.get(Character.toString(i))*Math.pow(16,size));
                }
                else {
                    sum = sum + (int) (Integer.parseInt(Character.toString(i)) * Math.pow(16,size));
                }
                size--;
            }

            double fractional_sum = 0.0;
            int pow = -1;
            for (char i : number_arr[1].toCharArray()){
                if (map.containsKey(Character.toString(i))){
                    fractional_sum += map.get(Character.toString(i))*Math.pow(16,pow);
                }
                else {
                    fractional_sum += Integer.parseInt(Character.toString(i)) * Math.pow(16,pow);
                }
                pow--;
            }

            output.append(sum+fractional_sum);
            return output.toString();
        }
        int size = number.length()-1;
        int sum = 0;
        StringBuilder output = new StringBuilder();
        for (char i: number.toCharArray()){
            if (map.containsKey(Character.toString(i))){
                sum = sum + (int) (map.get(Character.toString(i))*Math.pow(16,size));
            }
            else {
                sum = sum + (int) (Integer.parseInt(Character.toString(i)) * Math.pow(16,size));
            }
            size--;
        }
        output.append(sum);
        return output.toString();
    }

    public String convertFromHexaDecimalToBinary(String number){
        HexaDecimalConverter hdc = new HexaDecimalConverter();
        number = hdc.convertFromHexaDecimalToDecimal(number);
        DecimalConverter dc = new DecimalConverter();
        return dc.convertFromDecimalToBinary(number);
    }

    public String convertFromHexaDecimalToOctal(String number){
        HexaDecimalConverter hdc = new HexaDecimalConverter();
        number = hdc.convertFromHexaDecimalToDecimal(number);
        DecimalConverter dc = new DecimalConverter();
        return dc.convertFromDecimalToOctal(number);
    }

    public String convertFromHexaDecimalToHexaDecimal(String number){
        return number;
    }
    public static void main(String[] args){
        
        HexaDecimalConverter hdc = new HexaDecimalConverter();
        System.out.println(hdc.convertFromHexaDecimalToOctal("12.1A6"));
    }
}
