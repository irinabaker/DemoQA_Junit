package com.demoqa.tests.elements;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.elements.UploadFilePage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RobotTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getElements();
        new SideBar(driver).selectUploadFile().hideIframes();
    }

    @Test
    public void performKeyEventWithRobotTest() {
        new UploadFilePage(driver).performKeyEventWithRobot()
                .verifyPath("C:\\fakepath\\D1.txt");
    }

    @Test
    public void performMouseEventWithRobotTest() {
        new UploadFilePage(driver).performMouseEvent()
                .verifyPath("C:\\fakepath\\D1.txt");
    }
}