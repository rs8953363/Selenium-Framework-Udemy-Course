package Sec8FunctionalTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.function.*;

public class FluentWaitTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                } else
                    return null;
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
    }
}
