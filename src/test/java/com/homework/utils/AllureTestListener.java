package com.homework.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        try {
            WebDriver driver = (WebDriver) instance.getClass()
                    .getSuperclass()
                    .getDeclaredField("driver")
                    .get(instance);
            saveScreenshot(driver);
        } catch (Exception ignored) {}
    }

    @Attachment(value = "Listener Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        if (driver == null) return new byte[0];
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
