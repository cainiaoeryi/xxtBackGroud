package com.my.xxtbackgroud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
    @RequestMapping ("/h5")
    public String getHtml(){
        return "demo.html";
    }
}
