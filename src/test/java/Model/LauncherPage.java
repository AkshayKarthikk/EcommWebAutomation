package Model;

import org.openqa.selenium.WebDriver;
public class LauncherPage {
    public LauncherPage(WebDriver webDriver) {
        webDriver.get("https://web-playground.ultralesson.com/search?q=cigar&options%5Bprefix%5D=last");
    }
    public void navigateTo(String url) {
    }
}
