package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.SelectChckBox2_US3;
import com.vytrack.pages.SelectCheckBox_US3;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory3_SelectAntVehicle extends TestBase {


    @Test
    public void selectOneCHeck(){


        List<String> storeManagers = new ArrayList<>();
        storeManagers.addAll(Arrays.asList("storeManagerUsername1", "storeManagerUsername2"));

        for (String EachstoreManager : storeManagers) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(5);
            loginPage.login(EachstoreManager);
            BrowserUtil.waitFor(5);

            SelectCheckBox_US3 checkBox_us3 = new SelectCheckBox_US3();

            checkBox_us3.clickFleet.click();
            checkBox_us3.clickVehicle.click();

            SelectChckBox2_US3 checkBox2 = new SelectChckBox2_US3();
            checkBox2.clickAll.click();


            Assertions.assertTrue(checkBox2.checkBoxes());









        }




    }



}
