package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllContactsPage_US4 {

    @FindBy(xpath = "//div/a[@title='Create Contact']")
    public WebElement createContactBtn;

    @FindBy(xpath = "//div[.='Contact saved']")
    public WebElement confirmMsg;

    public AllContactsPage_US4(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
