package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * We need a utility class with method
 * to get WebDriver object with all the settings needed
 * by passing browserName
 *
 * WebDriverFactory.get("Chrome") ==>WebDriver object with Chrome Driver
 * WebDriverFactory.get("Firefox") ==>WebDriver object with Firefox Driver
 */
public class WebDriverFactory {

    public static WebDriver getDriver(String browserName){
        WebDriver driver;
        switch (browserName.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver =new OperaDriver();
                // other browsers omitted
                break;
            default:
                driver = null ;
                System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
        }

        driver.manage().window().maximize();

        return driver ;
    }

}
