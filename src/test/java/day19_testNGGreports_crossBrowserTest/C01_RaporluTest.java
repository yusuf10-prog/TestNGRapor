package day19_testNGGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_RaporluTest {
    @Test
    public void nutellaTesti(){
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // url'in amazon icerdigini test edelim
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // aranacak kilemiyi aratalim

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime"));

    }
}
