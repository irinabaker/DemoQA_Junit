package com.demoqa.pages.bookStore;

import com.demoqa.config.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(id = "firstname")
//    WebElement firstnameField;
//    @FindBy(id = "lastname")
//    WebElement lastnameField;
//    @FindBy(id = "userName")
//    WebElement userNameField;
//    @FindBy(id = "password")
//    WebElement passwordField;
//
//    public RegisterPage enterPersonalData(String firstName, String lastName,
//                                          String userName, String password) {
//        typeWithJS(firstnameField,firstName,0,400);
//        type(lastnameField,lastName);
//        type(userNameField,userName);
//        typeWithJS(passwordField,password,0,200);
//        return this;
//    }
//
//    @FindBy(css = "[title='reCAPTCHA']")
//    WebElement recaptcha;
//
//    @FindBy(id = "recaptcha-anchor")
//    WebElement recaptchaCheckbox;
//
//    @FindBy(xpath = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
//    public WebElement captchaFrame;
//
//    public RegisterPage clickOnCaptcha() {
//       // pause(500);
//       moveWithJS(0,600);
//      //  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(captchaFrame));
//        click(recaptchaCheckbox);
//     //   pause(500);
//        driver.switchTo().defaultContent();
//    //    pause(500);
//        return this;
//    }
//
//    @FindBy(id = "register")
//    WebElement registerButton;
//
//
//    public RegisterPage clickOnRegisterButton() {
//        clickWithJS(registerButton,0,800);
//        return this;
//    }
//
//    public RegisterPage verifySuccessRegistration(String text) {
//      //  String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
//      //  Assertions.assertEquals(text,alertText);
//        return this;
//    }
}
