package Sec10AjaxCallsChildWindowsIFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class FramesAssignment {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");

            driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
            driver.switchTo().frame("frame-top");
            driver.switchTo().frame("frame-middle");
            System.out.println(driver.findElement(By.id("content")).getText());
        }
    }

