package com.applitools.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class HomePageTest extends WebTest {
    @BeforeClass
    public void homePageTest_beforeClass() {
        // Log in before starting the test
        this.catalog.loginPage().enterUsername("jackgomez");
        this.catalog.loginPage().enterPassword("passwordForJack");
        this.catalog.loginPage().clickSignIn();
    }

    @BeforeMethod
    public void homePageTest_beforeMethod() {
        // Ensure that the test begin on the home page
        driver.get("https://demo.applitools.com/app.html");
    }
}
