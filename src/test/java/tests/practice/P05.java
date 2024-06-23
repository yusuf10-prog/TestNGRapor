package tests.practice;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class P05 {
    @Test
    public void AETest(){
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
    }
}
