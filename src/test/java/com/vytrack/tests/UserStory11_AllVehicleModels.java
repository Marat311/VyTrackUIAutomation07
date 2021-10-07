package com.vytrack.tests;

import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;
import com.vytrack.pages.Dashbord_UserStory7_11;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleModel_Entities_US11;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserStory11_AllVehicleModels extends TestBase {
//    AC #1: user should view all the vehicles model
//    Given user is on the homePage
//    When user select “Vehicle Model” under Fleet module
//    Then verify user can view all the vehicles

    @Test

    public void ViewAllModels_Test() {

        LoginPage loginPage = new LoginPage();

        List<String> names = new ArrayList<>();
        names.add("driverUsername1");
        names.add("driverUsername2");
        names.add("driverUsername3");
        names.add("storeManagerUsername1");
        names.add("storeManagerUsername2");
        names.add("salesManagerUsername1");
        names.add("salesManagerUsername2");
        names.add("salesManagerUsername3");

        loginPage.goTo();
       // Given user is on the homePage
        for (String name : names) {
            loginPage.login(name);

            BrowserUtil.waitFor(2);
       // When user select “Vehicle Model” under Fleet module
            Dashbord_UserStory7_11 dash = new Dashbord_UserStory7_11();
            dash.fleetlink.click();
            BrowserUtil.waitFor(1);
            dash.vehicleModelOption.click();

       //    Then verify user can view all the vehicles

            BrowserUtil.waitFor(5);
            VehicleModel_Entities_US11 models = new VehicleModel_Entities_US11();
            Assertions.assertTrue(models.compareActualvsTotal());

            VyTrackUtility.logout();
        }


    }
}
