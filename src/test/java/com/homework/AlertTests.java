package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test
    public void testAlertWithTextbox() {

        driver.get("https://demo.automationtesting.in/Alerts.html");

        // Go to "Alert with Textbox"
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();

        // Trigger alert
        driver.findElement(By.xpath("//button[contains(text(),'demonstrate')]")).click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        String fullName = "Nika Eliashvili";

        // Send text
        alert.sendKeys(fullName);

        // Accept
        alert.accept();

        // Assert result text
        String resultText = driver.findElement(By.id("demo1")).getText();

        Assert.assertTrue(resultText.contains(fullName));
    }
}
