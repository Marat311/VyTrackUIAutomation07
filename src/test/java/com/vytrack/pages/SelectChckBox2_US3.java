package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectChckBox2_US3 {


    @FindBy(xpath = "(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]")
    public WebElement clickAll;

    @FindBy(xpath = "(//input[@type= 'checkbox'])[5]")
    public WebElement clickOne;

    @FindBy(xpath = "//input[@type= 'checkbox']")
    public List<WebElement>checkAllBoxes;

    public SelectChckBox2_US3(){
        PageFactory.initElements(Driver.getDriver(), this);
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
