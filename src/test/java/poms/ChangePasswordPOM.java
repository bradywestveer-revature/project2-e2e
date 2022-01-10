package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ChangePasswordPOM {
	final WebDriver driver;
	final WebDriverWait wait;
	
	public ChangePasswordPOM (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));
		
		PageFactory.initElements (this.driver, this);
	}

	@FindBy(tagName = "input")
	List<WebElement> inputElements;

	@FindBy(tagName = "button")
	WebElement submitBtn;

	@FindBy(linkText = "Try E-Mail Password Reset Again")
	WebElement resetPasswordPageBtn;

	@FindBy(className = "errorText")
	WebElement errMessage;

	public void passwordInput(String password) {
		inputElements.get(0).sendKeys(password);
	}

	public void confirmPasswordInput(String password) {
		inputElements.get(1).sendKeys(password);
	}

	public void clickSubmit() {
		submitBtn.click();
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	public String getErrorMessage() {
		this.wait.until(ExpectedConditions.visibilityOf(errMessage));
		return this.errMessage.getText();
	}

	public void clickResetPasswordBtn(){
		resetPasswordPageBtn.click();
	}
}
