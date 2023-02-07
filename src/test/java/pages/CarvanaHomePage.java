package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaHomePage extends CarvanaBasePage{

     public CarvanaHomePage(){
         super();
     }

     @FindBy(css = "div[data-qa='logo-wrapper'] svg")
     public WebElement logo;

     @FindBy(css = "div[data-qa='menu-wrapper']")
    public List<WebElement> mainHeaders;

     @FindBy(css = "div[data-qa='desktop-wrapper']>a")
    public WebElement signInButton;

     @FindBy(id = "email")
    public WebElement email;

    @FindBy(css = "button[data-testid='Button']")
    public WebElement continueButton;

     @FindBy(css = "button[data-testid='Button']")
    public WebElement password;

     @FindBy(css = "div[class*='error-banner__cC']")
    public WebElement errorMessage;






}
