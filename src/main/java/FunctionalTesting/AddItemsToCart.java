package FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddItemsToCart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String[] veggiesNeeded = {"Cucumber", "Broccoli"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            //check whether name you extracted is present in array or not
            if (name.contains("Cucumber")) {
                //click on Add to Cart
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
            //If you want to add a couple of more vegetables to the cart, you need to create an array and put the values in it.



    }
}
