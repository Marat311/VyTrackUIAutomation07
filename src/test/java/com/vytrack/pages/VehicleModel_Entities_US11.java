package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleModel_Entities_US11 {

    @FindBy (xpath = "//label[starts-with(text(), 'Total of')]")
    public WebElement totalModels;

    @FindBy(xpath = "//tr/td[@class = 'string-cell grid-cell grid-body-cell grid-body-cell-ModelName']")
    public List<WebElement> visibleTotal;


    public VehicleModel_Entities_US11 (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public boolean compareActualvsTotal(){

        String number = totalModels.getText().substring(totalModels.getText().indexOf("f")+2);
                   number = number.substring(0,1);
                   int numsOfModels = Integer.parseInt(number);

           return numsOfModels == visibleTotal.size();
    }



}
