package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserStory3 {

    @FindBy(xpath ="(//span[@class='title title-level-1'])[2]")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicle;

    @FindBy(xpath = "(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]")
    public WebElement dropdown;

    @FindBy(linkText = "All")
    public WebElement clickAll;

    @FindBy(xpath = "(//input[@data-role='select-row-cell'])[3]")
    public WebElement clickOne;

    @FindBy(xpath = "//input[@data-role='select-row-cell']")
    public List<WebElement> checkAllBoxes;

    public void clickAllCheck(){
        fleet.click();
        BrowserUtil.waitFor(3);
        vehicle.click();
        BrowserUtil.waitFor(3);



    }



    public UserStory3(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public boolean checkBoxes(){

        boolean result = true;

        for (WebElement eachBox : checkAllBoxes) {


            if(!eachBox.isSelected()){

                result=false;
                break;
            }
        }
        return result;

    }
}

