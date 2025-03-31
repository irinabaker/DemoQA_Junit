package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IframesPage extends BasePage {

    public IframesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframe;

    public IframesPage returnListOfFrames() {
        //by finding all the web elements using method size()
        System.out.println("The total number of iframes are " + iframe.size());

        //by executing java script
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total number of iframes are " + numberOfIframes);
        return this;
    }

    public IframesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public IframesPage verifyIframeByText(String text) {
        Assertions.assertTrue(shouldHaveText(sampleHeading,text,1));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public IframesPage switchToIframeByID() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public IframesPage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement title;

    public IframesPage verifyMainPageByTitle(String text) {
        Assertions.assertTrue(title.getText().contains(text));
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public IframesPage handleNestedIframes() {
        //switch to parent iframe
        driver.switchTo().frame(frame1);
        //get text from parent iframe
        System.out.println("Iframe is " + body.getText());
        //number os iframes in parent iframe
        System.out.println("Number of iframes inside parent iframe is " + iframe.size());

        //switch to child frame
        driver.switchTo().frame(0);
        //get text from child iframe
        System.out.println("Iframe is " + body.getText());

        //switch to parent iframe
        driver.switchTo().parentFrame();

        //get text from parent iframe
        System.out.println("Iframe is " + body.getText());
        return this;
    }
}
