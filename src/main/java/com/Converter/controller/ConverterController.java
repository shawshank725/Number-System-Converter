package com.Converter.controller;

import com.Converter.converter.ConverterDriverCode;
import com.Converter.model.NumberToBeConverted;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ConverterController {

    @Value("${format}")
    private List<String> formatUsed;

    @GetMapping("/")
    public String index(Model theModel){
        NumberToBeConverted obj = new NumberToBeConverted();
        theModel.addAttribute("obj",obj);
        theModel.addAttribute("format", formatUsed);
        return "index";
    }

    @PostMapping("/processForm")
    public ModelAndView processForm(@Valid @ModelAttribute("obj") NumberToBeConverted obj,
                                    BindingResult theBindingResult){

        if (theBindingResult.hasErrors()){
            ModelAndView view = new ModelAndView("index");
            view.addObject("obj", obj);
            view.addObject("format", formatUsed);
            return view;
        }
        else {
            String input = purifyString(obj.getNumber());
            String fromBase = obj.getConvertFrom();
            String toBase = obj.getConvertTo();
            ConverterDriverCode driverCode = new ConverterDriverCode();
            String output = driverCode.selectFunction(input,fromBase,toBase);

            if (output.contains(" ")){
                obj.setOutput(output);
            }
            else {
                obj.setOutput(output.toUpperCase());
            }

            ModelAndView view = new ModelAndView("index");
            view.addObject("obj", obj);
            view.addObject("format", formatUsed);

            return view;
        }
    }

    public static String purifyString(String number){
        if (number.endsWith(".")){
            return number.substring(0,number.length()-1);
        }
        return number;
    }
}
