package com.demoqa.pages;

import com.demoqa.config.BasePage;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card:nth-child(6)")
    WebElement bookStore;

    public SideBar getBookStore() {
        clickWithJS(bookStore,0,800);
        return new SideBar(driver);
    }

    @FindBy(css = ".card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SideBar getAlertsFrameWindows() {
        clickWithJS(alertsFrameWindows,0,300);
        return new SideBar(driver);
    }

    @FindBy(css = ".card:nth-child(4)")
    WebElement widgets;

    public SideBar getWidgets() {
        clickWithJS(widgets,0,300);
        return new SideBar(driver);
    }

    @FindBy(css = ".card:nth-child(5)")
    WebElement interactions;

    public SideBar getInteractions() {
        clickWithJS(interactions,0,300);
        return new SideBar(driver);
    }

    @FindBy(css = ".card:nth-child(1)")
    WebElement elements;

    public SideBar getElements() {
        clickWithJS(elements,0,300);
        return new SideBar(driver);
    }

    @FindBy(css = ".card:nth-child(2)")
    WebElement forms;

    public SideBar getForms() {
        clickWithJS(forms,0,300);
        return new SideBar(driver);
    }
}
