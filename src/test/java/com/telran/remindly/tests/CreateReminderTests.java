package com.telran.remindly.tests;

import com.telran.remindly.model.Reminder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase {

    @Test
    public void addReminderWithDefaultDataTest() {
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
    public void addReminderWithRandomSwipeTest() {
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
    public void addReminderWithAllDataTest() {
        app.getRemindersHelper().tapOnAddReminder();
        app.getRemindersHelper().fillReminderTitle("Christmas");
        app.getRemindersHelper().tapOnDateField();
        app.getRemindersHelper().selectCertainMonth("future", 4, "Dec");
        app.getRemindersHelper().selectDay(22);
        app.getRemindersHelper().tapOnYear();
        app.getRemindersHelper().selectYear("future", "2023");
        app.getRemindersHelper().tapOnOk();
        app.getRemindersHelper().tapOnTime();
        app.getRemindersHelper().selectTimeOfDay("am");
        app.getRemindersHelper().tapWithCoordinates(269, 924);
        app.getRemindersHelper().tapWithCoordinates(539, 1205);
        app.getRemindersHelper().tapOnOk();
        app.getRemindersHelper().tapOnRepeatSwitch();
        app.getRemindersHelper().enterRepeatNumber("3");
        app.getRemindersHelper().swipeUp2();
        app.getRemindersHelper().enterRepeatTime("Month");
        app.getRemindersHelper().saveReminder();
    }

    @Test
    public void addReminderPositiveWithOneMethodTest(){
        app.getRemindersHelper().enterAllData(new Reminder().setTitle("Christmas").setType("future").setNumber(4)
                .setMonth("Dec").setIndex(22).setType1("future").setYear("2023").setTd("am")
                .setX(269).setY(924).setX(539).setY(1205).setNumberRepeat("3").setTimeRepeat("Month"));
        Assert.assertTrue(app.getRemindersHelper().isTitlePresent().contains("Christmas"));
    }

    @AfterMethod
    public void removeReminder(){
        app.getMainScreenHelper().removeReminder();
    }
}
