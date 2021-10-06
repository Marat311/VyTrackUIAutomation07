package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.pages.CreateVehicleCost;
import com.vytrack.pages.Dashbord_UserStory7;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleCostEntities;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserStory7_CreateVehicleCost extends TestBase {

    @Test
    public void testCreateVehicleCost() {

        ArrayList<String> names = new ArrayList<>();
        names.add("driverUsername1");
        names.add("driverUsername2");
        names.add("driverUsername3");
        names.add("storeManagerUsername1");
        names.add("storeManagerUsername2");
        names.add("salesManagerUsername1");
        names.add("salesManagerUsername2");
        names.add("salesManagerUsername3");


        for (String name : names) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(2);
            loginPage.login(name);
            BrowserUtil.waitFor(2);


            Dashbord_UserStory7 dashbord = new Dashbord_UserStory7();
            dashbord.fleetlink.click();
            dashbord.vehicCost.click();
            BrowserUtil.waitFor(5);

            VehicleCostEntities vehicleCostEntities = new VehicleCostEntities();
            vehicleCostEntities.createVehicleBtn.click();
            BrowserUtil.waitFor(2);


            Faker faker = new Faker();
            CreateVehicleCost createVehicleCost = new CreateVehicleCost();
            createVehicleCost.chooseValue.click();
            createVehicleCost.option.click();
            createVehicleCost.totalPrice.sendKeys(String.valueOf(faker.number().numberBetween(100,100000)));
            createVehicleCost.date.click();
            createVehicleCost.todayBtn.click();
            createVehicleCost.costDescription.sendKeys(faker.chuckNorris().fact());
            createVehicleCost.saveClose.click();
            BrowserUtil.waitFor(5);

            String expectedResult = "Entity saved";
            String actualResult = createVehicleCost.confimMessage.getText();

            Assertions.assertTrue(expectedResult.equals(actualResult));
            BrowserUtil.waitFor(2);

            VyTrackUtility.logout();

        }

    }
}