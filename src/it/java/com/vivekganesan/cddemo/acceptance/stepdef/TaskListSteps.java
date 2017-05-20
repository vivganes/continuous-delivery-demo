package com.vivekganesan.cddemo.acceptance.stepdef;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vivek on 19-05-2017.
 */
public class TaskListSteps {

    private WebDriver driver;

    @Before
    public void beforeScenario(){
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @After
    public void afterScenario(){
        getDriver().close();
    }

    @Given("^there are no tasks$")
    public void thereAreNoTasks() throws Throwable {
        //TODO: Remove tasks using DB Script here
    }

    @When("^i open the task list page$")
    public void iOpenTheTaskListPage() throws Throwable {
        getDriver().get("http://localhost:8090/");
    }


    @Then("^i see a header welcoming me$")
    public void iSeeAHeaderWelcomingMe() throws Throwable {
        assertTrue(isElementPresent(By.className("header")));
        assertTrue(getDriver().findElement(By.className("header")).getText().equals("Welcome to tasklist"));
    }

    private WebDriver getDriver() {
        return driver;
    }

    private boolean isElementPresent(By locatorKey) {
        try {
            getDriver().findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
