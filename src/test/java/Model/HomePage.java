package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.ArrayList;

import Model.Item;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    public HomePage(WebDriver webDriver) {

    }

    public void search(String searchItem) {

        //Arrange
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://web-playground.ultralesson.com/search?q=cigar&options%5Bprefix%5D=last");
        WebElement searchButton = webDriver.findElement(By.xpath("/html/body/main/section/div/div[1]/div/predictive-search/form/div/button"));
        WebElement searchResults = webDriver.findElement(By.xpath("/html/body/main/section/div/div[3]/div/ul"));
        WebElement productName = webDriver.findElement(By.xpath("/html/body/main/section/div/div[3]/div/ul/li[3]/div/div[1]/div/h3/a"));
        WebElement searchBar = webDriver.findElement(By.xpath("/html/body/main/section/div/div[1]/div/predictive-search/form/div/input[1]"));

        //Actions
        searchBar.sendKeys("pants");
        searchButton.click();

    }

    public List<Item> getSearchItems() {
        return new ArrayList<Item>();
    }
}
