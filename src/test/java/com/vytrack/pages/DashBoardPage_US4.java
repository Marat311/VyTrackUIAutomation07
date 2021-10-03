package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage_US4 {

    @FindBy(xpath = "//a/span[normalize-space(.)='Customers']")
    public WebElement customerModul;

    @FindBy(xpath = "//a/span[.='Contacts'] ")
    public WebElement contactSubModul;

    public DashBoardPage_US4(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
