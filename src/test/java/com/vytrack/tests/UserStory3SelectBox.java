package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.UserStory3;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory3SelectBox extends TestBase {

    @Test
    public void clickAll(){
        LoginPage loginPage =new LoginPage();

        List<String> list=new ArrayList<>();

        list.add("storeManagerUsername1");
        list.add("storeManagerUsername2");
        list.add("salesManagerUsername1");
        list.add("salesManagerUsername2");
        list.add("salesManagerUsername3");

        for (String eachUser : list) {
            loginPage.goTo();
            loginPage.login(eachUser);
            BrowserUtil.waitFor(3);
            UserStory3 user=new UserStory3();
            user.clickAllCheck();
            user.dropdown.click();
            user.clickAll.click();
            assertTrue(user.checkBoxes());


            VyTrackUtility.logout();
        }
    }


    @Test
    public void clickOne() {
        LoginPage loginPage = new LoginPage();

        List<String> list = new ArrayList<>();

        list.add("storeManagerUsername1");
        list.add("storeManagerUsername2");
        list.add("salesManagerUsername1");
        list.add("salesManagerUsername2");
        list.add("salesManagerUsername3");
        for (String eachUser : list) {
            loginPage.goTo();
            loginPage.login(eachUser);
            BrowserUtil.waitFor(3);
            UserStory3 user=new UserStory3();
            user.clickAllCheck();
            user.clickOne.click();
            BrowserUtil.waitFor(2);
            assertTrue(user.clickOne.isSelected());
            VyTrackUtility.logout();
        }
    }
}
