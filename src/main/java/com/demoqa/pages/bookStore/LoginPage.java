package com.demoqa.pages.bookStore;

import com.demoqa.config.BasePage;
import com.demoqa.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userField;

    @FindBy(id = "password")
    WebElement passwordField;

    public LoginPage enterUserData(String userName, String password) {
        typeWithJS(userField,userName,0,300);
        type(passwordField,password);
        return this;
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage clickOnLoginButton() {
        click(loginButton);
        return new ProfilePage(driver);
    }

    @FindBy(id = "newUser")
    WebElement newUserButton;

    public RegisterPage clickOnNewUserButton() {
        clickWithJS(newUserButton,0,200);
        return new RegisterPage(driver);
    }

    public boolean verifyLoginButtonIsDisplayed() {
        return isElementDisplayed(loginButton);
    }
}
