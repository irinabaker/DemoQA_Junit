package com.demoqa.pages.bookStore;

import com.demoqa.config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;


    public BasePage enterBookName(String text) {
        type(searchBox,text);
        return this;
    }

    @FindBy(css = ".mr-2 a")
    WebElement nameOfBook;

    public boolean verifyBookName(String text) {
        return shouldHaveText(nameOfBook,text,10);
    }
}
