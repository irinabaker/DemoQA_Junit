package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SliderTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SideBar(driver).selectSlider().hideIframes();
    }

    @Test
    public void sliderTest() {
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .verifySliderValue("100");
    }
}
