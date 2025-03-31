package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    public WindowsPage switchToNewTab(int index) {
        click(tabButton);

        switchToNextWindow(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public WindowsPage verifyNewTabTitle(String text) {
        Assertions.assertTrue(shouldHaveText(sampleHeading,text,5));
        return this;
    }
}
