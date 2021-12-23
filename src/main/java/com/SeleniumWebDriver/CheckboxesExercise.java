package com.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxesExercise {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")).getSize());

        }
    }

