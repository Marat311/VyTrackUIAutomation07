package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.pages.AllContactsPage_US4;
import com.vytrack.pages.CreateContactPage_US4;
import com.vytrack.pages.DashBoardPage_US4;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory4_CreatingContactInformation extends TestBase {

    @Test
    public void testCreateContactInfo(){



        List<String> userNames = new ArrayList<>();

        userNames.addAll(Arrays.asList("driverUsername1","driverUsername2","driverUsername3"));
//                "storeManagerUsername1","storeManagerUsername2","storeManagerUsername3",
//                "salesManagerUsername1","salesManagerUsername2","salesManagerUsername3"));

        for (String eachUserName : userNames) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(2);
            loginPage.login(eachUserName);
            BrowserUtil.waitFor(3);

            DashBoardPage_US4 us4Obj = new DashBoardPage_US4();
            us4Obj.customerModul.click();
            us4Obj.contactSubModul.click();
            BrowserUtil.waitFor(5);


            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),13);

            AllContactsPage_US4 allObj = new AllContactsPage_US4();
            wait.until(ExpectedConditions.elementToBeClickable(allObj.createContactBtn));
            allObj.createContactBtn.click();
            BrowserUtil.waitFor(3);

            Faker faker = new Faker();

            CreateContactPage_US4 contactObj = new CreateContactPage_US4();
            contactObj.firstName.sendKeys(faker.name().firstName());
            contactObj.lastName.sendKeys(faker.name().lastName());
            contactObj.emailAddress.sendKeys(faker.internet().emailAddress());
            contactObj.phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
            contactObj.saveAndCloseBtn.click();
            BrowserUtil.waitFor(6);


            String expectedResult = "Contact saved";
            Assertions.assertEquals(expectedResult,allObj.confirmMsg.getText());

            VyTrackUtility.logout();


        }

    }
}
