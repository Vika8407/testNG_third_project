package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaCarsPage;
import utilities.TestData;
import utilities.Waiter;
import utilities.WindowHandler;

import java.util.stream.IntStream;

public class CarvanaCarsTest extends CarvanaBase{

    @BeforeMethod
    public void setPage(){
        carvanaCarsPage = new CarvanaCarsPage();
        Waiter.pause(2);
        carvanaCarsPage.searchButton.click();
        WindowHandler.switchToChildWindow();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/cars");
    }

    /**
     * Test Case 5: Test name = Validate the search filter options and search button
     * Test priority = 5
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * And user should see filter options
     * |PAYMENT & PRICE      |
     * |MAKE & MODEL      |
     * |BODY TYPE |
     * |YEAR & MILEAGE      |
     * |FEATURES      |
     * |MORE FILTERS |
     */

    @Test(priority = 1, description = "Validate the search filter options and search button")
    public void validateSearchFilterOptions(){
        IntStream.range(0, carvanaCarsPage.filters.size()).forEach
                (i -> Assert.assertTrue(carvanaCarsPage.filters.get(i).isDisplayed()));
    }

    /**
     * Test Case 6: Test name = Validate the search result tiles
     * Test priority = 6
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * When user enters "mercedes-benz" to the search input box
     * And user clicks on "GO" button in the search input box
     * Then user should see "mercedes-benz" in the url
     * And validate each result tile
     * VALIDATION OF EACH TILE INCLUDES BELOW
     * Make sure each result tile is displayed with below information
     * 1. an image
     * 2. add to favorite button
     * 3. tile body
     *
     * ALSO VALIDATE EACH TILE BODY:
     * Make sure each tile body has below information
     * 1. Inventory type - text should be displayed and should not be null or empty
     * 2. Year-Make-Model information - text should be displayed and should not be null or empty
     * 3. Trim-Mileage information - text should be displayed and should not be null or empty
     * 4. Price - Make sure that each price is more than zero
     * 5. Monthly Payment information - text should be displayed and should not be null or empty
     * 6. Down Payment information - text should be displayed and should not be null or empty
     * 7. Delivery chip must be displayed, and text is not null or empty
     */

    @Test(priority = 2,description = "Validate the search result tiles")
    public void validateSearchResultTitles(){

        carvanaCarsPage.searchInput.sendKeys(TestData.cars);

        Waiter.waitForElementTobeClickable(carvanaCarsPage.goButton,5);
        carvanaCarsPage.goButton.click();

        Waiter.waitUntilUrlIs("mercedes-benz",10);

        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        String priceResult;
        for (int i = 0; i < carvanaCarsPage.images.size(); i++) {
            Assert.assertTrue(carvanaCarsPage.images.get(i).isDisplayed());

            Assert.assertTrue(carvanaCarsPage.favoriteButton.get(i).isDisplayed());

            Assert.assertTrue(carvanaCarsPage.inventoryType.get(i).isDisplayed());
            Assert.assertFalse(carvanaCarsPage.inventoryType.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaCarsPage.yearMakeModel.get(i).isDisplayed());
            Assert.assertFalse(carvanaCarsPage.yearMakeModel.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaCarsPage.trimMileage.get(i).isDisplayed());
            Assert.assertFalse(carvanaCarsPage.trimMileage.get(i).getText().isEmpty());

            priceResult = carvanaCarsPage.price.get(i).getText();
            priceResult = priceResult.replaceAll("[^0-9]","");
            Assert.assertTrue(Integer.parseInt(priceResult) > 0);

            Assert.assertTrue(carvanaCarsPage.monthlyPayment.get(i).isDisplayed());
            Assert.assertFalse(carvanaCarsPage.monthlyPayment.get(i).getText().isEmpty());

            Assert.assertTrue(carvanaCarsPage.downPayment.get(i).isDisplayed());
            Assert.assertFalse(carvanaCarsPage.downPayment.get(i).getText().isEmpty());
            Assert.assertTrue(carvanaCarsPage.delivery.get(i).isDisplayed());
            Assert.assertFalse(carvanaCarsPage.delivery.get(i).getText().isEmpty());
        }
    }


}
