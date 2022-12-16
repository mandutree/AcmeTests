package com.applitools.demo.login;

import com.applitools.demo.WebTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends WebTest {
    @BeforeMethod
    public void loginTest_beforeMethod() {
        // Begin each test from the login page
        this.driver.get(WEB_URL);
    }

    @Test
    public void canLogin() throws InterruptedException {
        this.catalog.loginPage().enterUsername("jackgomez");
        this.catalog.loginPage().enterPassword("passwordForJack");
        this.catalog.loginPage().clickSignIn();

        // Slowing down for demo purpose
        Thread.sleep(1000);

        // Checking to ensure that we land on the home page
        Assert.assertEquals(this.catalog.homePage().recentTransactions().title(), "Recent Transactions");
    }
}
