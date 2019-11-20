package com.hi.weiliao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class ViewController {

    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @RequestMapping("")
    public String index(){
        return "index";
    }
}
