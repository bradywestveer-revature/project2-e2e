package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPOM {
	final WebDriver driver;
	final WebDriverWait wait;
	
	public LoginPOM (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));
		
		PageFactory.initElements (this.driver, this);
	}
	
	@FindBy (tagName = "input")
	List <WebElement> inputElements;
	
	@FindBy (tagName = "button")
	WebElement loginBtn;
	
	@FindBy (linkText = "Create an Account")
	WebElement registerBtn;
	
	@FindBy (linkText = "Forgot Password")
	WebElement resetPWordBtn;
	
	@FindBy (tagName = "errorText")
	WebElement errMessage;
	
	public void usernameInput (String username) {
		inputElements.get (0).sendKeys (username);
	}
	
	public void passwordInput (String password) {
		inputElements.get (1).sendKeys (password);
	}
	
	public void clickLogin () {
		loginBtn.click ();
	}
	
	public void clickRegisterBtn () {
		registerBtn.click ();
	}
	
	public void clickPasswordResetBtn () {
		resetPWordBtn.click ();
	}
	
	public String getErrorMessage () {
		this.wait.until (ExpectedConditions.visibilityOf (this.errMessage));
		return this.errMessage.getText ();
	}
	
	public String getCurrentUrl () {
		return this.driver.getCurrentUrl ();
	}
}
