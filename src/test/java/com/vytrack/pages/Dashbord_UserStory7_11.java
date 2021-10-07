package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashbord_UserStory7_11 {

    @FindBy(xpath ="//a/span[normalize-space(.) = 'Fleet']" )
    public WebElement fleetlink;

    @FindBy(xpath = "//a/span[. = 'Vehicle Costs']")
    public WebElement vehicCost;


    @FindBy(xpath = "//span[.='Vehicles Model']")
    public WebElement vehicleModelOption;

    public Dashbord_UserStory7_11(){
        PageFactory.initElements(Driver.getDriver(), this);

    }





}
