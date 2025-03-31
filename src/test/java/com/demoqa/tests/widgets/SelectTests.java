package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SideBar(driver).getSelectMenu().hideIframes();
    }

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(driver).selectOldStyle("Blue")
                .verifyColor();
    }

    @Test
    public void multiSelectTest() {
        new SelectMenuPage(driver)
                .multiSelect(new String[]{"Red","Green"})
               .verifyMultiSelect(new String[]{"Red","Green"});
    }

    @Test
    public void standardMultiSelectTest1() {
        new SelectMenuPage(driver)
                .verifySelectedCar("volvo","#1967d2");
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(driver).standardMultiSelect(new String[]{"Volvo","Opel"});
    }
}
