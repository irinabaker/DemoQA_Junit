package com.demoqa.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demoqa.pages.*;
import com.demoqa.utils.MyListener;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    public String browser;
    public WebDriver driver;

    private static ExtentReports extent;
    private static ExtentTest test;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver startTest(TestInfo testInfo) {

        //  ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new"); // without opening a browser window
       // driver = new ChromeDriver();
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "safari" -> driver = new SafariDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        test = extent.createTest(testInfo.getDisplayName());

        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //  options.addArguments("--window-size=1920,1080");
        return driver;
    }

    public void stopTest() {

        driver.quit();
        extent.flush();
    }
}
