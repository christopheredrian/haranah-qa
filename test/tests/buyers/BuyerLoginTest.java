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
        loginPage.login("buyer1@gmail.com", "password");
        BuyerHomePage buyerHomePage = PageFactory.initElements(driver, BuyerHomePage.class);
        assertEquals("HARANAH PHITEX", buyerHomePage.getHeader());
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
        loginPage.login("buy1@gmal.com", "wrongpassword");
        assertEquals("Error message not equal", "Invalid Credentials!", loginPage.getErrorMessage());
        driver.close();
    }
}
