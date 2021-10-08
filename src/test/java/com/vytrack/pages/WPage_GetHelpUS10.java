package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class WPage_GetHelpUS10 {


    @FindBy(className = "fa-question-circle")
    public WebElement questionMark;

    public WPage_GetHelpUS10(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public boolean isOnDocumentationPage(){

        String currentHandle = Driver.getDriver().getWindowHandle();

        questionMark.click();

        Set<String> allHandles = Driver.getDriver().getWindowHandles();

        for (String eachHandle : allHandles) {
            System.out.println("eachHandle = " + eachHandle);
            // THIS IS HOW YOU SWITCH TO DIFFERENT WINDOW|tab
            Driver.getDriver().switchTo().window( eachHandle ) ;
        }

        BrowserUtil.waitFor(3);
        if(Driver.getDriver().getTitle().startsWith("Welcome to Oro Documentation")){
            return true;
        }

        Driver.getDriver().switchTo().window(currentHandle ) ;

        return false;

    }


}
