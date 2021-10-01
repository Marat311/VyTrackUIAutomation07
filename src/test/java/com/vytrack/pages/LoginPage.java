package com.vytrack.pages;

import com.vytrack.utilities.ConfigReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement loginButton;
public LoginPage(){

    PageFactory.initElements(Driver.getDriver(), this);
}

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("url") );
    }

    public void login(String username){

        this.username.sendKeys(ConfigReader.read(username));
        this.password.sendKeys(ConfigReader.read("password"));
      loginButton.click();
    }

}
