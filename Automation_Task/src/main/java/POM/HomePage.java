package POM;

import Actions.WebActionsForElement;
import FileWrappers.ReadDataFromJSonFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    static String signIN = "//*[@class='nav-line-1-container']";
    static String menu = "//*[@class='hm-icon-label']";
    static String seeAll = "//*[@class='hmenu-item hmenu-compressed-btn']";
    static String proceedToBuy = "//span[@id='desktop-ptc-button-celWidget']";
    static String videoGames = "//div[text()='Video Games']";
    static String allVideoGame = "//*[text()='All Video Games']";
    static String freeShipping = "//*[contains(text(),'Free Shipping')]";
    static String newBtn = "//*[text()='New']";
    static String orderBy = "s-result-sort-select";
    static String price = "//*[@class='a-price-whole']";
    static String addToCardBtn = "add-to-cart-button";
    static String next = "//a[text()='Next']";
    static String cardCount = "nav-cart-count";
    static int numOfProduct;


    public static void ClickOnSignIn(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebActionsForElement(driver).
                clickonElement(signIN,
                        WebActionsForElement.Locators.XPath,
                        WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

    }

    public static void ClickOnMenu(WebDriver driver) {

        new WebActionsForElement(driver).
                clickonElement(menu,
                        WebActionsForElement.Locators.XPath,
                        WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

    }

    public static void ClickOnSeeAll(WebDriver driver) {

        new WebActionsForElement(driver).clickonElement(seeAll,
                WebActionsForElement.Locators.XPath,
                WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

    }

    public static void ClickOnVideoGames(WebDriver driver) {

        try {
            new WebActionsForElement(driver).scrollToElementByLocator(videoGames, WebActionsForElement.Locators.XPath);
            new WebActionsForElement(driver).clickonElement(videoGames,
                    WebActionsForElement.Locators.XPath,
                    WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void ClickOnAllVideoGames(WebDriver driver) {
        new WebActionsForElement(driver).clickonElement(allVideoGame,
                WebActionsForElement.Locators.XPath,
                WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);

    }

    public static void clickOnFreeShipping(WebDriver driver) {
        new WebActionsForElement(driver).clickonElement(freeShipping,
                WebActionsForElement.Locators.XPath,
                WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
    }

    public static void clickOnNew(WebDriver driver) {

        new WebActionsForElement(driver).clickonElement(newBtn,
                WebActionsForElement.Locators.XPath,
                WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
    }

    public static void selectOrderBy(WebDriver driver) {
        Select order = new Select(driver.findElement(By.id(orderBy)));
        order.selectByVisibleText("Price: High to Low");
    }

    public static void selectProduct(WebDriver driver) {
        boolean findProduct = false;
        int priceValue = Integer.parseInt(new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Home/PriceValue"));
        do {
            List<WebElement> products = driver.findElements(By.xpath(price));


            for (int i = 0; i < products.size(); i++) {

                selectOrderBy(driver);
                products = driver.findElements(By.xpath(price));
                try {
                    Thread.sleep(10000);
                    String[] pr = products.get(i).getText().split(",");
                    int x;
                    x = Integer.parseInt(pr[0]);
                    if ((pr.length == 2 && x < priceValue) || pr.length == 1) {
                        products.get(i).click();
                        new WebActionsForElement(driver).clickonElement(addToCardBtn, WebActionsForElement.Locators.id,
                                WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
                        numOfProduct++;
                        driver.navigate().back();
                        driver.navigate().back();
                        findProduct = true;

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (findProduct == false)
                new WebActionsForElement(driver).clickonElement(next, WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
        } while (!findProduct);
    }

    public static void clickOnCardCount(WebDriver driver) {
        new WebActionsForElement(driver).clickonElement(cardCount,
                WebActionsForElement.Locators.id,
                WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
    }

    public static void clickOnProceedToBuy(WebDriver driver) {
        new WebActionsForElement(driver).clickonElement(proceedToBuy,
                WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
    }

    public static String verifyUserLoggedIn(WebDriver driver) {
        return new WebActionsForElement(driver).getElementText("//div[@id='glow-ingress-block']/span[@class='nav-line-1 nav-progressive-content']",
                WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.visibilityOfElement);
    }

    public static int getNumOfProduct() {
        return numOfProduct;
    }

}
