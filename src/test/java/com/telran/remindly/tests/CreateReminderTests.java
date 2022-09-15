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
        app.getRemindersHelper().fillReminderTitle("Test");
        app.getRemindersHelper().tapOnDateField();
        app.getRemindersHelper().selectDay(19);
        app.getRemindersHelper().tapOnOk();
        app.getRemindersHelper().saveReminder();
    }
}
