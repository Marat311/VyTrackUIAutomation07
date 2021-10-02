package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVehicleCost {

    @FindBy(xpath = "//span[.='Choose a value...']")
    public WebElement chooseValue;

    @FindBy(xpath = "//li[.='Snow tires']")
    public WebElement option;

    @FindBy(xpath = "//input[@data-name=\"field__total-price\"]")
    public WebElement   totalPrice;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement   date;

    @FindBy(xpath = "//button[@data-handler='today']")
    public WebElement   todayBtn;

    @FindBy(xpath = "//textarea")
    public WebElement   costDescription;

    @FindBy(xpath = "//div/button[@type='submit']")
    public WebElement saveClose;


    public CreateVehicleCost(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


}
