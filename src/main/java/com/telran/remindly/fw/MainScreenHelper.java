package com.telran.remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class MainScreenHelper extends HelperBase {

    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isNoReminderTextPresent() {
        return isElementPresent(By.id("no_reminder_text")); //By.xpath("*[@resource-id='com.blanyal.remindly:id/no_reminder_text']")
    }

    public int getTotalReminders() {
        return driver.findElements(By.id("recycle_title")).size();
    }

    public void tapMoreAction() {
        tap(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"));
    }

    public void tapTitle() {
        tap(By.id("title"));
    }

    public boolean isLicensesExist() {
        return isElementPresent(By.id("licenses_text_view"));
    }

    public void removeReminder() {
        TouchAction action = new TouchAction<>(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int y = size.height / 5;
        action.longPress(PointOption.point(x, y))
                .release()
                .perform();
        tap(By.id("discard_reminder"));
    }
}
