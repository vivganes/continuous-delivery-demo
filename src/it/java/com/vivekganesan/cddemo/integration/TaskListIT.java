package com.vivekganesan.cddemo.integration;

import com.jayway.restassured.RestAssured;
import com.vivekganesan.cddemo.testCategories.Integration;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.containsString;

/**
 * Created by Vivek on 18-05-2017.
 */
@Category(Integration.class)
public class TaskListIT {
    @Before
    public void setup(){
        RestAssured.port = 8090;
    }

    @Test
    public void testBootup(){
        RestAssured.get("/").then().assertThat().statusCode(200);
    }

    @Test
    public void testHomePageWelcomeText(){
        RestAssured.get("/").then().assertThat().body(containsString("Welcome to tasklist"));
    }

}
