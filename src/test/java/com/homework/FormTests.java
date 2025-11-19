package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTests extends BaseTest {

    @Test
    public void testSubmitForm() {

        driver.get("https://demoqa.com/automation-practice-form");

        // First name
        driver.findElement(By.id("firstName")).sendKeys("Nika");

        // Last name
        driver.findElement(By.id("lastName")).sendKeys("Eliashvili");

        // Email
        driver.findElement(By.id("userEmail")).sendKeys("nika@test.com");

        // Gender
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();

        // Mobile
        driver.findElement(By.id("userNumber")).sendKeys("599123456");

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

        // Scroll to Submit Button
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.sendKeys(Keys.PAGE_DOWN);
        submitBtn.click();

        // Assertions
        WebElement table = driver.findElement(By.className("table-responsive"));
        String tableText = table.getText();

        Assert.assertTrue(tableText.contains("Nika"));
        Assert.assertTrue(tableText.contains("Eliashvili"));
        Assert.assertTrue(tableText.contains("nika@test.com"));
        Assert.assertTrue(tableText.contains("Male"));
        Assert.assertTrue(tableText.contains("599123456"));
        Assert.assertTrue(tableText.contains("Maths"));

    }
}
