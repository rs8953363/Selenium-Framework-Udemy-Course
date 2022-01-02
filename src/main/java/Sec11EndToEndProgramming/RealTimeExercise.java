package Sec11EndToEndProgramming;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class RealTimeExercise {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.id("checkBoxOption2")).click();
        String option = driver.findElement(By.id("checkBoxOption2")).getText();
        System.out.println(option);

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select s = new Select(dropdown);
        //s.selectByVisibleText(option);
        driver.findElement(By.name("enter-name")).sendKeys(option);
        driver.findElement(By.id("alertbtn")).click();
        String text = driver.switchTo().alert().getText();
        if(text.contains(option)){
            System.out.println("Alert message success");
        }
        //System.out.println(driver.findElement(By.xpath("//*[@id='chekbox-eample']/fieldsetlabel[2]")).getText());
    }
}
