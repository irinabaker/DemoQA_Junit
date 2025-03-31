package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.widgets.ToolTipsPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToolTipsTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SideBar(driver).selectToolTips().hideIframes();
    }

    @Test
    public void toolTipsTest() {
        new ToolTipsPage(driver).hoverToolTips()
                .verifyToolTips("buttonToolTip");
    }
}
