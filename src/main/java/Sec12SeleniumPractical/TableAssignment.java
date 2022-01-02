package Sec12SeleniumPractical;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.*;

import java.util.*;

public class TableAssignment {
    public static void main(String[] args) throws InterruptedException {

                System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get("https://rahulshettyacademy.com/AutomationPractice/");

                WebElement table = driver.findElement(By.id("product"));
                System.out.println(table.findElements(By.tagName("tr")).size());
                System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

                List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

                System.out.println(secondRow.get(0).getText());
                System.out.println(secondRow.get(1).getText());
                System.out.println(secondRow.get(2).getText());
            }
        }