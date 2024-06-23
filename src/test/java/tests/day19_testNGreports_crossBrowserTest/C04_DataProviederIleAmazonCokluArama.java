package tests.day19_testNGreports_crossBrowserTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_DataProviederIleAmazonCokluArama {

    @DataProvider
    public static Object[][] urunListesi() {
        String [][] aranacakUrunler={{"Nutella"},{"Java"},{"Armut"},{"elma"},{"Erik"},{"Malatya"}};
        return aranacakUrunler;
    }

    @Test(dataProvider = "urunListesi")
    public void amazonCokluAramaTeste() {
        /*

        public void amazonCokluAramaTesti (String urun){
            // amazon anasayfaya gidin
            Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
            // verilen listedeki her bir urun icin arama yaptirin
            // her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin
            AmazonPage amazonPage = new AmazonPage();
            String aramaSonucu;
            String[] aramaSonucKelimeleri;
            String aramasonucSayisiStr;
            int aramaSonucSayisiInt;

            amazonPage.aramaKutusu.clear();
            amazonPage.aramaKutusu.sendKeys(urun + Keys.ENTER);
            aramaSonucu = amazonPage.sonucYaziElementi.getText();
            aramaSonucKelimeleri = aramaSonucu.split(" ");
            if (aramaSonucKelimeleri[2].equals("over")) {
                aramasonucSayisiStr = aramaSonucKelimeleri[3];
            } else {
                aramasonucSayisiStr = aramaSonucKelimeleri[2];
            }
            aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D", "");
            aramaSonucSayisiInt = Integer.parseInt(aramasonucSayisiStr);
            Assert.assertTrue(aramaSonucSayisiInt > 100);

        }

         */
    }
}
