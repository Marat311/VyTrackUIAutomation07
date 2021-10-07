package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCheckBox_US3 {

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement clickFleet;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement clickVehicle;

    public SelectCheckBox_US3(){
        PageFactory.initElements(Driver.getDriver(), this);

    }




}
