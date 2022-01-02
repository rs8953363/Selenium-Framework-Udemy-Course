package Sec7SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assertions {
    public static void main(String[] args) throws InterruptedException {
        //TestNG is one of the testing framework. Assertions help us to validate is the result that Selenium return is
        // expected or not. If it's same as expected it passes. Otherwise, it fails.
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //This method expects it the argument to be false
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //Assert.assertFalse(false);
        //Assert.assertFalse(true); This step is going to fail
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        for (int i = 1; i <5 ; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
            driver.findElement(By.id("btnclosepaxoption")).click();
            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        }
    }

