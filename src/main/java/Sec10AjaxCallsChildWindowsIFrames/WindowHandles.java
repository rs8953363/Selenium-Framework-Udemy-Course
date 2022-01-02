package Sec10AjaxCallsChildWindowsIFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

public class WindowHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

        //Opening a new tab or window are considered same in Selenium, but you need to let Selenium know that you opened
        // a new tab or window. [parentId, childId, subchildId]. The new window that's opened is considered child.

        Set<String> windows = driver.getWindowHandles(); //Now we have two windows; a parent and a child.
        //We need to get the email adress from child window and come back to parent window and paste it to the email
        // box. So we need to switch to child window. driver.switchTo().window(arg0)

        Iterator<String> it = windows.iterator();//This is to extract the values from set collection
        String parentId = it.next();//this line is for grabbing parentId (0th index)
        String childId = it.next(); //This is for child window (1st index)
        //it.next(); This will take you to the third window. But, you usually don't have more than two windows.

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        driver.findElement(By.cssSelector(".im-para.red")).getText();

        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
