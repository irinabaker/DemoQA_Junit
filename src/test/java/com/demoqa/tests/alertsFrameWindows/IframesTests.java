package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.alertsFrameWindows.IframesPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IframesTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
    }

    @Test
    @DisplayName("Check to - 'Title 'This is a sample page' is displayed")
    public void iframeTest() {
        new SideBar(driver).selectFrame();
        new  IframesPage(driver).returnListOfFrames()
                .switchToIframeByIndex(1)
                .verifyIframeByText("This is a sample page");
    }

    @Test
    @DisplayName("Check to - 'Title 'Frames' is displayed")
    public void iframeTest2() {
        new SideBar(driver).selectFrame();
        new IframesPage(driver).switchToIframeByID()
                .verifyIframeByText("sample page")
                .switchToMainPage()
                .verifyMainPageByTitle("Frames");
    }

    @Test
    public void nestedIframesTest() {
        new SideBar(driver).selectNestedFrames();
        new  IframesPage(driver).handleNestedIframes();
    }
}
