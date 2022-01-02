package Sec7SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertWindows {
    public static void main(String[] args) {

        String text = "Rahul";
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);
        //You can type the above line like this below
//        driver.findElement(By.cssSelector("[id='name']")).click();
//        driver.findElement(By.xpath("//[@id='name']")).click();

        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
       //Switch to alert mode
        System.out.println(driver.switchTo().alert().getText());
        //accept method is for clicking the OK button
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        //To see what the alert window shows
        System.out.println(driver.switchTo().alert().getText());
        //For negative actions like Cancel or no, use the dismiss method
        driver.switchTo().alert().dismiss();
    }
}
