package com.vivekganesan.cddemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.vivekganesan.cddemo.featuretoggles.AppFeatures.HEADER_TEXT;
import static com.vivekganesan.cddemo.featuretoggles.AppFeatures.WELCOME_MESSAGE;

/**
 * Created by Vivek on 18-05-2017.
 */
@RestController
public class PageController {

    @RequestMapping(path="/", method= RequestMethod.GET)
    public String serveHomePage(){
        StringBuffer response = new StringBuffer("");
        if(HEADER_TEXT.isActive()) {
            response.append("<h2 class='header'>Welcome to tasklist</h2>");
        }

        if(WELCOME_MESSAGE.isActive()){
            response.append("<p>This is an application which enables you to manage your tasks</p>");
        }

        return response.toString();
    }
}
