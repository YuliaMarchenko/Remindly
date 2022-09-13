package com.telran.remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class HelperBase {

    AppiumDriver driver;


    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void swipeUp() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int yStart = (int) (size.height * 0.8);
        int yFinish = (int) (size.height * 0.5);
        action.longPress(PointOption.point(x, yStart))
                .moveTo(PointOption.point(x, yFinish))
                .release()
                .perform();
    }

    public void swipeDown() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int yStart = (int) (size.height * 0.5);
        int yFinish = (int) (size.height * 0.8);
        action.longPress(PointOption.point(x, yStart))
                .moveTo(PointOption.point(x, yFinish))
                .release()
                .perform();
    }
}
