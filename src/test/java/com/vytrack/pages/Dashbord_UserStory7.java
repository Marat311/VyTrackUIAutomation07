package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashbord_UserStory7 {

    @FindBy(xpath ="//a/span[normalize-space(.) = 'Fleet']" )
    public WebElement Fleetlink;

    @FindBy(xpath = "//a/span[. = 'Vehicle Costs']")
    public WebElement vehicCost;


    public Dashbord_UserStory7(){
        PageFactory.initElements(Driver.getDriver(), this);

    }





}
