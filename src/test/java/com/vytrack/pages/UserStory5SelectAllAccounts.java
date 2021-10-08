package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory5SelectAllAccounts {

    public UserStory5SelectAllAccounts(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[normalize-space(.)='Customers']")
    private WebElement customersBtn;

    @FindBy(xpath = "(//span[text()='Accounts'])[1]")
    private WebElement accountsBtn;

    @FindBy(xpath = "(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]/input")
    private WebElement allCheckboxesBtn;



    public void clickCustomersBtn(){
        BrowserUtil.checkVisibilityOfElement(By.xpath("//span[normalize-space(.)='Customers']"), 5);
        customersBtn.click();
    }

    public void clickAccountsBtn(){
        BrowserUtil.checkVisibilityOfElement(By.xpath("(//span[text()='Accounts'])[1]"), 5);
        accountsBtn.click();
    }

    public void clickAllCheckboxesBtn(){
        BrowserUtil.checkVisibilityOfElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]/input"),2);
        allCheckboxesBtn.click();
        assertTrue(allCheckboxesBtn.isSelected());
        allCheckboxesBtn.click();
    }

    public void clickOneOfCheckboxes(){

        List<WebElement> checkboxes =  Driver.getDriver().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//td/input"));
        for(WebElement each:checkboxes){
            each.click();
            assertTrue(each.isSelected());
        }

    }



}