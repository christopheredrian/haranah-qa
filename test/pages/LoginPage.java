package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author chris
 */
public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    @FindBy(how = How.LINK_TEXT, using = "Login") 
    private WebElement loginBtn;
    @FindBy(how = How.NAME, using = "email") 
    private WebElement email;
    @FindBy(how = How.NAME, using = "password") 
    private WebElement password;
    
    /**
     * Click the login button
     */
    public void login(){
        email.submit();
    }
    
    /**
     * Set email for form
     * @param e string to set
     */
    public void setEmail(String e){
        email.sendKeys(e);
    }
    
    /**
     * Set password for form
     * @param p 
     */
    public void setPassword(String p){
        password.sendKeys(p);
    }
    
}
