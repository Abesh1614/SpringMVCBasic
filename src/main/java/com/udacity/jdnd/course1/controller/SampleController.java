package com.udacity.jdnd.course1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @RequestMapping("/homepage")
    public String getHome(){
        System.out.println("Controller method called");
        return "home";
    }
}
