package com.homework.tests;

import com.homework.base.BaseTest;
import com.homework.pages.AlertsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Homework 3")
@Feature("Alerts")
public class AlertTests extends BaseTest {

    @Test(description = "Verify alert textbox accepts input and result text contains it")
    @Story("Alert with Textbox")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Opens alerts page, triggers textbox alert, enters full name, accepts, verifies output.")
    public void testAlertWithTextbox() {

        String fullName = "Nika Eliashvili";

        AlertsPage alerts = new AlertsPage(driver)
                .open()
                .openTextboxTab()
                .triggerTextboxAlert()
                .fillAlertAndAccept(fullName);

        Assert.assertTrue(alerts.getResultText().contains(fullName));
    }
}
