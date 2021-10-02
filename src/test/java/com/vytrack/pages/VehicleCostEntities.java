package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleCostEntities {

    @FindBy(xpath =  "//div/a [normalize-space(.)= 'Create Vehicle Costs'] ")
public WebElement createVehicleBtn;


    public VehicleCostEntities(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

}
