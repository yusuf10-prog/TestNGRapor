package day17_testNGFramaWork;

import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_QualitydemiyPozitifLoginTesti {
    @Test
    public void pozitifLoginTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
    }
}
