package com.telran.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends HelperBase{

        public MainScreenHelper(AppiumDriver driver) {
            super(driver);
        }

        public boolean isNoReminderTextPresent(){
            return isElementPresent(By.id("no_reminder_text")); //By.xpath("*[@resource-id='com.blanyal.remindly:id/no_reminder_text']")
        }

    public int getTotalReminders(){
        return driver.findElements(By.id("recycle_title")).size();
    }
}
