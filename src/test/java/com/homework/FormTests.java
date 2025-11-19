package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTests extends BaseTest {

    @Test
    public void testSubmitForm() throws InterruptedException {


        driver.get("https://demoqa.com/automation-practice-form");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('iframe').forEach(el => el.style.display='none');");

        // First name
        driver.findElement(By.id("firstName")).sendKeys("Nika");

        // Last name
        driver.findElement(By.id("lastName")).sendKeys("Eliashvili");

        // Email
        driver.findElement(By.id("userEmail")).sendKeys("nika@test.com");

        // Gender
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();

        // Mobile
        driver.findElement(By.id("userNumber")).sendKeys("5991234567");

        // Date of Birth — click and press Enter
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.ENTER);


        // Subjects
        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);

        // Hobbies
        driver.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();

        // Address
        driver.findElement(By.id("currentAddress")).sendKeys("Tbilisi, Georgia");

        // State
        driver.findElement(By.id("state")).click();  // open dropdown
        driver.findElement(By.id("react-select-3-input")).sendKeys("NCR");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);

        //City
        driver.findElement(By.id("city")).click();  // open dropdown
        driver.findElement(By.id("react-select-4-input")).sendKeys("Delhi");
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        // Scroll to Submit Button
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        // Assertions

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement modalTable = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("table-responsive"))
        );
        String tableText;
        tableText = modalTable.getText();
        Thread.sleep(2000);
        Assert.assertTrue(tableText.contains("Nika"));
        Assert.assertTrue(tableText.contains("Eliashvili"));
        Assert.assertTrue(tableText.contains("nika@test.com"));
        Assert.assertTrue(tableText.contains("Male"));
        Assert.assertTrue(tableText.contains("599123456"));
        Assert.assertTrue(tableText.contains("Maths"));
        Assert.assertTrue(tableText.contains("Sports"));
        Assert.assertTrue(tableText.contains("Tbilisi, Georgia"));
        Assert.assertTrue(tableText.contains("NCR Delhi"));
        Thread.sleep(2000);
    }
}
