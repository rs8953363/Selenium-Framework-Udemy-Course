package com.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.nio.file.WatchEvent;

public class E2E {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='glsct100_mainContent_ddl_destinationStation1_CTNR'] // a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui.state-active")).click();

        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("it's enabled");
            Assert.assertTrue(false);
        }else{
            Assert.assertTrue(true);
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        d

    }
}
