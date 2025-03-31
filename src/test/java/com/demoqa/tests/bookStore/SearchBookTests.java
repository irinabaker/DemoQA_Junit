package com.demoqa.tests.bookStore;

import com.demoqa.pages.bookStore.BookStorePage;
import com.demoqa.pages.HomePage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchBookTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookPositiveTest() {
        new BookStorePage(driver).enterBookName("Git");
        Assertions.assertTrue(new BookStorePage(driver).verifyBookName("Git"));
    }
}
