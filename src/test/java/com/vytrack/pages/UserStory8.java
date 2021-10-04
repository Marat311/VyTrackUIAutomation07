package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class UserStory8  {

    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetModule;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetModuleForSal;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[2]")
    public WebElement vehicleOdometer;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[4]")
    public WebElement vehicleOdometerForStore;

    @FindBy(xpath = "//a[normalize-space(.)='Create Vehicle Odometer']")
    public WebElement createVehicleOdometer;

    @FindBy(name = "custom_entity_type[OdometerValue]")
    public WebElement odometerValue;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverName;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndClose;

    @FindBy(xpath = "//div[normalize-space(.)='Entity saved']")
    public WebElement savageMsg;

    @FindBy(xpath = "//div[normalize-space(.)='You do not have permission to perform this action.']")
    public WebElement errorMsg;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement alertMsg;

    public UserStory8(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void driverVehicleOdometer(){
        fleetModule.click();
        BrowserUtil.waitFor(1);
        vehicleOdometer.click();
        BrowserUtil.waitFor(1);
        createVehicleOdometer.click();
        BrowserUtil.waitFor(1);
    }

    public void fillOutForm(){
        Faker faker=new Faker();
        odometerValue.click();
        odometerValue.sendKeys(String.valueOf(faker.number().numberBetween(300,999999)));
        driverName.sendKeys(faker.name().fullName());
        saveAndClose.click();

    }


    public void storeAndSalesManager(){
        alertMsg.click();
        fleetModuleForSal.click();
        BrowserUtil.waitFor(1);
       vehicleOdometerForStore.click();

    }



}
