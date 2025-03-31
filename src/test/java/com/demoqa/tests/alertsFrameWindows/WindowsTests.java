package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WindowsTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SideBar(driver).selectBrowserWindows().hideIframes();
    }

    @Test
    @DisplayName("Check to - 'Title 'This is a sample page' is displayed")
    public void newTabTest() {
        new WindowsPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }
}
