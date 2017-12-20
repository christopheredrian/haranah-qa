package pages.buyers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author chris
 */
public class BuyerHomePage {

    private final WebDriver driver;
    @FindBy(css = "h3")
    private WebElement header;

    public BuyerHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * Returns the header string
     * @return String of the header page
     */
    public String getHeader() {
        return header.getText();
    }

}
