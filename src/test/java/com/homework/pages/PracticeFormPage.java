package com.homework.pages;

import com.homework.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends BasePage {

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By userEmail = By.id("userEmail");
    private final By maleGender = By.xpath("//label[contains(text(),'Male')]");
    private final By userNumber = By.id("userNumber");
    private final By dateOfBirthInput = By.id("dateOfBirthInput");

    private final By subjectsInput = By.id("subjectsInput");
    private final By sportsHobby = By.xpath("//label[contains(text(),'Sports')]");

    private final By currentAddress = By.id("currentAddress");

    private final By stateDropdown = By.id("state");
    private final By stateInput = By.id("react-select-3-input");

    private final By cityDropdown = By.id("city");
    private final By cityInput = By.id("react-select-4-input");

    private final By submitBtn = By.id("submit");
    private final By modalTable = By.className("table-responsive");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open practice form page")
    public PracticeFormPage open() {
        driver.get("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Hide iframes (ads) via JS")
    public PracticeFormPage hideIframes() {
        js("document.querySelectorAll('iframe').forEach(el => el.style.display='none');");
        return this;
    }

    @Step("Fill first name: {value}")
    public PracticeFormPage setFirstName(String value) {
        type(firstName, value);
        return this;
    }

    @Step("Fill last name: {value}")
    public PracticeFormPage setLastName(String value) {
        type(lastName, value);
        return this;
    }

    @Step("Fill email: {value}")
    public PracticeFormPage setEmail(String value) {
        type(userEmail, value);
        return this;
    }

    @Step("Select Male gender")
    public PracticeFormPage selectMale() {
        click(maleGender);
        return this;
    }

    @Step("Fill mobile number: {value}")
    public PracticeFormPage setMobile(String value) {
        type(userNumber, value);
        return this;
    }

    @Step("Set date of birth by pressing Enter")
    public PracticeFormPage setDobByEnter() {
        click(dateOfBirthInput);
        driver.findElement(dateOfBirthInput).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Set subject: {subject}")
    public PracticeFormPage addSubject(String subject) {
        driver.findElement(subjectsInput).sendKeys(subject);
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Select Sports hobby")
    public PracticeFormPage selectSports() {
        click(sportsHobby);
        return this;
    }

    @Step("Set current address: {value}")
    public PracticeFormPage setAddress(String value) {
        type(currentAddress, value);
        return this;
    }

    @Step("Select state: {state}")
    public PracticeFormPage selectState(String state) {
        click(stateDropdown);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(stateInput).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Select city: {city}")
    public PracticeFormPage selectCity(String city) {
        click(cityDropdown);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(cityInput).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Submit form")
    public PracticeFormPage submit() {
        scrollIntoView(submitBtn);
        click(submitBtn);
        return this;
    }

    @Step("Read modal table text")
    public String getModalTableText() {
        return getText(modalTable);
    }
}
