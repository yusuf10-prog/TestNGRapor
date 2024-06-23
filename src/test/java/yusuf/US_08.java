package yusuf;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboard;
import utilities.*;

import java.util.List;
import java.util.Set;

public class US_08 {
    @Test
    public void Vcard() throws InterruptedException {


        Driver.getDriver().get(ConfigReader.getProperty("smartCartLink"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, 0)");

        HomePage homePage=new HomePage();
        ReusableMethods.bekle(2);
        homePage.singButton.click();
        homePage.email.sendKeys(ConfigReader.getProperty("userMail"));
        homePage.password.sendKeys(ConfigReader.getProperty("userSifre"));
        homePage.loginButton.click();

        //Dashboard yasının görünürlüğü kontrol eder.
        UserDashboard userDashboard=new UserDashboard();

        String expectedEkranYazisi="Dashboard";
        String actualEkranYazisi=userDashboard.yaziGoruntusu.getText();

        Assert.assertTrue(expectedEkranYazisi.contains(actualEkranYazisi));


        // yeni kart ekleme ekranını acar
        userDashboard.VCardsButton.click();
        ReusableMethods.bekle(1);

        // yeni kart kaydetme ekrani
        userDashboard.newCardButton.sendKeys(Keys.ENTER);
        ReusableMethods.bekle(1);

        // soru işaretinde çıkan yazının görüntülenmesi

        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);
        actions.click(userDashboard.questionMark).perform();

        //Takma ad alma url nin yanindaki yazinin cikmasinin ve kontrolü yapılır.

        String expectedSoruIsaretiYazisi="The main URL that your vcard is going to be able accessed from.";
        String actualSoruIsaretiYazisi=Driver.getDriver().switchTo().activeElement().getText();

       Assert.assertTrue(actualSoruIsaretiYazisi.contains(expectedSoruIsaretiYazisi));

       //Oklari dondurme islemi yapar.
        userDashboard.arrowsRotateButton.click();

        // yazinin gorunur olması halinde true degeri dondurur. Burası olmadı incelenecek.
        System.out.println(userDashboard.uniqueCode.getText().isBlank());

        // Vcard ismi girilir
        userDashboard.VCardName.sendKeys(ConfigReader.getProperty("vcardIsmi"));

        //Occupation: meslek girilir.
        userDashboard.occupationText.sendKeys(ConfigReader.getProperty("occupationMeslek"));

        // acıklama alanına giris yapılır.
        userDashboard.DescriptionText.sendKeys("DescriptionAciklama");

        // kaydemte işlemi yapılır.
        userDashboard.saveButton.submit();

        //Kart kaydetme basarili
        Assert.assertTrue(userDashboard.basariliGiris.isDisplayed());

        // Kaydetme ekranından geri gelinir.
        userDashboard.backButton.click();

        //Tabloyu görüntüleme ve yazdırma işlemi

        Select select=new Select(userDashboard.tableShow);
        ReusableMethods.bekle(1);
        select.selectByValue("10");
        ReusableMethods.bekle(2);
        select.selectByValue("25");
        ReusableMethods.bekle(2);
        select.selectByValue("50");
        ReusableMethods.bekle(2);
        List<WebElement> satirlarListesi1= userDashboard.tableShow.findElements(By.xpath("//tbody/tr"));

        for (int i = 0; i <satirlarListesi1.size() ; i++) {
            System.out.println((i+1) +".ci satir : " +satirlarListesi1.get(i).getText());

        }

        WebElement result=userDashboard.sonucYazisi;

        System.out.println("Rapor :"+result.getText());

        // kullanıcı ismi secilir. Aktiflik durumu dogrulanir.
        userDashboard.vcardNameActive.sendKeys(Keys.ENTER);
        ReusableMethods.bekle(1);
        String expectedIcerik="Edit VCard";
        String actualIcerik=userDashboard.editVcardEkrani.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        ReusableMethods.bekle(2);
        userDashboard.backButton.sendKeys(Keys.ENTER);

        //url in aktiflik durumu
        userDashboard.urlSelect.click();
        Assert.assertTrue(userDashboard.urlSelect.isEnabled());
        userDashboard.urlSelect.sendKeys(Keys.PAUSE);

        String ilkSayfaWhd= Driver.getDriver().getWindowHandle();

        Set<String> whdSeti=Driver.getDriver().getWindowHandles();

        String ikinciSayfaWhd="";
        for (String each:whdSeti
        ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }
        ReusableMethods.bekle(1);

        Driver.getDriver().switchTo().window(ikinciSayfaWhd);
        Driver.getDriver().switchTo().window(ilkSayfaWhd);

        // kopyalama iconu aktiflik durumu
        ReusableMethods.bekle(2);

        userDashboard.copyIcon.click();
        ReusableMethods.bekle(10);
        Assert.assertTrue(userDashboard.copyIcon.isEnabled());


        //istatistik ıconu secimi ve aktiflik
        userDashboard.statsIcon.click();
        String expectedStats="Overview";
        String actualStats=userDashboard.statsIcon.getText();
        Assert.assertTrue(expectedStats.contains(actualStats));


        // İstatistik butonuna tiklar
        userDashboard.statsDogrulama.click();

        //Vcard Analytic ekranindan geri dönme islemi yapilir.

        userDashboard.geriDonus.click();

        userDashboard.checkBox.click();
        ReusableMethods.bekle(10);

        userDashboard.kareKod.click();
        Assert.assertTrue(userDashboard.kareKod.isDisplayed());
        ReusableMethods.bekle(1);

        // indirme islemi yapar
        userDashboard.dowloand.click();
        Assert.assertTrue(userDashboard.dowloand.isDisplayed());

        // Enquiries butonuna tıklar ve geri dönüs yapar
        userDashboard.enquiriesButton.click();
        String expectedEkran="Enquiries";
        String actualEkran=userDashboard.enquiriesEkrani.getText();
        Assert.assertTrue(actualEkran.contains(expectedEkran));
        ReusableMethods.bekle(2);
        userDashboard.geriDonus.click();

        //iki defa kopyalama işlemi yapar.
        ReusableMethods.bekle(1);
        userDashboard.copyTwo.click();
        userDashboard.yesButton.click();
        ReusableMethods.bekle(2);

        // edit butonuna tıklama
        userDashboard.editButton.click();

        ReusableMethods.bekle(2);
        String expectedEdit="Basic Details";
        String actualEdit=userDashboard.editButtonDogrula.getText();
        Assert.assertTrue(expectedEdit.contains(actualEdit));
        userDashboard.editGeriButton.click();
        ReusableMethods.bekle(3);

        // silme işlemi yapılır.
        userDashboard.copKutusu.click();
        ReusableMethods.bekle(2);
        userDashboard.silmeOnay.click();

        ReusableMethods.bekle(10);
        Driver.closeDriver();
    }
}
