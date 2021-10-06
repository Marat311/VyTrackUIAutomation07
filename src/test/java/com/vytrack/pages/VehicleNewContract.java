package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehicleNewContract {
    Faker faker = new Faker();
    DateTimeFormatter Df = DateTimeFormatter.ofPattern("MMM dd, YYYY" );
    Actions actions = new Actions(Driver.getDriver());


    public VehicleNewContract() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1'][1]")
    public WebElement fleet;

    @FindBy(xpath = "//span[text()='Vehicle Contracts']")
    public WebElement vehicleContract;

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createVehicleContractBtn;

    @FindBy(xpath = "//option[@value='leasing']/..")
    private WebElement typeBtn;

    @FindBy(xpath = "//option[@value='leasing']")
    private WebElement leasingBtn;

    @FindBy(name = "custom_entity_type[Responsible]")
    public WebElement responsibleBtn;

    @FindBy(id = "user-menu")
    private WebElement responsibleName;

    @FindBy(name = "custom_entity_type[ActivationCost]")
    public WebElement activationCostBtn;

    @FindBy(name = "custom_entity_type[RecurringCostAmount]")
    public WebElement recurringCostAmountBtn;

    @FindBy(xpath = "//option[@value='no']/..")
    private WebElement recurringCost;

    @FindBy(xpath = "//input[@name='custom_entity_type[OdometerDetails]']")
    public WebElement odometerDetailsBtn;

    @FindBy(xpath = "//input[contains(@name, 'date_selector_custom_entity_type_InoviceDate')]")
    public WebElement inoviceDateBtn;

    @FindBy(xpath = "//input[contains(@name, 'date_selector_custom_entity_type_ContractStartDate')]")
    public WebElement contractStartDateBtn;

    @FindBy(xpath = "//input[contains(@name, 'date_selector_custom_entity_type_ContractExpirationDate')]")
    public WebElement contractExpirationDateBtn;

    @FindBy(name="custom_entity_type[Vendor]")
    public WebElement vendorBtn;

    @FindBy(name="custom_entity_type[Driver]")
    public WebElement driverBtn;

    @FindBy(name="custom_entity_type[ContractReference]")
    public WebElement contractReferenceBtn;

    @FindBy(name="custom_entity_type[TermsandConditions]")
    public WebElement termsAndConditionsBtn;

    @FindBy(xpath = "//option[@value='active']/..")
    public WebElement statusBtn;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement addVehicleModel;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement addVehicleMake;

    @FindBy(xpath = "//a[text()='VehiclesModel']")
    private WebElement vehicleModelPage;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']//td")
    private WebElement addModelName;

    @FindBy(xpath = "//input[@tabindex='-1']")
    private WebElement addCheckBoxModel;


    @FindBy(xpath = "(//input[@tabindex='-1'])[2]")
    private WebElement addCheckBoxMake;

    @FindBy(xpath = "//button[text()='Select']")
    private WebElement selectBtn;

    @FindBy(xpath = "//input[@type='radio']")
    private WebElement radioBtn;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    private WebElement radioBtnMake;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement saveAndClose;

    @FindBy(xpath = "//div[@class='flash-messages-frame']")
    private WebElement message;

    @FindBy(xpath = "(//div[@class='message'])[2]")
    private WebElement errorMessage;




    public void navigateToVehicleContract(){
        BrowserUtil.checkVisibilityOfElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"),2);
        fleet.click();
        vehicleContract.click();

    }

    public void createVehicleContract(){
        BrowserUtil.checkVisibilityOfElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"),2);
        createVehicleContractBtn.click();
    }

    public void createType(String type) {
        BrowserUtil.checkVisibilityOfElement(By.xpath("//option[@value='leasing']/.."),2);
       Select select = new Select(typeBtn);
       select.selectByVisibleText(type);

    }

    public void createResponsiblePerson() {
        responsibleBtn.sendKeys(responsibleName.getText());

    }

    public void createActivationCost(){
        activationCostBtn.sendKeys(String.valueOf(faker.number().numberBetween(10000, 1000000)));

    }

    public void createRecurringCostAmountDepreciated(){
        recurringCostAmountBtn.sendKeys(String.valueOf(faker.number().numberBetween(0,10000)));
    }

    public void createRecurringCost(String days){
        Select select = new Select(recurringCost);
        select.selectByVisibleText(days);
    }


    public void createOdometer(){
        odometerDetailsBtn.sendKeys(String.valueOf(faker.number().numberBetween(0,10000)));
    }

    public void createInvoiceDate(){

        inoviceDateBtn.sendKeys(LocalDate.now().format(Df));
    }

    public void createContractDate(){

        contractStartDateBtn.sendKeys(LocalDate.now().format(Df));
    }

    public String createExpirationDate(){

        String expDate = LocalDate.now().plusYears(faker.number().numberBetween(1,10)).format(Df);
        contractExpirationDateBtn.sendKeys(String.valueOf(LocalDate.now().plusYears(faker.number().numberBetween(1,10)).format(Df)));

       //  contractStartDateBtn.sendKeys(String.valueOf(faker.number().numberBetween(2022, 2030)));
    //return LocalDate.now().plusYears(faker.number().numberBetween(1,10));

        return expDate;
    }

    public void createVendor(){
        vendorBtn.sendKeys(faker.company().name());
    }

    public void createDriver(){
        driverBtn.sendKeys(faker.name().fullName());
    }

    public void contractReference(){
        contractReferenceBtn.sendKeys(faker.idNumber().ssnValid());
    }

    public void createTermsAndConditions(){
        termsAndConditionsBtn.sendKeys(faker.gameOfThrones().quote());
    }

    public void createStatus(String text){
        Select select = new Select(statusBtn);
        select.selectByVisibleText(text);
   }

    public void addModel(String model){
    BrowserUtil.checkVisibilityOfElement(By.xpath("(//div[@class='pull-right'])[2]/button"),5);

    actions.moveToElement(vehicleModelPage).click().perform();
    addVehicleModel.click();
    BrowserUtil.checkVisibilityOfElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//td"),5);
   //if(addModelName.getText().contains(model)){
    addCheckBoxModel.click();
    selectBtn.click();
    BrowserUtil.checkVisibilityOfElement(By.xpath("//input[@type='radio']"), 2);
    radioBtn.click();
 //  return true;
 //  }
//return false;
   }

   public void addMake(String make){
    //    if(addVehicleMake.getText().contains(make)){

       actions.moveToElement(addVehicleMake).click().perform();
       addCheckBoxMake.click();
       selectBtn.click();
            BrowserUtil.checkVisibilityOfElement(By.xpath("//input[@type='radio']"), 2);
            radioBtnMake.click();
   //         return true;
    //    }
    //   return false;
   }

   public void messageDisplayed(){
        assertTrue(message.isDisplayed());
   }

   public void errorMessageIsDisplayed(String errorM){
BrowserUtil.checkVisibilityOfElement(By.xpath("(//div[@class='message'])[2]"),2);
       assertTrue(errorMessage.getText().equals(errorM));
   }

   public void saveAndClose(){
        saveAndClose.click();
   }




}
/*
AC #1:
managers are able to Create Vehicle Contract.
Given store/sales manager is on the homePage
When user select “Vehicle Contract” under Fleet module
And user click “Create Vehicle Contract” button
When user fill out general information and click “Save and Close” button
Then verify “Entity saved” confirm message

AC #2:
driver should not to create Vehicle Contract.
Given driver is on the homePage
When user select “Vehicle Contract” under Fleet module
Then verify “You do not have permission to perform this action.” message
 */