package com.demoqa.pages;

import com.demoqa.config.BasePage;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.IframesPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.pages.elements.*;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.pages.interactions.DroppablePage;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBar extends BasePage {

    public SideBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJS(login, 0, 300);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJS(alerts, 0, 300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public WindowsPage selectBrowserWindows() {
        clickWithJS(browserWindows, 0, 300);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public SideBar selectFrame() {
        clickWithJS(frames, 0, 300);
        return new SideBar(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public IframesPage selectNestedFrames() {
        clickWithJS(nestedFrames, 0, 300);
        return new IframesPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJS(selectMenu, 0, 600);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage getMenu() {
        clickWithJS(menu, 0, 600);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public DroppablePage selectDroppable() {
        clickWithJS(droppable, 0, 600);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJS(slider, 0, 400);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage selectToolTips() {
        clickWithJS(toolTips, 0, 500);
        return new ToolTipsPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJS(buttons, 0, 100);
        return new ButtonsPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;

    public SideBar selectLinks() {
        clickWithJS(links, 0, 200);
        return new SideBar(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement broken;

    public LinksImagesPage selectBrokenLinksImages() {
        clickWithJS(broken, 0, 300);
        return new LinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;

    public AutoCompletePage selectAutoComplete() {
        clickWithJS(autoComplete,0,400);
        return new AutoCompletePage(driver);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement upload;

    public UploadFilePage selectUploadFile() {
        clickWithJS(upload,0,300);
        return new UploadFilePage(driver);
}
}
