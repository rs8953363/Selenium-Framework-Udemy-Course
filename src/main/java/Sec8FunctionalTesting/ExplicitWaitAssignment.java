package Sec8FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");

        //My solution
//        WebDriverWait w = new WebDriverWait(driver, 4);
//        driver.findElement(By.xpath("//a[contains(text(), 'Click to load get data via Ajax!')]")).click();
//        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Click to load get data via Ajax!')]")));
//        System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());
//    }

        driver.findElement(By.cssSelector("a[href*='loadAjax']")).click();
        WebDriverWait d=new WebDriverWait(driver,20);
        d.until(ExpectedConditions.elementToBeClickable(By.id("results")));
        System.out.println(driver.findElement(By.id("results")).getText());
        //  System.out.println( driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());





            }

        }