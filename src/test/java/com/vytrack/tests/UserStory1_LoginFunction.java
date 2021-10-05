package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.ModulesPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserStory1_LoginFunction extends TestBase {

    /*
    1. Story: As a user, I should be access all the main modules of the app.
 AC #1:
 Given store/sales manager is on the homePage
 Then verify user view 8 models names [verify the names]

 AC #2:
 Given driver is on the homePage
 Then verify user view 4 models names [verify the names]
     */
    @Test
    public void verifyAccesToModule() {
        ArrayList<String> names = new ArrayList<>();
        names.add("driverUsername1");
        names.add("driverUsername2");
        names.add("driverUsername3");
        //names.add("storeManagerUsername1");
        //names.add("storeManagerUsername2");
        //names.add("salesManagerUsername1");
        //names.add("salesManagerUsername2");
        //names.add("salesManagerUsername3");


        for (String name : names) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(2);
            loginPage.login(name);
            BrowserUtil.waitFor(2);
            ModulesPage moduleObj = new ModulesPage();
            Assertions.assertEquals(4,moduleObj.quantityOfModulesDriver());

            Assertions.assertTrue(moduleObj.namesOfModulesDriver());
            VyTrackUtility.logout();
        }


    }
}