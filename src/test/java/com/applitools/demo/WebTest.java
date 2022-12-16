package com.applitools.demo;

import com.appium.driver.capability.ChromeOptionsBuilder;
import com.appium.driver.factory.ChromeDriverFactory;
import com.appium.driver.factory.DriverFactory;
import com.applitools.demo.page.common.PageType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebTest {
    protected static final String WEB_URL = "https://demo.applitools.com";

    protected WebDriver driver;

    protected DriverFactory driverFactory;
    protected AcmeCatalog catalog;

    @BeforeClass
    public void setup_webTest_beforeClass() {
        // Determine which device we're testing on from System Properties
        String type = System.getProperty("clientType");
        if (type == null || StringUtils.isEmpty(type) || type == "chrome") {
            // Determine the browser characteristics
            ChromeOptionsBuilder optionsBuilder =
                ChromeOptionsBuilder
                    .getInstance()
                    .hideScrollbars()
                    .fullScreen()
                    //.headless()
                    //.windowSize(800, 600)
                    .disableInfoBars();

            // Construct the WebDriver factory
            this.driverFactory = ChromeDriverFactory.getInstance().withCapabilityBuilder(optionsBuilder);
            this.driver = driverFactory.create();
            this.catalog = new AcmeCatalog(driver, PageType.WEB);
        } else {
            throw new RuntimeException("This demo does not currently support other client types");
        }

        // Begin the test from the login form
        this.driver.get(WEB_URL);
    }

    @AfterClass
    public void cleanup_webTest_afterClass() {
        // Close the browser at the end of all the tests in the class
        this.driver.quit();
    }
}
