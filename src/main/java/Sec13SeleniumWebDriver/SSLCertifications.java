package Sec13SeleniumWebDriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SSLCertifications<extraCapabilities> {
    public static void main(String[] args) {

        //Sometimes you see messages like  or "this site's security certificate is not
        // trusted" or "this is probably not the site you are looking for", they are called SSL certifications.
        // "Your connection is not private" is an insecure certification. You click "proceed anyway" but hot to tell Selenium to do that?
        //Here is the 4 lines of code you need to use

        //DesiredCapabilities (like creating general profile) and ChromeOptions (used to set local browser settings) classes are different.
        //DesiredCapabilities-->general chrome profile
        DesiredCapabilities ch = DesiredCapabilities.chrome();//desiredCapabilities helps you to customize Chrome browser
        //ch.acceptInsecureCerts();
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        //The following ChromeOptions belongs to your local browser
        ChromeOptions c = new ChromeOptions();
        c.merge(ch);
        System.setProperty("webdriver.chrome.driver","C:\\Selenium Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(c);

    }
}