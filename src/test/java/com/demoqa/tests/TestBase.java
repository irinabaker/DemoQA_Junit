package com.demoqa.tests;

import com.demoqa.config.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));

   public static Logger logger = LoggerFactory.getLogger(TestBase.class);
   public WebDriver driver;

    @BeforeEach
    public void init(TestInfo testInfo) {
        driver = app.startTest();
        logger.info("Start test " + testInfo.getDisplayName());
    }


    @AfterEach
    public void tearDown(TestInfo testInfo) {
       app.stopTest();
       logger.info("Stop test");
       logger.info("*************************************");
    }
}
