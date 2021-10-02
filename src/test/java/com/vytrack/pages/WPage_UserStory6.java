package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WPage_UserStory6 {

    @FindBy(xpath = "//li/a[@class='dropdown-toggle']")
    public WebElement accountName;

    @FindBy(xpath = "//li/a[.='My User']")
    public WebElement firstOption;

    @FindBy(xpath = "//li/a[.='My Configuration']")
    public WebElement secondOption;

    @FindBy(xpath = "//li/a[.='My Calendar']")
    public WebElement thirdOption;

    public WPage_UserStory6() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public boolean checkOptions(){

        boolean result = false;

        this.accountName.click();

        BrowserUtil.waitFor(2);

        if(this.firstOption.getText().equals("My Username")
                && this.secondOption.getText().equals("My Configuration")
                && this.thirdOption.getText().equals("My Calendar")){
            result=true;
        }


        return result;

    }


}
