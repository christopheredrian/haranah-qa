package tests.buyers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.buyers.BuyerHomePage;

/**
 *
 * @author chris
 */
public class BuyerLoginTest {

    private WebDriver driver;

    public BuyerLoginTest() {
    }

    @Before
    public void setUp() {
        driver = DriverInstance.getInstance();
    }

    @Test
    public void login() {
        // Go to root 
        driver.get("http://localhost:8000");
        // Click the login button
        driver.findElement(By.linkText("Login")).click();

        // Login Page
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setEmail("buyer1@gmail.com");
        loginPage.setPassword("password");
        loginPage.login();
        WebElement header = driver.findElement(By.cssSelector("h3"));
        assertEquals("HARANAH PHITEX", header.getText());
        driver.close();
    }

    /**
     * Test with invalid email and password
     */
    @Test
    public void loginInvalidCredentials() {
        driver.get("http://localhost:8000");
        // Click the Login Button
        driver.findElement(By.linkText("Login")).click();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setEmail("buy1@gmail.com");
        loginPage.setPassword("failedpassword");
        loginPage.login();
        BuyerHomePage buyerHomePage = PageFactory.initElements(driver, BuyerHomePage.class);
        assertEquals("Invalid Credentials!", buyerHomePage.getHeader());
        driver.close();
    }
}
