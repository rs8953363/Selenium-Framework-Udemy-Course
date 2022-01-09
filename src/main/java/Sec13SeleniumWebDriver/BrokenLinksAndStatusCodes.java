package Sec13SeleniumWebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class BrokenLinksAndStatusCodes {
    public static void main(String[] args) throws MalformedURLException, IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Broken links means, the URL that tied up to the link is not working. If you see any status code greater than
        // 400, it means it's a broken link. The 200 and 300 ones work fine. 404 error mens there is something wrong with URL
        //Int Q: How to identify broken links?
        // Step 1: get URLs the tied up to the links using Selenium. getAttribute("href") I scan all the links by using Selenium.
        // I use Java methods will call the URLs and get you the status codes of URLs instea of manually checking them.
        // If status code is >400 then the link is broken.

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        //will give us complete URL of that link
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int respCode = conn.getResponseCode();
        System.out.println(respCode);

        String url2 = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        //will give us complete URL of that link
        HttpURLConnection conn2 = (HttpURLConnection) new URL(url2).openConnection();
        conn2.setRequestMethod("HEAD");
        conn2.connect();
        int respCode2 = conn2.getResponseCode();
        System.out.println(respCode2);


    }
}
