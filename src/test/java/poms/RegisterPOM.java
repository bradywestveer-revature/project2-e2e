package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterPOM {
    WebDriver driver;
    WebDriverWait wait;

    public RegisterPOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    @FindBy(tagName = "input")
    List<WebElement> inputs;

    @FindBy(className = "errorText")
    WebElement errMessage;

    @FindBy(tagName = "button")
    WebElement registerBtn;

    @FindBy(linkText = "Login to an existing account")
    WebElement loginPageBtn;

    public void firstNameInput(String firstName){
        inputs.get(0).sendKeys(firstName);
    }

    public void lastNameInput(String lastName){
        inputs.get(1).sendKeys(lastName);
    }

    public void emailInput(String email){
        inputs.get(2).sendKeys(email);
    }

    public void usernameInput(String username){
        inputs.get(3).sendKeys(username);
    }

    public void passwordInput(String password){
        inputs.get(4).sendKeys(password);
    }

    public void confirmPasswordInput(String confirmPassword){
        inputs.get(5).sendKeys(confirmPassword);
    }

    public String getErrorMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(errMessage));
        return this.errMessage.getText();
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

    public void clickLoginPageBtn(){
        loginPageBtn.click();
    }

    public void waitForSuccessfulRegister(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }


}
