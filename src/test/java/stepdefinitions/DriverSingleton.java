package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    private static WebDriver driver = null;

    private DriverSingleton(){}

    public static WebDriver getInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static void quitInstance(){
        driver.quit();
        driver = null;
    }
}
