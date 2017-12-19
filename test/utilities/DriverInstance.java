package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInstance {
//    private static WebDriver instance = null;

    public static WebDriver getInstance (){
       
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "/lib/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}
