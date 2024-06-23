package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class P02_BagimliTestler {
        /*
    Birbirine bağımlı testler oluşturun
    before ve after class ile setup ayaralarını yapın
    Birbirine bağlı testlerle
    önce wisequarter'a gidin
    wisequarter adresine gidebilirse oradan amazon.com adresine gitsin
    amazon.com adresine gidebilirse google adresine gitsin
    driver kapatsın

     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

        //driver=new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public static void wise(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
    }

    @Test(dependsOnMethods = "wise")
    public void amazon(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }

    @Test(dependsOnMethods = "amazon")
    public void google(){
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }
    @AfterClass
    public void tearDown(){
       Driver.closeDriver();
    }
}
