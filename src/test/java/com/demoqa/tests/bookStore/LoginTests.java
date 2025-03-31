package com.demoqa.tests.bookStore;

import com.demoqa.data.UserData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.*;

public class LoginTests extends TestBase {

    HomePage home;
    SideBar sideBar;
    LoginPage login;

    @BeforeEach
   public void preconditions() {
        home = new HomePage(driver);
        sideBar = new SideBar(driver);
        login = new LoginPage(driver);
       home.getBookStore();
       sideBar.selectLogin();
    }

    @RepeatedTest(value = 3, failureThreshold = 1,name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Check to - 'User name 'neuer' is displayed")
    @Tag("positive")
    public void loginPositiveTest() {
        login.enterUserData(UserData.USER_NAME,UserData.PASSWORD)
                .clickOnLoginButton();

        Assertions.assertTrue(new ProfilePage(driver).verifyUserName(UserData.USER_NAME));
    }

    @Test
    @Tag("parameters")
    @DisplayName("Check to - 'User name 'neuer' is displayed")
    public void loginPositiveTestWithParameters() {
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        login.enterUserData(username,password)
                .clickOnLoginButton();

        Assertions.assertTrue(new ProfilePage(driver).verifyUserName(UserData.USER_NAME));
    }

    @Test
    @DisplayName("Check to - 'User name 'neuer' is not displayed")
    @Tag("negative")
    public void loginNegativeTest() {
        login.enterUserData("n",UserData.PASSWORD)
                .clickOnLoginButton();

        Assertions.assertTrue(new LoginPage(driver).verifyLoginButtonIsDisplayed());
    }

}
