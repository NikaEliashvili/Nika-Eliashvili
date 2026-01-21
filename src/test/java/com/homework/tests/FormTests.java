package com.homework.tests;

import com.homework.base.BaseTest;
import com.homework.pages.PracticeFormPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Homework 3")
@Feature("Practice Form")
public class FormTests extends BaseTest {

    @Test(description = "Submit practice form and verify submitted values in modal")
    @Story("Submit form")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Fills practice form, submits and validates the modal table contains the data.")
    public void testSubmitForm() {

        PracticeFormPage form = new PracticeFormPage(driver)
                .open()
                .hideIframes()
                .setFirstName("Nika")
                .setLastName("Eliashvili")
                .setEmail("nika@test.com")
                .selectMale()
                .setMobile("5991234567")
                .setDobByEnter()
                .addSubject("Maths")
                .selectSports()
                .setAddress("Tbilisi, Georgia")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();

        String tableText = form.getModalTableText();

        Assert.assertTrue(tableText.contains("Nika"));
        Assert.assertTrue(tableText.contains("Eliashvili"));
        Assert.assertTrue(tableText.contains("nika@test.com"));
        Assert.assertTrue(tableText.contains("Male"));
        Assert.assertTrue(tableText.contains("5991234567"));
        Assert.assertTrue(tableText.contains("Maths"));
        Assert.assertTrue(tableText.contains("Sports"));
        Assert.assertTrue(tableText.contains("Tbilisi, Georgia"));
        Assert.assertTrue(tableText.contains("NCR Delhi"));
    }
}
