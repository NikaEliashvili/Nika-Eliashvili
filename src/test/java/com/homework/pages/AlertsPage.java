package com.homework.pages;

import com.homework.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    private final By tabAlertWithTextbox = By.xpath("//a[contains(text(),'Alert with Textbox')]");
    private final By demonstrateBtn = By.xpath("//button[contains(text(),'demonstrate')]");
    private final By resultText = By.id("demo1");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Alerts page")
    public AlertsPage open() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
        return this;
    }

    @Step("Open 'Alert with Textbox' tab")
    public AlertsPage openTextboxTab() {
        click(tabAlertWithTextbox);
        return this;
    }

    @Step("Trigger textbox alert")
    public AlertsPage triggerTextboxAlert() {
        click(demonstrateBtn);
        return this;
    }

    @Step("Fill alert textbox with: {fullName} and accept")
    public AlertsPage fillAlertAndAccept(String fullName) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(fullName);
        alert.accept();
        return this;
    }

    @Step("Get result text under alert")
    public String getResultText() {
        return getText(resultText);
    }
}
