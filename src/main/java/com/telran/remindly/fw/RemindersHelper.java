package com.telran.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RemindersHelper extends HelperBase {
    public RemindersHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnAddReminder() {
        tap(By.id("add_reminder"));
    }

    public void fillReminderTitle(String title) {
        type(By.id("reminder_title"), title);
        hideKeyboard();
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDateField() {
        tap(By.id("date_text"));
    }

    public void selectMonth(String time) {
        if (time.equals("past")) {
            swipeDown();
        } else if (time.equals("future")) {
            swipeUp();
        }
    }

    public void selectDay(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnOk(){
        tap(By.id("ok"));
    }

    public void selectCertainMonth(String type, int number, String month){
        if (!selectedMonth().equals(month)){
            for (int i = 0; i < number; i++){
                if(type.equals("future")){
                    swipeUp();
                } else if (type.equals("past")){
                    swipeDown();
                }
            }
        }
    }

    private String selectedMonth(){
        return driver.findElement(By.id("date_picker_month")).getText();
    }

    public void tapOnYear(){
        tap(By.id("date_picker_year"));
    }

    public void selectYear(String type1, String year){
        pause(2000);
        if(!getSelectedYear().equals(year)){
            if(type1.equals("future")){
                swipeUpUntilNeededYear(year);
            } else if (type1.equals("past")){
                swipeDownUntilNeededYear(year);
            }
        }
        tap(By.id("month_text_view"));

    }

    private String getSelectedYear(){
        return driver.findElement(By.id("date_picker_year")).getText();
    }

    private void swipeUpUntilNeededYear(String year){
        while (!getSelectedYear().equals(year)){
            moveUp(By.className("android.widget.ListView"));
        }
    }

    private void swipeDownUntilNeededYear(String year){
        while (!getSelectedYear().equals(year)){
            moveDown(By.className("android.widget.ListView"));
        }
    }
}
