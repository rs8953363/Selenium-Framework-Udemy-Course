package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //implicit wait for line 22--> gives 5 secs wait time
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        //CSS selector: 1st way: tagname.classname --> p.error
        //2nd wy: tagname#id --> p#error
        //3rd way: tagname[attribute='value'] --> p[class='error']
        //p[class='error']
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        //By Link Text
        driver.findElement(By.linkText("Forgot your password?")).click();
        //XPath: //tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        //CSS Selector: tagname[attribute='value']
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
        //Index method:
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("doe@rsa.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("judy@gmail.com");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
        //form/h2
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9836459060");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
    }
}
