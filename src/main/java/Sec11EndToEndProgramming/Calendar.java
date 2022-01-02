package Sec11EndToEndProgramming;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

public class Calendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");
        //April 23
     //   driver.findElementByXPath(".//*[@id='travel_date']").click(); Check this line again.

        //while loop executes until condition is false.
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
                .contains("April")){
            //Clicks on the double arrow (>>) on the right-hand corner of the calendar
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }
        List<WebElement> dates = driver.findElements(By.className("day"));//if you use cssSelector, you should use .day

        //For calendar, grab common attribute, put in the list, iterate
        int count = driver.findElements(By.className("day")).size();

        for (int i = 0; i <count ; i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("23")){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }

    }
}
