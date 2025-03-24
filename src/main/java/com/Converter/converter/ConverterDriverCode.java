package com.Converter.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterDriverCode {
    
    @SuppressWarnings("ConvertToStringSwitch")
    public String selectFunction(String number, String fromBase, String toBase){
        DecimalConverter dc = new DecimalConverter();
        BinaryConverter bc = new BinaryConverter();
        OctalConverter oc = new OctalConverter();
        HexaDecimalConverter hdc = new HexaDecimalConverter();

        number = number.toUpperCase().strip();

        if (fromBase.equals("Decimal")){
            boolean matchFound = isDecimalOrOctal(number);
            if (matchFound) {
                if (toBase.equals("Decimal")) {
                    return dc.convertFromDecimalToDecimal(number);
                } else if (toBase.equals("Binary")) {
                    return dc.convertFromDecimalToBinary(number);
                } else if (toBase.equals("Octal")) {
                    return dc.convertFromDecimalToOctal(number);
                } else {
                    return dc.convertFromDecimalToHexaDecimal(number);
                }
            }
            else {
                return "Given input contains characters other than digits fro 0 to 9.";
            }
        }

        // for handling binary from bases
        else if (fromBase.equals("Binary")){
            boolean matchFound = isBinary(number);

            if (matchFound) {
                if (toBase.equals("Decimal")) {
                    return bc.convertFromBinaryToDecimal(number);
                } else if (toBase.equals("Binary")) {
                    return bc.convertFromBinaryToBinary(number);
                } else if (toBase.equals("Octal")) {
                    return bc.convertFromBinaryToOctal(number);
                } else {
                    return bc.convertFromBinaryToHexaDecimal(number);
                }
            }
            else {
                return "Given input contains digits or characters other than 0 and 1.";
            }
        }

        // for handling octal from bases
        else if (fromBase.equals("Octal")){
            boolean matchFound = isDecimalOrOctal(number);
            if (matchFound) {
                if (toBase.equals("Decimal")) {
                    return oc.convertFromOctalToDecimal(number);
                } else if (toBase.equals("Binary")) {
                    return oc.convertFromOctalToBinary(number);
                } else if (toBase.equals("Octal")) {
                    return oc.convertFromOctalToOctal(number);
                } else {
                    return oc.convertFromOctalToHexaDecimal(number);
                }
            }
            else {
                return "Given input contains characters other than digits fro 0 to 9.";
            }
        }

        // for handling hexadecimal from bases
        else {
            boolean matchFound = isHexa(number);
            if (matchFound) {
                if (toBase.equals("Decimal")) {
                    return hdc.convertFromHexaDecimalToDecimal(number);
                } else if (toBase.equals("Binary")) {
                    return hdc.convertFromHexaDecimalToBinary(number);
                } else if (toBase.equals("Octal")) {
                    return hdc.convertFromHexaDecimalToOctal(number);
                } else {
                    return hdc.convertFromHexaDecimalToHexaDecimal(number);
                }
            }
            else {
                return "Given input contains characters other than a,b,c,d,e,f.";
            }
        }   
    }

    public static boolean isBinary(String number) {
        return number.matches("[01]+(\\.[01]+)?"); // Ensures the entire string contains only 0s and 1s
    }

    public static boolean isHexa(String number){
        return number.matches("[a-fA-F0-9]+(\\.[a-fA-F0-9]+)?"); // Ensures the entire string contains only 0s and 1s
    }

    public static boolean isDecimalOrOctal(String number){
        return number.matches("[0-9]+(\\.[0-9]+)?"); // Ensures the entire string contains only 0s and 1s
    }
}
