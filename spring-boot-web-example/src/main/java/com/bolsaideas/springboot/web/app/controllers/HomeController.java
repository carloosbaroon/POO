package com.bolsaideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        //This will "reset" our URL and redirect to /app/index
        return "redirect:/app/index";
        //This will not "reset" our URL and redirect to /app/index and will not allow us to forward to the "internet",
        //only our own controllers
        //return "forward:/app/index";
    }
}
