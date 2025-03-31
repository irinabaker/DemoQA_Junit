package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SideBar(driver).getMenu().hideIframes();
    }

    @Test
    public void moveToMenuTest() {
        new MenuPage(driver).selectSubMenu()
              .verifySubMenu();
    }
}
