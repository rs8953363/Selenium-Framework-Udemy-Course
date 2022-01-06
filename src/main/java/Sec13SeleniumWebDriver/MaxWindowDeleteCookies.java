package Sec13SeleniumWebDriver;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxWindowDeleteCookies {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        Webdriver driver = new ChromeDriver();

        //maximize your browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("sessionKey");

        //How to delete the session cookie and make sure secure login gets log out and it has to navigate to the homepage.
        //How do you automate that? Answer: I'll accelarate that cookie. After deleting it if you clcik on anything on
        // your website it should automatically brings you to the login.

        //click on any link. Then you will be redirected to login page - verify login page

        driver.get("http://google.com");
        


    }
}
