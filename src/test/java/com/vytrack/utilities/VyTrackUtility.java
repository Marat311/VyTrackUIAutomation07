package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VyTrackUtility {

    public static void logout(){
        Driver.getDriver().findElement(By.xpath("//li/a[@class='dropdown-toggle']")).click();
        BrowserUtil.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//li/a[.='Logout']")).click();
    }
}
