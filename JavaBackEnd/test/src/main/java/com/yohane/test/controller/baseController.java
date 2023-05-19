package com.yohane.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class baseController {


    @ResponseBody
    @RequestMapping("/home")
    public String home(){
        return "Hello home";
    }

}
