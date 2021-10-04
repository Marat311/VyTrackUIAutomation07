package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage_US4 {

    @FindBy(xpath = "//div/input[@name='oro_contact_form[firstName]']")
    public WebElement firstName;

    @FindBy(xpath = "//div/input[@name = 'oro_contact_form[lastName]']")
    public WebElement lastName;

    @FindBy(xpath = "//div/input[@type = 'email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//div/input[@name='oro_contact_form[phones][0][phone]']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//div/button[@type='submit' and @class = 'btn btn-success action-button']")
    public WebElement saveAndCloseBtn;


    public CreateContactPage_US4(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}

