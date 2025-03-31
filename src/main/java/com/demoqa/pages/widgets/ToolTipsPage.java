package com.demoqa.pages.widgets;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends BasePage {

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    public ToolTipsPage hoverToolTips() {
        pause(1000);
        moveWithJS(0,200);

        new Actions(driver).moveToElement(toolTipButton).perform();
        pause(1000);
        return this;
    }

    public ToolTipsPage verifyToolTips(String value) {
        Assertions.assertEquals(getDomAttribute(toolTipButton,"aria-describedby"),value);
        return this;
    }
}
