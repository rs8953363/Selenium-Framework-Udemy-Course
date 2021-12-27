package FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddItemsToCart {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot","Carrot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //Code works well, but it takes time to load the items added to the card. But, Selenium is so fast, it checks
        // the size of the cart immediately. That's why we need Thread.sleep here.
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

    }

        public static void addItems(WebDriver driver, String[] itemsNeeded){
        int count = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            //Broccoli - 1 kg (Use split method as you need Broccoli only)
            //Then it becomes two parts: name[0] = Broccoli and name[1] = 1 kg
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            // format it to (trim it) get actual vegetable name. Convert array into array list for easy search. Because
            // arrays take less memory. Arraylist used when you have complicated scenarios to verify. In runtime you can
            // convert it to arraylist to save memory. Check whether name you extracted is present in array or not
            List itemsNeededList = Arrays.asList(itemsNeeded);

           if (itemsNeededList.contains(formattedName)) {
               count++;
               //click on Add to Cart
               driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();//This doesn't work although
               // it works in debug mode. DO NOT use tex when you work with dynamic locators.

               //let's say the if condition satisfied 3 times (i.e you found the items on your list). Then, you don't need
               // to run this condition for 27 more times for all products. It needs to exit the if condition. Here is how...
               if (count == itemsNeeded.length) {
                   break;
               }
           }
            //If you want to add a couple of more vegetables to the cart, you need to create an array and put the values in it.
        }

    }
}
