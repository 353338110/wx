package com.csh.ada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigureController {

    @RequestMapping("/wxbc")
    public String bc(){
        return "configure";
    }
}
