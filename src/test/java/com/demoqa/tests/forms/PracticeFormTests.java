package com.demoqa.tests.forms;

import com.demoqa.data.User;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.tests.TestBase;
import com.demoqa.utils.MyArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PracticeFormTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getForms();
        new SideBar(driver).selectPracticeForm().hideIframes();
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void createStudentAccount(String name, String surName, String email, String phone) {
        new PracticeFormPage(driver)
                // .enterPersonalData("Robert", "Weide", "weide@gm.com", "1234567890")
                .enterPersonalData(User.builder()
                        .name(name)
                        .surName(surName)
                        .email(email)
                        .phone(phone).build())
                .selectGender("Male")
                .enterDate("16 Aug 1987")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("C:/Tools/1.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form");
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void createStudentAccountWithSelectDate(String name, String surName, String email, String phone) {
        new PracticeFormPage(driver)
                .enterPersonalData(User.builder().name(name).surName(surName).email(email).phone(phone).build())
                .selectGender("Male")
                .selectDate("August", "1987", "16")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("C:/Tools/1.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
}
