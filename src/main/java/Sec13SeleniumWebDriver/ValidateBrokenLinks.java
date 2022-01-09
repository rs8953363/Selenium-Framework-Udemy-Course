package Sec13SeleniumWebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.*;
import org.testng.asserts.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class ValidateBrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gi-li'] a"));


        for (WebElement link: links){

            String url = link.getAttribute("href");
            HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            if (respCode>400){
                System.out.println("The link with Text " +link.getText()+ " is broken with code " +respCode);
                Assert.assertTrue(false);//It's called hard assertion, it'll stop your code when test fails. It
                // doesn't check the other broken links when it finds the first one.
            }
        }
    }
}
