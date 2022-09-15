package com.telran.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase{

    @Test
    public void launchAppTest(){
        Assert.assertTrue(app.getMainScreenHelper().isNoReminderTextPresent());
    }

    @Test
    public void isLicensesPresent(){
        app.getMainScreenHelper().tapMoreAction();
        app.getMainScreenHelper().tapTitle();
        Assert.assertTrue(app.getMainScreenHelper().isLicensesExist());
    }
}
