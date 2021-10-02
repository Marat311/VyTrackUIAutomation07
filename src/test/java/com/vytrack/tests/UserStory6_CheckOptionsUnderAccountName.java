package com.vytrack.tests;

import com.sun.tools.internal.jxc.ConfigReader;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.WPage_UserStory6;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory6_CheckOptionsUnderAccountName extends TestBase {

    /*
        As a user, I should be view 3 options under my account name.


        AC #1: users have 3 options under their usernames.

        Given user is on the homePage
        When user click username on the right top corner
        Then verify there are “My Username” “My Configuration” “My Calendar” options
     */

    //  BUG FOUND!!!!! -> "My User" instead of "My Username", test fails : returns falls


        @Test
    public void checkOptionsNames(){

            LoginPage loginObj = new LoginPage();



            List<String> credentials = new ArrayList<>();

            credentials.add("driverUsername1");
            credentials.add("driverUsername2");
            credentials.add("driverUsername3");
            credentials.add("storeManagerUsername1");
            credentials.add("storeManagerUsername2");
            credentials.add("salesManagerUsername1");
            credentials.add("salesManagerUsername2");
            credentials.add("salesManagerUsername3");


                for (String eachUser : credentials) {
                        loginObj.goTo();

                        loginObj.login(eachUser);

                        BrowserUtil.waitFor(2);

                        WPage_UserStory6 optionsObj = new WPage_UserStory6();

                        Assertions.assertTrue(optionsObj.checkOptions());

                    Driver.getDriver().findElement(By.xpath("//li/a[@class='no-hash']")).click();


                }




        }



}
