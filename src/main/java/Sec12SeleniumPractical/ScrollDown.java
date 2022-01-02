package Sec12SeleniumPractical;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.*;

import java.util.*;

public class ScrollDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//Selenium does not provide any scrolling techniques by default. So, you should use JavaScript
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            Integer.parseInt(values.get(i).getText());//Convert String to Integer.
            System.out.println(Integer.parseInt(values.get(i).getText()));
            sum = sum+ Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        driver.findElement(By.cssSelector(".totalAmount")).getText();
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

        Assert.assertEquals(sum, total);//If it works, then the test passes, otherwise you can see error message in the
        // console.
        }
    }

