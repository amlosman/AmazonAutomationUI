package POM;

import Actions.WebActionsForElement;
import FileWrappers.ReadDataFromJSonFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    static String changeAddress = "addressChangeLinkId";
    static String addNewAddress = "add-new-address-popover-link";
    static String fullName = "address-ui-widgets-enterAddressFullName";
    static String mobileNumber = "address-ui-widgets-enterAddressPhoneNumber";
    static String streetName = "address-ui-widgets-enterAddressLine1";
    static String buildingName = "address-ui-widgets-enter-building-name-or-number";
    static String city = "//input[@id='address-ui-widgets-enterAddressCity']";
    static String district = "//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']";
    static String nearestLandmark = "address-ui-widgets-landmark";
    static String addressType = "//input[@id='address-ui-widgets-addr-details-res-radio-input']";
    static String addAddress = "//span[@id='address-ui-widgets-form-submit-button']//input[@class='a-button-input']";
    static String changePayment = "payChangeButtonId";
    static String cashMethod = ".cod-suppressed-color.a-color-secondary";
    static String useThisPayment = "pp-PP1dKB-73-announce";
    static String numOfItemsTitle = "//span[@class='a-color-link clickable-heading']";
    static String totalAmount= "//*[@class='a-color-price']";
    static String actualPrice= "//tr[1]/td[@class='a-text-right aok-nowrap a-nowrap']";
    static String derFees = "a-color-success";

    public static void changeAddress(WebDriver driver) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebActionsForElement(driver).clickonElement(changeAddress,
                WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
        new WebActionsForElement(driver).clickonElement(addNewAddress,
                WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
        new WebActionsForElement(driver).sendKeystoElement(fullName,
                WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.presenceOfElement,
                new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("AddNewAddress/FullName"));
        new WebActionsForElement(driver).sendKeystoElement(mobileNumber,
                WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.presenceOfElement,
                new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("AddNewAddress/MobileNumber"));
        new WebActionsForElement(driver).sendKeystoElement(streetName,
                WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.presenceOfElement
                , new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("AddNewAddress/StreetName"));
        new WebActionsForElement(driver).sendKeystoElement(buildingName, WebActionsForElement.Locators.id,
                WebActionsForElement.ExpectedConditionsEnum.presenceOfElement,
                new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("AddNewAddress/BuildingName"));
        new WebActionsForElement(driver).sendKeystoElement(city, WebActionsForElement.Locators.XPath,
                WebActionsForElement.ExpectedConditionsEnum.presenceOfElement
                , new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("AddNewAddress/City"));
        new WebActionsForElement(driver).sendKeystoElement(district, WebActionsForElement.Locators.XPath,
                WebActionsForElement.ExpectedConditionsEnum.presenceOfElement
                , new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("AddNewAddress/District"));
        new WebActionsForElement(driver).sendKeystoElement(nearestLandmark, WebActionsForElement.Locators.id,
                WebActionsForElement.ExpectedConditionsEnum.presenceOfElement
                , new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("AddNewAddress/StreetName"));
        new WebActionsForElement(driver).clickonElement(addressType, WebActionsForElement.Locators.XPath,
                WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
        new WebActionsForElement(driver).clickonElement(addAddress,
                WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

    }

    public static void changePayment(WebDriver driver) {
        new WebActionsForElement(driver).clickonElement(changePayment, WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebActionsForElement(driver).clickonElement(cashMethod, WebActionsForElement.Locators.CSS, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

        new WebActionsForElement(driver).clickonElement(useThisPayment, WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

    }
    public static boolean verifyProductAddToCard(WebDriver driver)
    {
       String [] numOfItems = driver.findElement(By.xpath(numOfItemsTitle)).getText().split(" ");
       return Integer.parseInt(numOfItems[0]) == HomePage.getNumOfProduct();
    }
    public static boolean verifyTotalAmount(WebDriver driver)
    {
        List<WebElement> items = driver.findElements(By.xpath(totalAmount));
        int sum =0;
        for(int i=0;i<items.size();i++)
        {
             String[] price = items.get(i).getText().split(" ");
            sum+=Integer.parseInt(price[1]);
        }
         items = driver.findElements(By.xpath(derFees));
         return Integer.parseInt(driver.findElement(By.xpath(actualPrice)).getText().split(" ")[1])== sum;


    }

}
