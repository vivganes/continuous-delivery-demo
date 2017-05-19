package com.vivekganesan.cddemo.acceptance.stepdef;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vivek on 19-05-2017.
 */
public class TaskListSteps {

    private WebDriver driver;

    @Given("^there are no tasks$")
    public void thereAreNoTasks() throws Throwable {
        //TODO: Remove tasks here
    }

    @When("^i open the task list page$")
    public void iOpenTheTaskListPage() throws Throwable {
        getDriver().get("http://localhost:8090/");
    }

    @Then("^i see no tasks$")
    public void iSeeNoTasks() throws Throwable {
        assertFalse(isElementPresent(By.className("tasklist")));
        getDriver().close();
    }

    private WebDriver getDriver(){
        if(driver == null) {
            driver = new ChromeDriver();
        }
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
