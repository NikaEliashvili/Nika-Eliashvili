package com.homework.base;

import com.homework.utils.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createChrome();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // If failed -> attach screenshot
        if (!result.isSuccess()) {
            saveScreenshotPNG(driver);
            savePageSource(driver);
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        if (driver == null) return new byte[0];
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page Source", type = "text/html")
    public String savePageSource(WebDriver driver) {
        if (driver == null) return "";
        return driver.getPageSource();
    }
}
