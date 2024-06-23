package tests.day15_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C02_dependsOnMethods {
    // uc tane test method'u olusturun
    // 1- amazonTest : amazon anasayfaya gidip url'in amazon icerdigini test edin
    // 2- nutellaTest : Nutella icin arama yapip arama sonuclarini Nutella icerdigini test edelim
    // 3- ilkurunTesti : ilk urunu click yapip, urun isminin Nutella icerdigini test edin


    @Test(priority = 1)
    public void amazonTest(){
        Driver.getDriver().get("https://www.amazon.com");

        String expectedUrlIcerik="Amazon";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        String actualTitle=Driver.getDriver().getTitle();


    }

    @Test(dependsOnMethods = "amazonTest")
    public void nutellaTest(){

    }

    @Test(dependsOnMethods = "nutellaTest")
    public void ilkUrunTesti(){

    }
}
