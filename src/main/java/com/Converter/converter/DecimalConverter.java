package com.Converter.converter;

import java.util.HashMap;
import java.util.Map;

public class DecimalConverter {

    public String convertFromDecimalToDecimal(String number){
        return number;
    }

    public String convertFromDecimalToBinary(String number){
        if (number.contains(".")){
            String[] number_list = number.split("\\.");
            String new_number = Integer.toBinaryString(Integer.parseInt(number_list[0])) + ".";
            StringBuilder fractional = new StringBuilder();

            double fractional_part = Double.parseDouble("0."+number_list[1]);
            int precision = 10;

            while (fractional_part > 0 && precision > 0){
                fractional_part *=2;
                if (fractional_part >=1){
                    fractional_part -=1;
                    fractional.append("1");
                }
                else {
                    fractional.append("0");
                }
                precision -=1;
            }
            new_number = new_number + fractional.toString();
            return new_number;
        }
        else {
            return Integer.toBinaryString(Integer.parseInt(number));
        }
    }

    public String convertFromDecimalToOctal(String number){
        if (number.contains(".")){
            String[] number_list = number.split("\\.");
            String new_number = Integer.toOctalString(Integer.parseInt(number_list[0])) + ".";
            StringBuilder fractional = new StringBuilder();

            double fractional_part = Double.parseDouble("0."+number_list[1]);
            int precision = 10;

            while (fractional_part > 0 && precision > 0){
                fractional_part *=8;
                String[] arr = Double.toString(fractional_part).split("\\.");
                fractional_part -=Integer.parseInt(arr[0]);
                fractional.append(arr[0]);
                precision -=1;
            }
            new_number = new_number + fractional.toString();
            return new_number;
        }
        else {
            return Integer.toOctalString(Integer.parseInt(number));
        }
    }
    public String convertFromDecimalToHexaDecimal(String number){
        Map<Integer,String> map = new HashMap<>();
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"C");
        map.put(13,"D");
        map.put(14,"E");
        map.put(15,"F");
        
        if (number.contains(".")){
            String[] number_list = number.toUpperCase().split("\\.");
            String new_number = Integer.toHexString(Integer.parseInt(number_list[0])) + ".";
            StringBuilder fractional = new StringBuilder();

            double fractional_part = Double.parseDouble("0."+number_list[1]);
            int precision = 10;

            while (fractional_part > 0 && precision > 0){
                fractional_part *=16;
                String[] arr = Double.toString(fractional_part).split("\\.");
                int theNumber = Integer.parseInt(arr[0]);

                fractional_part -=theNumber;
                if (theNumber >= 0 && theNumber <=9){
                    fractional.append(Integer.toString(theNumber));
                }
                else {
                    fractional.append(map.get(theNumber));
                }
                
                precision -=1;
            }
            new_number = new_number + fractional.toString();
            return new_number.toLowerCase();
        }
        else {
            return Integer.toHexString(Integer.parseInt(number));
        }
    }
}
