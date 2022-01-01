package EndToEndProgramming;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.json.*;

public class Scope {
    public static void main(String[] args) {

        //Find the number of links on the page. Hint: All links on a webpage have "a" as a tagName
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Find the number of links on the footer. Hint: Create a mini driver
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //Find the number of links on the footer's first column.
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/u1"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        //Click on each link in the column and check if the pages are opening






    }
}