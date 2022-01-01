package AjaxCallsChildWindowsIFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;

public class FramesTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/");


        //driver.switchTo().frame(1); This shows the second index. You can write the above line like this, but it's not recommended. Because developer
        // can add one more frame.
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        //Frames are components hosted on a web application. Selenium cannot identify frames because they are independent.
        // You need to tell Selenium how to handle frames, otherwise it assumes frame is a part of HTML code. Frame
        // display content independent of its container. It has ability to load content independently.

        //driver.findElement(By.id("draggable")).click();

        //For drag and drop, you need to use Actions class
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggeble"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();
    }
}
