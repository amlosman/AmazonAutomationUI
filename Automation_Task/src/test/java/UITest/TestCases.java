package UITest;

import POM.CheckoutPage;
import POM.HomePage;
import POM.LoginPage;
import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends BaseTest{
    @Description("2- Step: Login ")

    @Test
    public void LoginTest()
    {
         HomePage.ClickOnSignIn(getDriver());
         LoginPage.setLoginCred(getDriver());
    }
    @Description("3- Step: Select condition")

    @Test(dependsOnMethods = "LoginTest")
    public void SelectConditionTest() {
        HomePage.ClickOnMenu(driver);
        HomePage.ClickOnSeeAll(driver);
        HomePage.ClickOnVideoGames(driver);
        HomePage.ClickOnAllVideoGames(driver);
        HomePage.clickOnFreeShipping(driver);
        HomePage.clickOnNew(driver);
        HomePage.selectOrderBy(driver);
    }
    @Description("3- Step: Select condition")
   @Test(dependsOnMethods ="SelectConditionTest" )
    public void addProductTest()
    {
        HomePage.selectProduct(driver);
    }
    @Description("3- Step: Add address")
    @Test(dependsOnMethods ="addProductTest" )
    public void AddAddressTest()
    {
        HomePage.clickOnCardCount(driver);
        HomePage.clickOnProceedToBuy(driver);
        Assert.assertTrue(CheckoutPage.verifyProductAddToCard(driver));
        //Assert.assertTrue(CheckoutPage.verifyTotalAmount(driver));
        CheckoutPage.changeAddress(driver);

    }
    @Description("3- Step: Choose payment way")
    @Test(dependsOnMethods ="AddAddressTest" )
    public void choosePaymentWayText()
    {

        CheckoutPage.changePayment(driver);
    }
}
