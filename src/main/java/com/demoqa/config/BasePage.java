package com.demoqa.config;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    public static JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJS(WebElement element, int x, int y) {
        moveWithJS(x, y);
        click(element);
    }

    public void moveWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void typeWithJS(WebElement element, String text, int x, int y) {
        moveWithJS(x, y);
        type(element, text);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return wait(time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void hideAd() {
        js.executeScript("document.getElementById('fixedban').style.display='none';");
    }

    public void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void hideIframes() {
        hideAd();
        hideFooter();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }

    public void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);

            //create URL connection and get response code
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(url + " - " + connection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(url + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + " Error occurred");
        }
    }

    public int getBrokenCount(String attribute, List<WebElement> elements, int brokenCount) {

        for (WebElement el : elements) {
            String url = el.getAttribute(attribute);
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setConnectTimeout(5000);
                connection.connect();
                int statusCode = connection.getResponseCode();
                if (statusCode >= 400) {
                    brokenCount++;
                    System.out.println(url + " - " + connection.getResponseMessage() + " is a broken link");
                } else {
                    System.out.println(url + " - " + connection.getResponseMessage());
                }
            } catch (Exception e) {
                brokenCount++;
                System.out.println(url + " - " + e.getMessage() + " Error occurred");
            }
        }
        return brokenCount;
    }

    public void clickWithRectangle(WebElement element, int x, int y) {

        Rectangle rectangle = element.getRect();

        int offsetX = rectangle.getWidth() / x;
        int offsetY = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offsetX, -offsetY).click().perform();
    }

    public void switchToNextWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public String getRandomEmail() {
        return "n" + System.currentTimeMillis()/1000%3600 + "@gm.com";
    }

    public boolean containsText(WebElement element, String text) {
        return element.getText().contains(text);
    }

    public boolean isAlertPresent(int time) {
        Alert alert = wait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }
        driver.switchTo().alert().accept();
        return true;
    }

    public WebDriverWait wait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public boolean isTextInAlertDisplayed(int time, String text) {
        Alert alert = wait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }
        alert.getText().contains(text);
        driver.switchTo().alert().accept();
        return true;
    }

    public String getDomAttribute(WebElement element,String attribute) {
        return element.getDomAttribute(attribute);
    }
}
