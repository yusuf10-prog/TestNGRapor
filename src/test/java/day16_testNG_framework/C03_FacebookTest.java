package day16_testNG_framework;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_FacebookTest {
    @Test
    public void facebookTesti(){
        //1 - https://www.facebook.com/ adresine gidin

        Driver.getDriver().get("https://www.facebook.com");
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin


        Faker faker=new Faker();
        FacebookPage facebookPage=new FacebookPage();


        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginKutusu.click();


        //4- Basarili giris yapilamadigini test edin


    }
}
