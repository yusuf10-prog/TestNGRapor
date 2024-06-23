package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*
    JUnit'de WebDriver objesi TestBase'den geliyordu

    TestNG extends ile bağlanma zorunluulgunu ortadan kaldirmak
    ve testi yazanlara daha fazla kontrol imkani vermek için
    TestBase yerine Driver class'inda static 2 method ile
    driver olusturma ve kapatma işlemlerini yapmayi tercih etmiştir.
     */

    static WebDriver driver; // biz deger atamadiğimiz icin Java default olarak null point eder.

    public static WebDriver getDriver(){
       // WebDriverManager.chromedriver().setup();

        if (driver==null){
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;

    }
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }
}
