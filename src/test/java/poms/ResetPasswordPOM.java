package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPOM {
	final WebDriver driver;
	final WebDriverWait wait;
	
	public ResetPasswordPOM (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));
		
		PageFactory.initElements (this.driver, this);
	}
}
