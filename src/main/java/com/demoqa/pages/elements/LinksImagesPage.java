package com.demoqa.pages.elements;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksImagesPage extends BasePage {

    public LinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public LinksImagesPage checkAllLinks() {
        String url = "";
        System.out.println("Total links on the page: " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
            System.out.println("*******************************************");
        }
        return this;
    }

    public LinksImagesPage checkBrokenLinks() {
        int errorCount = getBrokenCount("href",allLinks, 0);
        Assertions.assertEquals(0, errorCount, "Incorrect links found: " + errorCount);
        return this;
    }

    @FindBy(css = "img")
    List<WebElement> images;


    public LinksImagesPage checkBrokenImages() {
        System.out.println(images.size() + " - " + "images");
        int brokenImageCount = 0;
        for (int i = 0; i < images.size(); i++) {
            WebElement element = images.get(i);
       //     String imageUrl = element.getAttribute("src");
          //  verifyLinks(imageUrl);
            getBrokenCount("src",images,brokenImageCount);

         //   for (WebElement el: images) {
            try {

                boolean imageDisplayed =
                        (Boolean) js.executeScript("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", element);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                } else {
                    brokenImageCount ++;
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("************************************************************");
                }
            } catch (Exception e) {
                System.out.println("Error occurred");
            }
     //  }

    }

        Assertions.assertEquals(0, brokenImageCount, "Broken images found: " + brokenImageCount);

//        for (int i = 0; i < images.size(); i++) {
//            WebElement element = images.get(i);
//            String imageURL = element.getAttribute("src");
//            verifyLinks(imageURL);

//        }
        return this;
    }
}
