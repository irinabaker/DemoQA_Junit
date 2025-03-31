package com.demoqa.tests.bookStore;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.pages.bookStore.RegisterPage;
import com.demoqa.pages.SideBar;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterTests extends TestBase {

    HomePage home;
    SideBar sideBar;
    LoginPage login;
    RegisterPage register;

    @BeforeEach
    public void preconditions() {
        home.getBookStore();
        sideBar.selectLogin();
    }

    @Test
    public void createAccountPositiveTest() {
//        login.clickOnNewUserButton();
//        register
//                //.clickOnCaptcha()
//                .enterPersonalData(UserData.FIRST_NAME, UserData.LAST_NAME,
//                        register.getRandomEmail(), UserData.PASSWORD)
//              .clickOnCaptcha()
//                .clickOnRegisterButton()
//                .verifySuccessRegistration("User Register Successfully.");
    }
}
