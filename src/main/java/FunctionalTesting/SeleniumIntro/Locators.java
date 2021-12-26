package FunctionalTesting.SeleniumIntro;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //implicit wait for line 22--> gives 5 secs wait time
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        //When you class attribute, you just write on eof the class names although there is two.
        driver.findElement(By.className("signInBtn")).click();
        //CSS selector: 1st way: tagname.classname --> p.error
        //2nd wy: tagname#id --> p#error
        //3rd way: tagname[attribute='value'] --> p[class='error']
        //p[class='error']
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        //By Link Text
        driver.findElement(By.linkText("Forgot your password?")).click();
        //This app is a single web app. When you clcik forgot pasword it enters email, name, phone number but since the
        // sliding window moves from right to let it cnnnot click on the reset login button. The error is called:
        // ElementClickInterceptedException. In order to fix this issue, we need to add wait time.
        // Time should be in miliseconds. Please see line 28.
        // Int Q: Probably when the application is changing from one state to another we might have this issue.
        // So we need to wait until it's stable.
        Thread.sleep(2000); //You can also use explicit wait instead of this. Thread.sleep is not very recommended
        //XPath: //tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        //CSS Selector: tagname[attribute='value']
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

        //Index method:
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("doe@rsa.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("judy@gmail.com");

//driver.findElement(By.xpath("//input[@'text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
        //form/h2
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9836459060");
        //click button
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        //instead of searching password you can use type*='pass'
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
    }
}
