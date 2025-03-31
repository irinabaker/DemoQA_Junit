package com.demoqa.tests.interactions;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.interactions.DroppablePage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragDropTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SideBar(driver).selectDroppable().hideIframes();
    }

    @Test
    public void actionDragMeTest() {
        new DroppablePage(driver).actionDragMe()
                .verifyDropped("Dropped!");
    }

    @Test
    public void dragAndDropByTest() {
        new DroppablePage(driver).dragAndDropBy(20,20)
                .verifyDropped("Dropped!");
    }
}
