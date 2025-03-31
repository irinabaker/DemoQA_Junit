package com.demoqa.tests.elements;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.elements.AutoCompletePage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoCompleteTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SideBar(driver).selectAutoComplete().hideIframes();
    }

    @Test
    public void autoCompleteTest() {
        new AutoCompletePage(driver).autoComplete();
    }
}
