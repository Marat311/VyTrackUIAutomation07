package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.WPage_GetHelpUS10;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class UserStory10 extends TestBase {

    /*
    As a user, I should be access to Oro Documentation page.
 AC #1: user access Oro Documentation page
Given user is on the homePage
When user click question icon on the right top of the homepage
Then verify user accessed to Oro Documentation page.
     */


@Test
        public void isOnDocumentationPage(){


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
            //login
            loginObj.goTo();
            loginObj.login(eachUser);



            BrowserUtil.waitFor(3);

            WPage_GetHelpUS10 wPageGetHelpObj = new WPage_GetHelpUS10();

            Assertions.assertTrue(wPageGetHelpObj.isOnDocumentationPage());

            Driver.getDriver().navigate().to("https://qa3.vytrack.com/");

            BrowserUtil.waitFor(3);

            //logout
            Driver.getDriver().findElement(By.xpath("//li/a[@class='dropdown-toggle']")).click();
            BrowserUtil.waitFor(1);
            Driver.getDriver().findElement(By.xpath("//li/a[.='Logout']")).click();


        }



    }

}
