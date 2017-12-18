/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyers.authentication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import main.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author chris
 */
public class BuyerLogin {

    private WebDriver driver;

    public BuyerLogin() {
    }

    @Before
    public void setUp() {
        driver = DriverInstance.getInstance();
    }

    @Test
    public void login() {
        driver.get("http://localhost:8000");
        // Click the Login Button
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).sendKeys("buyer1@gmail.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("password")).submit();
        WebElement header = driver.findElement(By.cssSelector("h3"));
        assertEquals("HARANAH PHITEX", header.getText());
        driver.close();
    }

    @Test
    public void loginInvalidCredentials() {
        driver.get("http://localhost:8000");
        // Click the Login Button
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).sendKeys("xyz@gmail.com");
        driver.findElement(By.name("password")).sendKeys("xyz");
        driver.findElement(By.name("password")).submit();
        String invalidCredentialsText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        assertEquals("Invalid Credentials!", invalidCredentialsText);
    }
}
