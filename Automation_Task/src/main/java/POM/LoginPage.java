package POM;

import Actions.WebActionsForElement;
import FileWrappers.ReadDataFromJSonFile;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    static String email = "ap_email";
    static String password = "//input[@id='ap_password']";
    static String continueBtn = "continue";
    static String signBtn = "signInSubmit";

    public static void setLoginCred(WebDriver driver) {

        new WebActionsForElement(driver)
                .sendKeystoElement(email, WebActionsForElement.Locators.id,
                        WebActionsForElement.ExpectedConditionsEnum.
                                ElementToBeClickable, new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Login/Email"));

        new WebActionsForElement(driver).
                clickonElement(continueBtn,
                        WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

        new WebActionsForElement(driver)
                .sendKeystoElement(password, WebActionsForElement.Locators.XPath,
                        WebActionsForElement.ExpectedConditionsEnum.
                                ElementToBeClickable, new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Login/Password"));

        new WebActionsForElement(driver).
                clickonElement(signBtn,
                        WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

    }
}
