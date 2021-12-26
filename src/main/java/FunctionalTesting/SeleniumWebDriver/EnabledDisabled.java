package FunctionalTesting.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnabledDisabled {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //It returns true, but it should return false. The alternative way is to find the attribute that changes with
        // the enable and disable mode.So, let's comment out the following sout lines.

        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
       // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());


        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
            if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
                System.out.println("it's enabled");
                Assert.assertTrue(true);
        }else{
                Assert.assertTrue(false);
            }

    }
}
