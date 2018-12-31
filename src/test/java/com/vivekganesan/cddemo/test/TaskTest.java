package com.vivekganesan.cddemo.test;

import com.vivekganesan.cddemo.controller.PageController;
import com.vivekganesan.cddemo.featuretoggles.AppFeatures;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.togglz.junit.TogglzRule;

/**
 * Created by Vivek on 19-05-2017.
 */
public class TaskTest {

    private PageController controller;

    @Rule
    public TogglzRule togglzRule = TogglzRule.allEnabled(AppFeatures.class);

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
        togglzRule.disable(AppFeatures.WELCOME_MESSAGE);

        String response = controller.serveHomePage();
        assert(response.equals("<h2 class='header'>Welcome to tasklist</h2>"));
    }
}
