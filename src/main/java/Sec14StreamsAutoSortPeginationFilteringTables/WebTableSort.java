package Sec14StreamsAutoSortPeginationFilteringTables;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.*;

import javax.security.sasl.*;
import java.util.*;
import java.util.stream.*;

public class WebTableSort {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on column,
        driver.findElement(By.xpath("//tr/th[1]")).click();
        // capture all webelements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        // capture text of all webelements into new(original) list
        List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        // sort in the original list -->sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));


    }
}
