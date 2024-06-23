package tests.day19_testNGreports_crossBrowserTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_QualitiyDemyCokluNegatifTesti {

    @DataProvider
    public static Object[][] gecersizKullaniciListesi(){
        String [][] gecersizKullaniciBilgileri={{"Ahmet","12345"}};
        return gecersizKullaniciBilgileri;
    }
    @Test(dataProvider = "gecersizKullaniciListesi")
    public void cokluNegatifTest(String username, String password){
        // qualitydemy anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        // ilk login linkine tiklayin

        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();



        // verilen geceersiz kullanici adi ve şifreleri listesindeki

        // 5 isim ve şifre

        qualitydemyPage.emailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());


        // sayfayi kapatin

        Driver.closeDriver();

    }
}
