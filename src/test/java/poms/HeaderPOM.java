package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeaderPOM {

    final WebDriver driver;
    final WebDriverWait wait;

    public HeaderPOM (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));

        PageFactory.initElements (this.driver, this);
    }

    @FindBy(id = "headerUser")
    WebElement headerUser;

    @FindBy(linkText = "Logout")
    WebElement logoutBtn;

    public void clickLogoutBtn(){
        this.logoutBtn.click();
    }

    public Boolean userCompAndLogoutBtnVisible(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("headerUser"), 0));
        return this.headerUser.isDisplayed();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }
}
