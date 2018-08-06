import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.lang.Object;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumFirstTest {

    @Test(enabled=false)
    public void javascriptTest(){
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("alert('I am an alert box!')");
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Object script = js.executeScript("return document.getElementById('lst-ib');");
        WebElement element = driver.findElement(By.name("q"));

        driver.quit();
    }


    @Test
    public void startChromeWebDriver() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setVersion("");
        cap.setPlatform(Platform.LINUX);
        RemoteWebDriver driver;
        driver = new RemoteWebDriver(new URL("http://192.168.99.100:4446/wd/hub"), cap);
        driver.navigate().to("http://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }

    @Test
    public void startFFWebDriver() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setVersion("");
        cap.setPlatform(Platform.LINUX);
        RemoteWebDriver driver;
        driver = new RemoteWebDriver(new URL("http://192.168.99.100:4446/wd/hub"), cap);
        driver.navigate().to("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }



}
