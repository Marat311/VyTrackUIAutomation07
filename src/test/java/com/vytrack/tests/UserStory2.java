package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.User2;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserStory2 extends TestBase {

    @Test
    public void salesAndStoreCred(){
        LoginPage loginPage=new LoginPage();


        List <String> list=new ArrayList<>();

        list.add("storeManagerUsername1");
        list.add("storeManagerUsername2");
        list.add("salesManagerUsername1");
        list.add("salesManagerUsername2");
        list.add("salesManagerUsername3");

        for (String eachUser : list) {
            loginPage.goTo();
            loginPage.login(eachUser);
            BrowserUtil.waitFor(3);

            User2 user=new User2();
            user.salesClick();

            BrowserUtil.waitFor(3);

            user.fillOut();
            BrowserUtil.waitFor(3);

            String expectedResult = "Entity saved";
            String actualResult=user.savageMsg.getText();

            assertEquals(expectedResult, actualResult);

            VyTrackUtility.logout();
        }

    }
    @Test
    public void testCreateVehicleByDriver(){
        LoginPage loginPage=new LoginPage();

        List <String> list=new ArrayList<>();
        list.add("driverUsername1");
        list.add("driverUsername2");
        list.add("driverUsername3");

        for (String name : list) {
            loginPage.goTo();
            BrowserUtil.waitFor(2);
            loginPage.login(name);
            BrowserUtil.waitFor(2);

            User2 user=new User2();
            user.fleetDriver.click();
            BrowserUtil.waitFor(3);
            user.vehicles.click();
            BrowserUtil.waitFor(4);

            // String expectedResult="create car button should not be visible";
            assertTrue( ! user.isValidationMsgNotExist());
            //  assertFalse(user.isValidationMsgNotExist());


            VyTrackUtility.logout();

        }
    }
}