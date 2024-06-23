package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_AmazonCokluArama {
    @Test
    public void amazonTopluArama(){

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // verilen listedeki her bir ürün icin arama yaptirin

        String [] aranacakUrunler={"Nutella","Java","Armut","elma","Erik","Malatya"};
        AmazonPage amazonPage=new AmazonPage();

        String aramaSonucu;
        String [] aramasonucuKelimeleri;
        String aramasonucuSayisiStr;
        int aramaSonucuSayisiInt;


        for (int i = 0; i <aranacakUrunler.length ; i++) {
            amazonPage.aramaKutusu.clear();
            amazonPage.aramaKutusu.sendKeys(aranacakUrunler[i] + Keys.ENTER);
            aramaSonucu=amazonPage.sonucYaziElementi.getText();
            aramasonucuKelimeleri=aramaSonucu.split(" ");

            if (aramasonucuKelimeleri[2].equals("over")){
                aramasonucuSayisiStr=aramasonucuKelimeleri[3];
            }else {
                aramasonucuSayisiStr=aramasonucuKelimeleri[2];
            }
            aramasonucuSayisiStr=aramasonucuSayisiStr.replaceAll("","");
            aramaSonucuSayisiInt=Integer.parseInt(aramasonucuSayisiStr);

            Assert.assertTrue(aramaSonucuSayisiInt>100);


        }


        // her ürün icin bulunan sonuc sayisinin 1000 'den fazla olduğunu test edin


    }
}
