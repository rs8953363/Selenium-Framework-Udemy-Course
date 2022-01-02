package Sec12SeleniumPractical;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class AutoCompleteDropdownAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("Uni");
        Thread.sleep(2000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
    }
}
