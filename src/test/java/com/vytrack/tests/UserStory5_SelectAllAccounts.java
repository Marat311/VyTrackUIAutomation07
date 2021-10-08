package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.UserStory5SelectAllAccounts;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserStory5_SelectAllAccounts {
    @Test
    public void UserSelectFirstCheckbox(){

        ArrayList<String> names = new ArrayList<>();
        names.add("storeManagerUsername1");
        names.add("storeManagerUsername2");
        names.add("salesManagerUsername1");
        names.add("salesManagerUsername2");
        names.add("salesManagerUsername3");
        names.add("driverUsername1");
        names.add("driverUsername2");
        names.add("driverUsername3");

        UserStory5SelectAllAccounts accounts = new UserStory5SelectAllAccounts();

        for (String name : names) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(2);
            loginPage.login(name);
            BrowserUtil.waitFor(1);

            accounts.clickCustomersBtn();

            accounts.clickAccountsBtn();

            accounts.clickAllCheckboxesBtn();
            BrowserUtil.waitFor(1);

            VyTrackUtility.logout();
        }

    }


    @Test
    public void UserSelectOneByOneCheckboxes(){
        ArrayList<String> names = new ArrayList<>();
        names.add("storeManagerUsername1");
        names.add("storeManagerUsername2");
        names.add("salesManagerUsername1");
        names.add("salesManagerUsername2");
        names.add("salesManagerUsername3");
        names.add("driverUsername1");
        names.add("driverUsername2");
        names.add("driverUsername3");

        UserStory5SelectAllAccounts accounts = new UserStory5SelectAllAccounts();

        for (String name : names) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(2);
            loginPage.login(name);
            BrowserUtil.waitFor(1);

            accounts.clickCustomersBtn();

            accounts.clickAccountsBtn();


            accounts.clickOneOfCheckboxes();
            BrowserUtil.waitFor(1);

            VyTrackUtility.logout();
        }
    }
}
