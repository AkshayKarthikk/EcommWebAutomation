package Model;

import Model.HomePage;
import Model.Item;
import Model.LauncherPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class ProductSearch {
    @Test
    public void verifyIfSearchTermShowsRelevantResults() {

        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";
        WebDriver webdriver=null;
        LauncherPage launcherPage = new LauncherPage(webdriver); // Assume webdriver is created and handy
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webdriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert
        Assertions.assertEquals(4, searchItems.size());
        Assertions.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));

    }
    @Test
    public void searchUnavailableItemTest(){

        //Arrange
        String searchItem = "Cigar";
//        String searchKey = "Cigar";
        WebDriver webdriver=null;
        LauncherPage launcherPage = new LauncherPage(webdriver); // Assume webdriver is created and handy
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webdriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert
        Assertions.assertEquals(1, searchItems.size());
        Assertions.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchItem)));
    }

    @Test
    public void searchItemsInABrandTest(){

        //Arrange
        String brandName = "Cigar";
//        String searchKey = "Cigar";
        WebDriver webdriver=null;
        LauncherPage launcherPage = new LauncherPage(webdriver); // Assume webdriver is created and handy
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webdriver);
        homepage.search(brandName);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert
        Assertions.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(brandName)));
    }

    @Test
    public void verifySearchResultCountMatchesDisplayedItems() {
        // Arrange
        String searchItem = "Shoes";
        WebDriver webDriver = null;

        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        // Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();
//        int itemCountDisplayed = homepage.getItemCount(); // Assume getItemCount method returns the number displayed on the page

        // Assert
//        Assert.assertEquals(searchItems.size(), itemCountDisplayed);
    }

}
