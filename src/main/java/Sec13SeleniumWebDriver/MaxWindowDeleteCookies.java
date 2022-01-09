package Sec13SeleniumWebDriver;

import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

public class MaxWindowDeleteCookies {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize your browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("sessionKey");

        //If you delete session ID cookie your session should log out.
        // Int Q: How to delete the session cookie and make sure secure login gets log out and it has to navigate to the
        // homepage. How do you automate that? Answer: I'll delete that cookie. After deleting it, if you click on
        // anything on your website it should automatically brings you to the login.

        //click on any link. Then you will be redirected to login page - verify login page

        driver.get("http://google.com");

        //To take screenshot, you have to convert your WebDriver object into screenshot object(Cast driver object)
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\Admin\\screenshot.png"));//Provide a pathway where you want
        // file to be saved.
        //FileUtils is a method to copy the file from source object(src) to our local machine.
        //System will not allow to create
        // anything in C drive as it's secure. You have to be admin to create or delete something inside.So it's better
        // to change the drive/directory.If you don't have any drive other than C drive, put it in Users folder
        //To download a FileUtils jar file, please go to https://commons.apache.org/proper/commons-io/download_io.cgi
        //click on commons-io-2.11.0-bin.zip file, download and unzip and add to yuor project.
        //Project structure-->Modules-->Dependencies--> Click plus sign--> select add external jars--> Find the files
        // you unzipped-->click OK


    }
}
