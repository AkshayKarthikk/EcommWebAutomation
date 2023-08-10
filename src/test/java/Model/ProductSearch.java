import org.junit.jupiter.api.Test;

public class ProductSearch {
    @Test
    public void verifyIfSearchTermShowsRelevantResults() {

        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";
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
}
