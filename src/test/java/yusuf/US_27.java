package yusuf;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_27 {

    @Test
    public void ortalikEkrani(){
        Driver.getDriver().get(ConfigReader.getProperty("smartCartLink"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, 0)");
        HomePage homePage=new HomePage();
        ReusableMethods.bekle(2);
        homePage.singButton.click();
        homePage.email.sendKeys("admin04@smartcardlink.com");
        homePage.password.sendKeys("123123123");
        homePage.loginButton.click();

        // Affiliate Users alanına tıklar.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.ortaklikButton.click();

        //Tabloyu görüntüleme ve yazdırma işlemi yapar.

        Select select=new Select(adminDashboard.show);
        ReusableMethods.bekle(2);
        select.selectByValue("10");
        ReusableMethods.bekle(2);
        select.selectByValue("25");
        ReusableMethods.bekle(2);
        select.selectByValue("50");
        ReusableMethods.bekle(2);
        List<WebElement> satirlarListesi1= adminDashboard.show.findElements(By.xpath("//tbody/tr"));

        for (int i = 0; i <satirlarListesi1.size() ; i++) {
            System.out.println((i+1) +".ci satir : " +satirlarListesi1.get(i).getText());
        }

        // rapor sonucu gösterme
        WebElement result=adminDashboard.raporSonucu;
        ReusableMethods.bekle(5);

        System.out.println("");

        System.out.println("Affiliate Users Raporu :"+result.getText());

        System.out.println("");


        // kullanici bilgilerini doğrulama

        adminDashboard.kullaniciDogrulama.sendKeys(Keys.ENTER);
        String expectedIcerikUser="User Details";
        String actualIcerikUser=adminDashboard.userDetails.getText();
        Assert.assertTrue(expectedIcerikUser.contains(actualIcerikUser));

        // kullanici bilgileri dogrulama isleminden sonra geri dönme
        adminDashboard.backButton.click();

        // ortalık ekranında oldugumu dogrulama
        ReusableMethods.bekle(2);
        adminDashboard.uyelikButton.click();

        String expectedIcerik="Affiliate Users";
        String actualIcerik=adminDashboard.affiliateUsers.getText();

        Assert.assertTrue(expectedIcerik.contains(actualIcerik));


        //affiliation Transactions ekraninda tabloyu görüntüleme ve yazdırma işlemi yapar.

        Select select1=new Select(adminDashboard.show);
        ReusableMethods.bekle(2);
        select.selectByValue("10");
        ReusableMethods.bekle(2);
        select.selectByValue("25");
        ReusableMethods.bekle(2);
        select.selectByValue("50");
        ReusableMethods.bekle(2);
        List<WebElement> satirlarListesi2=
                adminDashboard.show.findElements(By.xpath("//tbody/tr"));

        for (int i = 0; i <satirlarListesi2.size() ; i++) {
            System.out.println((i+1) +".ci satir : " +satirlarListesi2.get(i).getText());

        }

        ReusableMethods.bekle(2);

        // rapor sonucu gösterme
        WebElement result1=adminDashboard.affiliationTransactionsRaporSonucu;
        ReusableMethods.bekle(55);



        System.out.println("Affiliation Transactions Raporu :"+result1.getText());

        // affiliation Transactions ekraninda kullanici doğrulama islemi yapılır.
        ReusableMethods.bekle(2);

        adminDashboard.kullaniciSecim.sendKeys(Keys.ENTER);
        ReusableMethods.bekle(2);

        String expectedIcerikDogrulama="Overview";
        String actualIcerikDogrulama=adminDashboard.kullaniciEkrani.getText();

        Assert.assertTrue(expectedIcerikDogrulama.contains(actualIcerikDogrulama));

        adminDashboard.geriDon.click();

        Driver.closeDriver();
    }
}
