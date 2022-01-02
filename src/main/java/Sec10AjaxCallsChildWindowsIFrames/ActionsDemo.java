package Sec10AjaxCallsChildWindowsIFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;

public class ActionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
                .doubleClick().build().perform();
        //Moves to specific element
        a.moveToElement(move).build().perform();
        //Right-click to an element
        a.moveToElement(move).contextClick().build().perform();
        //Drag and drop
    }
}
