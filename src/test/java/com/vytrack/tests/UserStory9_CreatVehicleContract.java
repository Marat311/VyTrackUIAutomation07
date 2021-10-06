package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleNewContract;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VyTrackUtility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UserStory9_CreatVehicleContract extends TestBase {

    VehicleNewContract contract = new VehicleNewContract();
    @Test
    public void createVehicleContractManagers(){

        ArrayList<String> names = new ArrayList<>();
        names.add("storeManagerUsername1");
        names.add("storeManagerUsername2");
        names.add("salesManagerUsername1");
        names.add("salesManagerUsername2");
        names.add("salesManagerUsername3");



        for (String name : names) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(1);
            loginPage.login(name);
            BrowserUtil.waitFor(1);

           // VehicleNewContract contract = new VehicleNewContract();
            BrowserUtil.waitFor(1);
            contract.navigateToVehicleContract();
            contract.createVehicleContract();
           // BrowserUtil.waitFor(1);
            List<String> types = new ArrayList<>(Arrays.asList("Leasing","Personal Loan", "Credit Card", "Cash" ));
            for(String type:types) {
                contract.createType(type);
            }

            contract.createResponsiblePerson();
            contract.createActivationCost();

            List<String> amountDays = new ArrayList<>(Arrays.asList("No", "Daily", "Weekly", "Monthly", "Yearly"));

            for (String days :amountDays){
                contract.createRecurringCost(days);
            }

            contract.createRecurringCostAmountDepreciated();

            contract.createOdometer();

            contract.createInvoiceDate();

            contract.createContractDate();

            String expDate =  contract.createExpirationDate();

            contract.createVendor();

            contract.createDriver();

            contract.contractReference();

            contract.createTermsAndConditions();


            List<String>status = new ArrayList<>(Arrays.asList("Active", "Archived"));
            DateTimeFormatter Df = DateTimeFormatter.ofPattern("MMM dd, YYYY" );
            System.out.println("expDate = " + expDate);
            System.out.println(LocalDate.now().format(Df));
            if(!(expDate.equals(LocalDate.now().format(Df)))){
                contract.createStatus(status.get(0));
            }else{
                contract.createStatus(status.get(1));
            }

            List<String> vehicleModels = new ArrayList<>(Arrays.asList("FX", "corolla", "Model-X", "m3"));
            Map<String , String> modelsMake = new LinkedHashMap<>();
            modelsMake.put("FX", "DAF");
            modelsMake.put("corolla", "Toyota");
            modelsMake.put("Model-X", "Tesla");
            modelsMake.put("m3","mazda");

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)" ,  contract.addVehicleModel  );

            contract.addModel(modelsMake.get("corolla"));
            contract.addMake("Toyota");
            /*  for (Map.Entry<String, String> entry : modelsMake.entrySet()) {
                if(contract.addModel(entry.getKey())){
                    contract.addMake(entry.getValue());
                }
            }

           */

            contract.messageDisplayed();

            contract.saveAndClose();

            BrowserUtil.waitFor(1);

            VyTrackUtility.logout();
        }


    }


    @Test
    public void createVehicleContractDrivers(){

        ArrayList<String> names = new ArrayList<>();
        names.add("driverUsername1");
        names.add("driverUsername2");
        names.add("driverUsername3");



        for (String name : names) {

            LoginPage loginPage = new LoginPage();
            loginPage.goTo();
            BrowserUtil.waitFor(1);
            loginPage.login(name);
            BrowserUtil.waitFor(1);

            contract.navigateToVehicleContract();
            String errorM="You do not have permission to perform this action.";
            contract.errorMessageIsDisplayed(errorM);

            VyTrackUtility.logout();

        }
    }
}
