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

public class ResetPasswordPOM {
	final WebDriver driver;
	final WebDriverWait wait;
	
	public ResetPasswordPOM (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));
		
		PageFactory.initElements (this.driver, this);
	}

	@FindBy(tagName = "input")
	WebElement input;

	@FindBy(className = "errorText")
	WebElement errMessage;

	@FindBy(tagName = "button")
	WebElement resetPasswordBtn;

	@FindBy(linkText = "Retry Login")
	WebElement loginPageBtn;

	public void emailInput(String email){
		this.input.sendKeys(email);
	}

	public void clickResetPasswordBtn() {
		resetPasswordBtn.click();
	}

	public void clickLoginPageBtn() {
		loginPageBtn.click();
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	public String getSuccessMessage() {
		this.wait.until(ExpectedConditions.textToBe(By.className("errorText"), "Successfully sent password reset e-mail to player1foreverr@gmail.com."));
		//this.wait.until(ExpectedConditions.visibilityOf(errMessage));
		return this.errMessage.getText();
	}

	public String getErrorMessage() {
		//this.wait.until(ExpectedConditions.textToBe(By.className("errorText"), "Successfully sent password reset e-mail to player1foreverr@gmail.com."));
		this.wait.until(ExpectedConditions.visibilityOf(errMessage));
		return this.errMessage.getText();
	}
}
