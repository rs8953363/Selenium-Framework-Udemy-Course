package FunctionalTesting.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        //To find the count the number of checkboxes, you need to find a locator common to all checkboxes.
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }
}
