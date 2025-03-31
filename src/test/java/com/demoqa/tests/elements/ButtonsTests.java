package com.demoqa.tests.elements;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonsTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getElements();
        new SideBar(driver).selectButtons().hideIframes();
    }

    @Test
    public void doubleClickTest() {
        new ButtonsPage(driver).doubleClick();
    }

    @Test
    public void rightClickTest() {
        new ButtonsPage(driver).rightClick();
    }
}
