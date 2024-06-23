package day16_testNG_framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    @Test
    public void nutellaTesti(){


        // amazona gidelim

        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapalim

        AmazonPage amazazonPage=new AmazonPage();
        amazazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edelim
        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


        // driver'i kapatalim

        Driver.closeDriver();

    }
}
