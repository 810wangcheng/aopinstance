package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {
    @RequestMapping("doIndex")
    public String doIndex(){
        return "index";
    }
}
