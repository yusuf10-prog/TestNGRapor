package yusuf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class deneme{
    @Test
    public void test01() throws IOException {
        System.setProperty("Webdriver.chrome.driver", "chromedriver");
        WebDriver driver=null;
        driver=new ChromeDriver();

        driver.get("http://seleniumhq.org");

        WebElement resim= driver.findElement(By.cssSelector("img[alt='Perfecto']"));
        String resimSrc=resim.getAttribute("src");

        URL resimURL=new URL(resimSrc);
        BufferedImage resmiKaydet= ImageIO.read(resimURL);
        ImageIO.write(resmiKaydet,"png", new File("selenium-logosu.png"));
        driver.quit();
    }

}
