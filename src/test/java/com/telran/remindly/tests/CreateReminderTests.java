package com.telran.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase{

    @Test
    public void addReminderWithDefaultDataTest(){
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreenHelper().getTotalReminders();
        app.getRemindersHelper().tapOnAddReminder();
        app.getRemindersHelper().fillReminderTitle("Test");
        app.getRemindersHelper().saveReminder();
        quantityAfterAdd = app.getMainScreenHelper().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void addReminderWithRandomSwipeTest(){
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreenHelper().getTotalReminders();
        app.getRemindersHelper().tapOnAddReminder();
        app.getRemindersHelper().fillReminderTitle("Test");
        app.getRemindersHelper().tapOnDateField();
        app.getRemindersHelper().selectMonth("future");
        app.getRemindersHelper().selectDay(19);
        app.getRemindersHelper().tapOnOk();
        app.getRemindersHelper().saveReminder();
        quantityAfterAdd = app.getMainScreenHelper().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void addReminderWithAllDataTest(){
        app.getRemindersHelper().tapOnAddReminder();
        app.getRemindersHelper().fillReminderTitle("Christmas");
        app.getRemindersHelper().tapOnDateField();
        app.getRemindersHelper().selectCertainMonth("future", 4, "Dec");
        app.getRemindersHelper().selectDay(23);
        app.getRemindersHelper().tapOnYear();
        app.getRemindersHelper().selectYear("future", "2023");
        app.getRemindersHelper().tapOnOk();
//        app.getRemindersHelper().tapOnTime();
//        app.getRemindersHelper().selectTimeOfDay();
//        app.getRemindersHelper().selectHours();
//        app.getRemindersHelper().selectMinutes();
//        app.getRemindersHelper().tapOnOk();
//        app.getRemindersHelper().tapOnRepeatSwitch();
//        app.getRemindersHelper().enterRepeatNumber("3");
//        app.getRemindersHelper().swipeUp();
//        app.getRemindersHelper().enterRepeatTime("Month");
//        app.getRemindersHelper().saveReminder();
    }
}
