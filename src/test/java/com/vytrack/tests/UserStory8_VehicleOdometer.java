package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.UserStory8;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 8. Story: As a user, I should be create Vehicle Odometer.
 * 
 * AC #1: drivers are able to create Vehicle Odometer.
 *
 * Given driver is on the homePage
 * When user select “Vehicle Odometer” under Fleet module
 * And user click “Create Vehicle Odometer” button
 * When user fill out general information and click “Save and Close” button
 * Then verify “Entity saved” confirm message
 *
 * AC #2: managers should not to create Vehicle Odometer.
 *
 * Given store/sales manager is on the homePage
 * When user select “Vehicle Odometer” under Fleet module
 * Then verify “You do not have permission to perform this action.” message
 */
public class UserStory8_VehicleOdometer extends TestBase {

    @Test
    public void truckDrivers(){
        LoginPage loginPage =new LoginPage();

        UserStory8 userStory8=new UserStory8();

        List<String> credentials = new ArrayList<>();

        credentials.add("driverUsername1");
        credentials.add("driverUsername2");
        credentials.add("driverUsername3");
        for (String eachUser : credentials) {
            loginPage.goTo();
            loginPage.login(eachUser);
          //  BrowserUtil.waitFor(3);

            userStory8.driverVehicleOdometer();
            BrowserUtil.waitFor(2);
            userStory8.fillOutForm();
            String expectedResult = "Entity saved";
            String actualResult=userStory8.savageMsg.getText();
            assertEquals(expectedResult, actualResult);
            VyTrackUtility.logout();
        }

    }



    @Test
    public void salesAndStoreManager(){
        LoginPage loginPage=new LoginPage();
        UserStory8 userStory=new UserStory8();

        List<String> credentials = new ArrayList<>();
        credentials.add("storeManagerUsername1");
        credentials.add("storeManagerUsername2");
        credentials.add("salesManagerUsername1");
        credentials.add("salesManagerUsername2");
        credentials.add("salesManagerUsername3");

        for (String eachUser : credentials) {
            loginPage.goTo();
            loginPage.login(eachUser);
            BrowserUtil.waitFor(2);
            userStory.storeAndSalesManager();
            BrowserUtil.waitFor(1);
            String expectedResult="You do not have permission to perform this action.";
            String actualResult=userStory.errorMsg.getText();
            assertEquals(expectedResult,actualResult);
            VyTrackUtility.logout();

        }

    }


}
