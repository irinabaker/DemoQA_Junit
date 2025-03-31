package com.demoqa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);
        logger.info("Open url - {}", url);
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        WebDriverListener.super.afterGetTitle(driver, result);
        logger.info("Page title - {}", result);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.error("Something went wrong!!!");
        logger.error("================================");
        logger.error("Method ", method);
        logger.error("================================");
        logger.error("Target ", target);
        logger.error("================================");
        logger.error("Exception ", e.getMessage());
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        logger.info("We have to click element with locator - {}", element);
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.afterSendKeys(element, keysToSend);
        logger.info("We fill in {} wit value - {}", element, keysToSend);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logger.info("We find elements {}", result.toString());
    }

    @Override
    public void beforeAlert(WebDriver.TargetLocator targetLocator) {
        WebDriverListener.super.beforeAlert(targetLocator);
        logger.info("We have alert with text - '{}'", targetLocator.alert().getText());
    }
}
