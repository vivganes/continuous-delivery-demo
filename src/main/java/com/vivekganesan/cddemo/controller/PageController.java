package com.vivekganesan.cddemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vivek on 18-05-2017.
 */
@RestController
public class PageController {

    @RequestMapping(path="/", method= RequestMethod.GET)
    public String serveHomePage(){
        return "<h2 class='header'>Welcome to tasklist</h2>";
    }
}
