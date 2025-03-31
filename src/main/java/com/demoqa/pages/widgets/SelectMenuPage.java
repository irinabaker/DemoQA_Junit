package com.demoqa.pages.widgets;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
        new Select(oldSelectMenu).selectByVisibleText(color);
        return this;
    }

    public SelectMenuPage verifyColor() {
        String firstSelectedOption = new Select(oldSelectMenu).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(oldSelectMenu, firstSelectedOption, 5));
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    @FindBy(css = "html")
    WebElement space;

    public SelectMenuPage multiSelect(String[] colors) {
//        for (int i = 0; i < colors.length; i++) {
//            if (colors[i] != null) {
//                inputSelect.sendKeys(colors[i]);
//                inputSelect.sendKeys(Keys.ENTER);
//            }
        //       }// the same code

        for (String text : colors) {
            inputSelect.sendKeys(text);
            inputSelect.sendKeys(Keys.ENTER);
        }
        click(space);
        return this;
    }

    public SelectMenuPage verifyMultiSelect(String[] colors) {
        for (String text : colors) {
            WebElement element = driver.findElement(By.xpath("//*[.='" + text + "']"));
            System.out.println(element.getText());
            Assertions.assertTrue(element.getText().contains(text));
        }
        return this;
    }

    public SelectMenuPage verifySelectedCar(String car, String color) {
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);
        System.out.println(selectedCar.getCssValue("background-color"));
        String rgbFormat = selectedCar.getCssValue("background-color");
        String hexColor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        System.out.println(hexColor);// Output of Hex code will be  => #febd69
        Assertions
                //  .assertTrue(selectedCar.getCssValue("background-color").contains(color));
                .assertTrue(hexColor.contains(color));
        return this;
    }

    @FindBy(id = "cars")
    WebElement selectCars;

    public SelectMenuPage standardMultiSelect(String[] cars) {
        Select multi = new Select(selectCars);
        for (int i = 0; i < cars.length; i++) {
            if (multi.isMultiple()) {
                multi.selectByVisibleText(cars[i]);
            }
        }
            return this;
        }

}