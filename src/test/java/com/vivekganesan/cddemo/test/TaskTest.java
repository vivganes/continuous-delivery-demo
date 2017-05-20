package com.vivekganesan.cddemo.test;

import com.vivekganesan.cddemo.controller.PageController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vivek on 19-05-2017.
 */
public class TaskTest {

    private PageController controller;

    @Before
    public void setup(){
        controller = new PageController();
    }

    @After
    public void teardown(){
        controller = null;
    }

    @Test
    public void testHomePageContent(){
        String response = controller.serveHomePage();
        assert(response.equals("<h2 class='header'>Welcome to tasklist</h2>"));
    }
}
