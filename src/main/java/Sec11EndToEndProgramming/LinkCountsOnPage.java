package Sec11EndToEndProgramming;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

public class LinkCountsOnPage {
    public static void main(String[] args) throws InterruptedException {

        //Find the number of links on the page. Hint: All links on a webpage have "a" as a tagName
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println("Links in the Page");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Find the number of links on the footer. Hint: Create a mini driver
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        //WebElement footer=driver.findElement(By.xpath(".//*[@id='glbfooter']"));
        System.out.println("Links in the footer section");
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //Find the number of links on the footer's first column.
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("Links in the 2nd column of the section");
        System.out.println(columndriver.findElements(By.tagName("a")).size());


        //Click on each link in the column and check if the pages are opening. The following for loop opens all the tabs.
        for (int i = 1; i<columndriver.findElements(By.tagName("a")).size(); i++) {

            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);//This will open a new tab.
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            //Clicking link with a Ctrl key help you to open the page on a new tab. You might want to open links in a
            // separate tab so you don't have to click the back button all the time and save some time.
            Thread.sleep(5000L);
        }
            Set<String> abc = driver.getWindowHandles();
            Iterator<String> it = abc.iterator();

            while(it.hasNext()){//We are asking if the first window is present
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
            }
        }
    }
