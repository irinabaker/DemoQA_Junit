package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.elements.TextBoxPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JSExecutorTests extends TestBase{

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getElements();
        new SideBar(driver).selectTextBox().hideIframes();
    }

    @Test
    public void jsExecutorTest() {
        new TextBoxPage(driver).enterDataWithJS("Jamal Musiala", "jamal@gm.com")
                .clickOnSubmitWithJS()
                .refreshWithJS()
                .getInnerTextWithJS()
                .verifyUrlWithJS()
                .navigateToNewPageWithJS()
                .verifyTitleOfPageWithJS()
                .generateAlertWithJS();
    }
}
