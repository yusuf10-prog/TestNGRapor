package day17_testNGFramaWork;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ConfigurationKullanimi {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // parantezin icine
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        String expectedIcerik=ConfigReader.getProperty("amazonAranacakKelime");
        String actualIcerik=amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));


        Driver.closeDriver();

    }

}
