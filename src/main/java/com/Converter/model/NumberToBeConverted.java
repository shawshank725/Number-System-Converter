package com.Converter.model;

import jakarta.validation.constraints.NotNull;

public class NumberToBeConverted {

    @NotNull(message="Input cannot be empty!")
    private String number = "";
    private String convertFrom = "";
    private String convertTo = "";
    private String output = "";

    public NumberToBeConverted(){}

    public NumberToBeConverted(String number, String convertFrom, String convertTo,String output) {
        this.number = number;
        this.convertFrom = convertFrom;
        this.convertTo = convertTo;
        this.output = output;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(String convertFrom) {
        this.convertFrom = convertFrom;
    }

    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "NumberToBeConverted{" +
                "number='" + number + '\'' +
                ", convertFrom='" + convertFrom + '\'' +
                ", convertTo='" + convertTo + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
