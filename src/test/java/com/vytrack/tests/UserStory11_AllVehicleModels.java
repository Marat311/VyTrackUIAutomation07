package com.vytrack.tests;

import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;
import com.vytrack.pages.Dashbord_UserStory7_11;
import com.vytrack.pages.LoginPage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserStory11_AllVehicleModels {
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

       // When user select “Vehicle Model” under Fleet module
            Dashbord_UserStory7_11 dash = new Dashbord_UserStory7_11();
            dash.fleetlink.click();








        }


    }
}
