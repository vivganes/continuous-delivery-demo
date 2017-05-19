package com.vivekganesan.cddemo.acceptance;

import com.vivekganesan.cddemo.testCategories.Acceptance;
import cucumber.junit.Cucumber;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

/**
 * Created by Vivek on 19-05-2017.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber","json:target/cukes/report.json", "junit:target/cukes/junit.xml"})
@Category(Acceptance.class)
public class AcceptanceTest {
}
