package com.Converter.converter;

public class OctalConverter {
    
    public String convertFromOctalToDecimal(String number){
        if (number.contains(".")){
            String[] number_arr = number.split("\\.");
            StringBuilder output = new StringBuilder();

            // handling number before decimal
            int size = number_arr[0].length()-1;
            int sum = 0;
            
            for (char i: number_arr[0].toCharArray()){
                sum =(int) (sum + Integer.parseInt(Character.toString(i)) * Math.pow(8, size));
                size --;
            }
            double fractional_sum = 0;
            int pow = -1;
            // handling the number after decimal
            for (char i: number_arr[1].toCharArray()){
                fractional_sum += Integer.parseInt(Character.toString(i)) * Math.pow(8,pow);
                pow--;
            }
            output.append(sum+fractional_sum);
            return output.toString();
        }
        int size = number.length()-1;
        int sum = 0;
        
        for (char i: number.toCharArray()){
            sum =(int) (sum + Integer.parseInt(Character.toString(i)) * Math.pow(8, size));
            size --;
        }
        return Integer.toString(sum);
    } 

    public String convertFromOctalToBinary(String number){
        OctalConverter oc = new OctalConverter();
        number = oc.convertFromOctalToDecimal(number);
        DecimalConverter dc = new DecimalConverter(); 
        return dc.convertFromDecimalToBinary(number);
    }

    public String convertFromOctalToOctal(String number){
        return number;
    }
    public String convertFromOctalToHexaDecimal(String number){
        OctalConverter oc = new OctalConverter();
        BinaryConverter bc = new BinaryConverter();
        number = oc.convertFromOctalToBinary(number);
        return bc.convertFromBinaryToHexaDecimal(number);
    }
}
