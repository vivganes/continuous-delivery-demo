package com.vivekganesan.cddemo.integration;

import com.jayway.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;

/**
 * Created by Vivek on 18-05-2017.
 */
public class TaskListIT {

    @Test
    public void testBootup(){
        RestAssured.get("/").then().assertThat().statusCode(200);
    }

    @Test
    public void testHomePageWelcomeText(){
        RestAssured.get("/").then().assertThat().body(containsString("Welcome to tasklist"));
    }

}
