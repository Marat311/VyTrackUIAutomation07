package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModulesPage {

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1']")
    public List<WebElement> firstThreeModules;

    @FindBy(xpath = "//li[@class='mobile-hide dropdown dropdown-level-1 last']")
    public WebElement lastModuleDriver;

    public ModulesPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    public Integer quantityOfModulesDriver() {

        List<WebElement> allModules = new ArrayList<>();
        allModules.addAll(this.firstThreeModules);
        allModules.add(this.lastModuleDriver);


        return allModules.size();
    }

    public boolean namesOfModulesDriver() {

        boolean result = false;

        List<String> expectedModulesNames = new ArrayList<>(Arrays.asList("Fleet",
                "Customers", "Activities", "System"));

        List<WebElement> allModules = new ArrayList<>();
        allModules.addAll(this.firstThreeModules);
        allModules.add(this.lastModuleDriver);

        BrowserUtil.waitFor(4);

        for (int i = 0; i < allModules.size(); i++) {

            if (allModules.get(i).getText().equals(expectedModulesNames.get(i))) {
                result = true;
                System.out.println("allModules.get(i) = " + allModules.get(i).getText());
            }

        }
        return result;

    }
}







