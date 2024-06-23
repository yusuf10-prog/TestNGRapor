package day18_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroAppPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_SoftAssertion {

    @Test
    public void zeroAppTesti() {
        //. “http://zero.webappsecurity.com/” Adresine gidin

        Driver.getDriver().get(ConfigReader.getProperty("zeroAppUrl"));
        // 2. Sign in butonuna basin

        ZeroAppPage zeroAppPage=new ZeroAppPage();
        zeroAppPage.signinButonu.click();

        // 3. Login kutusuna “username” yazin
        zeroAppPage.usernameButonu.sendKeys(ConfigReader.getProperty("zeroUsername"));
        // 4. Password kutusuna “password” yazin
        zeroAppPage.passwordButonu.sendKeys(ConfigReader.getProperty("zeroPassword"));

        // 5. Sign in tusuna basin
        zeroAppPage.signinButonu2.click();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroAppPage.onlineBanking.click();
        zeroAppPage.payBills.click();
        // 7. “Purchase Foreign Currency” tusuna basin

        zeroAppPage.purchaseForeignCurrency.click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroAppPage.pcCurrencyDropdown);
        select.selectByValue("EUR");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualSecilmisOpsiyon=select.getFirstSelectedOption().getText();
        String expectedSecilecekOpsiyon="Eurozone (euro)";
        softAssert.assertEquals(actualSecilmisOpsiyon,expectedSecilecekOpsiyon ,"secilen opsiyon Euro");


        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        String [] dropdownElemenetleriArr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        };
        List<String> expecteDropdownElementleriList= Arrays.asList(dropdownElemenetleriArr);

        List<WebElement>dropdownElementleriList=select.getOptions();
        List<String>actualdropdownOpsiyonlariList=new ArrayList<>();
        for (WebElement each:dropdownElementleriList){
            actualdropdownOpsiyonlariList.add(each.getText());
        }
        softAssert.assertEquals(actualdropdownOpsiyonlariList,expecteDropdownElementleriList,"");

        softAssert.assertAll();
    }
}
