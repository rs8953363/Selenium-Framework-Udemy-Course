package AjaxCallsChildWindowsIFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;

import java.util.*;

public class WindowHandlingAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("//a[contains(text(), 'Multiple Windows')]"));
        a.moveToElement(move).build().perform();

        driver.findElement(By.cssSelector("//a[contains(text(), 'Click Here')]")).click();
        Set<String> windows = driver.getWindowHandles();

        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.cssSelector("//a[contains(text(), 'Click Here')]")).click();




    }
}
