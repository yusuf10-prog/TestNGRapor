package day16_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverClassKullanimi {
    @Test
    public void amazonTest(){

        // amazon'a gidelim

        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapalım

        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        // sayfayi kapatin
        Driver.closeDriver();

    }

    @Test
    public void youtubeTesti(){
        Driver.getDriver().get("https://www.youtube.com");
        Driver.closeDriver();
    }
}
