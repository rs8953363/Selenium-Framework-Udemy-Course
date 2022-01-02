package Sec8FunctionalTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotel");
        driver.findElement(By.id("H-destination")).sendKeys("nyc");
        driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);
        //driver.findElement(By.id(("H-fromDate")).sendKeys(Keys.ENTER)); Check this later

        WebDriverWait d = new WebDriverWait(driver, 20);
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='resultsContainer']/section/article[1]")));
        //Thread.sleep(5000L);
        driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();
    }
}
