package com.Converter.converter;

public class BinaryConverter {

    public String convertFromBinaryToBinary(String number){
        return number;
    }

    public String convertFromBinaryToDecimal(String number){
        if (number.contains(".")){
            String[] number_arr = number.split("\\.");

            // converting number before decimal
            StringBuilder output = new StringBuilder();
            output.append(Integer.toString(Integer.parseInt(number_arr[0],2)));

            // converting number after decimal
            int size = number_arr[1].length();
            double sum = 0;
            for (int i = size;i >=1;i--){
                if (number_arr[1].charAt(i-1) == '1'){
                    sum = sum + 1* Math.pow(2,0-i);
                }
                else {
                    sum = sum + 0.0;
                }
            }
            output.append(".").append(Double.toString(sum).split("\\.")[1]);
            return output.toString();
        }
        else {
            return Integer.toString(Integer.parseInt(number, 2));
        }
    } 

    public String convertFromBinaryToOctal(String number){
        number = convertFromBinaryToDecimal(number);      
        DecimalConverter dc = new DecimalConverter();   
        return dc.convertFromDecimalToOctal(number);
    }
    
    public String convertFromBinaryToHexaDecimal(String number) {
    	number = convertFromBinaryToDecimal(number);
        DecimalConverter dc = new DecimalConverter();   
    	return dc.convertFromDecimalToHexaDecimal(number);
    }

}
