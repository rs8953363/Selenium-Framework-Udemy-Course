package Sec7SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2EAssignment {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");

        //Calendar
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

        //Adult Dropdown
        WebElement adult = driver.findElement(By.id("Adults"));
        Select a = new Select(adult);
        a.selectByIndex(2);
        System.out.println(a.getFirstSelectedOption().getText());

        //Child Dropdown
        WebElement child = driver.findElement(By.id("Childrens"));
        Select c = new Select(child);
        c.selectByIndex(2);
        System.out.println(c.getFirstSelectedOption().getText());
    }
}
