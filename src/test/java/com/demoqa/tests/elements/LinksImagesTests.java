package com.demoqa.tests.elements;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SideBar;
import com.demoqa.pages.elements.LinksImagesPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinksImagesTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getElements();
    }

    @Test
    public void checkAllLinksTest() {
        new SideBar(driver).selectLinks().hideIframes();
        new LinksImagesPage(driver).checkAllLinks();
    }

    @Test
    public void checkBrokenLinks() {
        new SideBar(driver).selectBrokenLinksImages().hideIframes();
        new LinksImagesPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
       new SideBar(driver).selectBrokenLinksImages();
       new LinksImagesPage(driver).checkBrokenImages();
    }
}
