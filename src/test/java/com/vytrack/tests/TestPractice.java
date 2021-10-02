package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class TestPractice extends TestBase {
    /**
     * This class for example
     */
    @Test
    public void login(){

        LoginPage loginPage=new LoginPage();

        loginPage.goTo();
        loginPage.login("driverUsername1");
    }
}
