package Sec10AjaxCallsChildWindowsIFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

public class WindowHandlingAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

//        Actions a = new Actions(driver);
//        WebElement move = driver.findElement(By.xpath("//a[contains(text(), 'Multiple Windows')]"));
//        a.moveToElement(move).build().perform();
//
//        driver.findElement(By.xpath("//a[@target='_blank']")).click();
//        Set<String> windows = driver.getWindowHandles();
//
//        Iterator<String> it = windows.iterator();
//        String parentWindow = it.next();
//        driver.switchTo().window(it.next());
//        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
//        driver.switchTo().window(parentWindow);
//        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());

        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.cssSelector("a[href*='windows']")).click();
        Set<String> abc=driver.getWindowHandles();
        Iterator<String> it=abc.iterator();
        String parentWindow=it.next();

        driver.switchTo().window(it.next());
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
    }
}



