package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaCarsPage extends CarvanaBasePage{

    public CarvanaCarsPage(){
        super();
    }

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchButton;

    @FindBy(css = "div[data-qa= 'menu-flex']>button")
    public List<WebElement> filters;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInput;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "picture[data-qa='base-vehicle-image']")
    public List<WebElement> images;

    @FindBy(css = "svg[data-qa='favorite-icon']")
    public List<WebElement> favoriteButton;

    @FindBy(css = "div[data-qa='inventory-type-experiment']")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModel;

    @FindBy(css = "div[data-qa='trim-mileage']" )
    public List<WebElement> trimMileage;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> price;

    @FindBy(className = "down-payment")
    public List<WebElement> downPayment;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public List<WebElement> monthlyPayment;

    @FindBy(css = "div[class='tk-pane full-width']:nth-child(2)")
    public List<WebElement> delivery;




}
