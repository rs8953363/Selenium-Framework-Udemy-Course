package Sec13SeleniumWebDriver;

//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
//
//public class SoftAssertions {
//    public static void main(String[] args) throws IOException {
//        System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//
//        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gi-li'] a"));
//        SoftAssert a = new SoftAssert();
//
//        for (WebElement link: links){
//
//            String url = link.getAttribute("href");
//            HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
//            conn.setRequestMethod("HEAD");
//            conn.connect();
//            int respCode = conn.getResponseCode();
//            System.out.println(respCode);
//            //Assert.assertTrue(condition, message);
//            //The following is soft assert. YOu can use it instead if if condition
//            a.assertTrue(respCode<400, "The link with Text " +link.getText()+ " is broken with code " +respCode);
//            }
//        a.assertAll();//This is for all failed links to be reported. If you don't put assertAll, it'll catch all failures,
//        // but it won't report them. It needs to be outside of the for loop
//        }
//    }

import java.io.IOException;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLConnection;
        import java.util.List;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.asserts.SoftAssert;

public class SoftAssertions {
    public static void main(String[] args) throws MalformedURLException, IOException {


        System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        SoftAssert a = new SoftAssert();


        for (WebElement link : links) {


            String url = link.getAttribute("href");


            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("HEAD");

            conn.connect();

            int respCode = conn.getResponseCode();

            System.out.println(respCode);

            a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode);
        }
        //a.assertAll();
    }
}