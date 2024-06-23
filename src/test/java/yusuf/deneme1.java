package yusuf;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.security.Key;


public class deneme1 {


    @Test
    public void login() throws AWTException {

        Robot robot=new Robot();

        Driver.getDriver().get(ConfigReader.getProperty("smartCartLink"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("window.scrollTo(0, 0)");
        HomePage homePage = new HomePage();
        //ReusableMethods.bekle(2);
        homePage.singButton.sendKeys(Keys.ENTER);
        homePage.email.sendKeys(ConfigReader.getProperty("userMail"));
        homePage.password.sendKeys(ConfigReader.getProperty("userSifre"));
        homePage.loginButton.click();

        UserDashboard userDashboard = new UserDashboard();
        // sanal kartin olduğu ekrana giris
        userDashboard.sanalKartArkaPlan.click();
        ReusableMethods.bekle(3);

        //sanal kartın arka planini secme
        userDashboard.sanalKartArkaYuz.click();
        userDashboard.kayitliKullaniciSecme.click();

        // kullanıcı seçme islemi yapıldı.
        Select isimSecme = new Select(userDashboard.kullaniciIsmiSecme);
        isimSecme.selectByIndex(1);
        isimSecme.getFirstSelectedOption().click();

        //soru isareti üzerinde bekleme yapıp uyarı yazisi çıkarildi.
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);
        actions.click(userDashboard.soruIsareti).perform();
        ReusableMethods.bekle(3);


        // Dosya yükleme işlemi
        userDashboard.fotoSecme.click();

        Point point = MouseInfo.getPointerInfo().getLocation();
        int x = (int) point.getX();
        int y = (int) point.getY();
        System.out.println("Mouse coordinates: " + x + ", " + y);


        ReusableMethods.bekle(5);
        Point point1 = new Point(196,192);

        robot.mouseMove(point1.x, point1.y); // Farenin konumunu ayarla
        ReusableMethods.bekle(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.bekle(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak

        ReusableMethods.bekle(10);


        // fare foto seçme islemini yapar.
        Point point2 = new Point(421,116);// C: araba çubuğu koordinatı

        robot.mouseMove(point2.x, point2.y); // Farenin konumunu ayarla
        ReusableMethods.bekle(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.bekle(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.bekle(1);

        //aç butanuna tıklama işlemi

        Point point4 = new Point(1108,669);// aç butonu koordinatı
        robot.mouseMove(point4.x, point4.y); // Farenin konumunu ayarla
        ReusableMethods.bekle(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.bekle(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.bekle(1);



        userDashboard.isimText.sendKeys(ConfigReader.getProperty("userKartArkaYuzIsim"));
        userDashboard.soyadiText.sendKeys(ConfigReader.getProperty("userArkaYuzSoyadi"));
        userDashboard.mailAdresi.sendKeys(ConfigReader.getProperty("userMailAdresi"));
        userDashboard.meslek.sendKeys(ConfigReader.getProperty("userMeslek"));
        userDashboard.adres.sendKeys(ConfigReader.getProperty("userAdres"));
        userDashboard.telefonNumarasi.sendKeys(ConfigReader.getProperty("userTelefonNumarasi"));
        userDashboard.siteGirisi.sendKeys(ConfigReader.getProperty("userSiteGirisi"));

        userDashboard.kaydetButton.sendKeys(Keys.ENTER);

        ReusableMethods.bekle(10);

        Driver.closeDriver();
    }
}




