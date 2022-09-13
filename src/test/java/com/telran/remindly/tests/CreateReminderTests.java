package com.telran.remindly.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase{

    @Test
    public void addReminderWithDefaultDataTest(){
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
        app.getRemindersHelper().tapOnAddReminder();
        app.getRemindersHelper().fillReminderTitle("Test");
        app.getRemindersHelper().saveReminder();
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void addReminderWithDefaultDataAndTitleTextAssertTest(){
        app.getRemindersHelper().tapOnAddReminder();
        app.getRemindersHelper().fillReminderTitle("Test");
        app.getRemindersHelper().saveReminder();
        Assert.assertEquals("Text", app.getRemindersHelper().isElementPresent(By.id("recycle_title").));
    }

    @Test
    public void addReminderWithRandomSwipeTest(){
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
        app.getRemindersHelper().tapOnAddReminder();
        app.getRemindersHelper().fillReminderTitle("Test");
        app.getRemindersHelper().tapOnDateField();
        app.getRemindersHelper().selectMonth("future");
        app.getRemindersHelper().selectDay(19);
        app.getRemindersHelper().tapOnOk();
        app.getRemindersHelper().saveReminder();
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }
}
