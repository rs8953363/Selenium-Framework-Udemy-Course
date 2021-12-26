package FunctionalTesting.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);

        //driver.findElement(By.id("hrefIncAdt")).click();//2 adults
        //If you want to select 4 adults from the dropown, you need to type the above line three more times, but it's
        // not efficient. Here is a more efficient way. You need to write a loop for that.
        // driver.findElement(By.id("hrefIncAdt")).click();
        // driver.findElement(By.id("hrefIncAdt")).click();
        // driver.findElement(By.id("hrefIncAdt")).click();
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();//4 times
            i++;
        }
            //For loop solution
//        for (int i = 1; i <5 ; i++) {
//            driver.findElement(By.id("hrefIncAdt")).click();
//        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        }
    }
