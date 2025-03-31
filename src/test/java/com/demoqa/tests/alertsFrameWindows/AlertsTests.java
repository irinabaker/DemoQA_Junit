package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SideBar(driver).selectAlerts().hideIframes();
    }

    @Test
    public void alertWaitTest() {
        new AlertsPage(driver).verifyAlertWithTimer();
    }

    @Test
    @DisplayName("Verify to - 'Result 'You selected Cancel' is displayed")
    public void alertWithSelectTest() {
        new AlertsPage(driver).selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    @DisplayName("Verify to - 'Result 'You entered Hello World!' is displayed")
    public void sendMessageToAlertTest() {
        new AlertsPage(driver).sendMessageToAlert("Hello World!").verifyMessage("Hello World!");
    }

    @Test
    @DisplayName("Verify to - 'Result 'You entered Hello World!' is displayed")
    public void sendMessageToAlertTest1() {
        new AlertsPage(driver).sendMessageToAlert("Hello World!").verifyMessage1("Hello World!");
    }
}
