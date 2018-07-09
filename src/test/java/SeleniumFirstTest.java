import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.lang.Object;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class SeleniumFirstTest {
    @Test
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
    public void startChromeWebDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        Assert.assertTrue(true);
        driver.quit();
    }

    @Test
    public void startFFWebDriver(){
        System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.com");
        Assert.assertTrue(true);
        driver.quit();
    }



}
