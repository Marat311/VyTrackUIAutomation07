package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class User2 {
    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetDriver;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetModule;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicles;

    @FindBy(xpath = "//div[normalize-space(.)='Create Car']")
    public WebElement createCar;

    @FindBy(name = "custom_entity_type[LicensePlate]")
    public WebElement licensePlate;

    @FindBy(xpath = "(//input[@name='custom_entity_type[Tags][]'])[4]")
    public WebElement purchasedBox;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverName;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement location;

    @FindBy(name = "custom_entity_type[ChassisNumber]")
    public WebElement chassisNumber;

    @FindBy(name = "custom_entity_type[ModelYear]")
    public WebElement modelYear;

    @FindBy(name = "custom_entity_type[LastOdometer]")
    public WebElement lastOdometer;

    @FindBy(xpath = "(//div/input[@type='text'])[5]")
    public WebElement immaDateBox;

    @FindBy(xpath = "//div/button[@data-handler='today']")
    public WebElement todayDateOption;

    @FindBy(xpath = "(//div/input[@type='text'])[6]")
    public WebElement firstContractDate;

    @FindBy(xpath = "//div/button[@data-handler='today']")
    public WebElement todayContractDate;

    @FindBy(xpath = "(//div/input[@type='text'])[7]")
    public WebElement catalogValue;


    @FindBy(xpath = "(//div/input[@type='number'])[3]")
    public WebElement seatsNumber;

    @FindBy(xpath = "(//div/input[@type='number'])[4]")
    public WebElement doorsNumber;


    @FindBy(xpath = "(//div/input[@type='text'])[8]")
    public WebElement colorBox;

    @FindBy(xpath = "(//a/span[text()='Choose a value...'])[1]")
    public WebElement transmissionDropDown;
    //selecting visible Manual

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    //(//li/div[@class='select2-result-label'])[2]>>Automation
    public WebElement manualTransmission;

    @FindBy(xpath = "(//a/span[@class='select2-chosen'])[2]")
    public WebElement fuelTypeDropDown;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[2]")
    public WebElement gasolineFuel;

    @FindBy(xpath = "(//div/input[@type='text'])[11]")
    public WebElement emissionsBox;

    @FindBy(xpath = "(//div/input[@type='number'])[5]")
    public WebElement horsePower;


    @FindBy(xpath = "(//div/input[@type='text'])[12]")
    public WebElement horsePowerTaxation;

    @FindBy(xpath = "(//div/input[@type='number'])[6]")
    public WebElement powerKW;

    @FindBy(xpath = "//div/input[@type='file']")
    public WebElement logoUpload;

    @FindBy(xpath = "(//div/button[@class='btn btn-medium add-btn'])[1]")
    public WebElement vehicleModelBtn;

    @FindBy(xpath = "(//div/button[@class='btn btn-medium add-btn'])[2]")
    public WebElement vehicleMakeBtn;


    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndClose;

    @FindBy(xpath = "//div[normalize-space(.)='Entity saved']")
    public WebElement savageMsg;

    public void salesClick(){
        fleetModule.click();
        BrowserUtil.waitFor(3);
        vehicles.click();
        BrowserUtil.waitFor(3);
        createCar.click();
        BrowserUtil.waitFor(2);
    }

    public User2(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void fillOut(){
        Faker faker=new Faker();
        Select select;
        licensePlate.sendKeys(faker.numerify("######"));
        purchasedBox.click();
        driverName.sendKeys(faker.name().fullName());
        location.sendKeys(faker.address().streetAddress());
        chassisNumber.sendKeys(faker.numerify("######"));
        modelYear.sendKeys(String.valueOf(faker.number().numberBetween(2015,2030)) );
        lastOdometer.sendKeys(faker.numerify("########"));
        seatsNumber.sendKeys(faker.numerify("6"));
        doorsNumber.sendKeys(faker.numerify("4"));
        colorBox.sendKeys(faker.color().name());
        transmissionDropDown.click();
//        select=new Select(transmissionDropDown);
//        select.selectByIndex(1);
//        fuelTypeDropDown.click();
//        select=new Select(fuelTypeDropDown);
//        select.selectByIndex(1);


        saveAndClose.click();
    }
    public boolean isValidationMsgNotExist() {
        try{
            Driver.getDriver().findElement(By.xpath("//div/a[normalize-space(.)='Create Car']"));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}