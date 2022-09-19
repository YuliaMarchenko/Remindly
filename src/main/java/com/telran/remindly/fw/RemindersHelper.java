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
        pause(1000);
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
        return driver.findElement(By.id("month_text_view")).getText();
    }

    private void swipeUpUntilNeededYear(String year){
        while (!getSelectedYear().equals(year)){
            moveUp(By.className("android.widget.ListView"));
            getSelectedYear();
        }
    }

    private void swipeDownUntilNeededYear(String year){
        while (!getSelectedYear().equals(year)){
            moveDown(By.className("android.widget.ListView"));
            getSelectedYear();
        }
    }

    public void tapOnTime(){
        tap(By.id("time"));
    }

    public void selectTimeOfDay(String td){
        if(td.equals("am")){
            tapWithCoordinates(260, 1300);
        } else if (td.equals("pm")){
            tapWithCoordinates(790, 1300);
        }
    }

    public void tapOnRepeatSwitch(){
        tap(By.id("repeat_switch"));
    }

    public void enterRepeatNumber(String text){
        tap(By.id("repeat_no_text"));
        type(By.className("android.widget.EditText"), text);
        tap(By.id("android:id/button1"));
    }

    public void enterRepeatTime(String repeat) {
        tap(By.id("repeat_type_text"));
        tap(By.xpath("//android.widget.TextView[@text='"+repeat+"']"));
    }
}
