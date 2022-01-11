package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePOM {
	final WebDriver driver;
	final WebDriverWait wait;

	@FindBy(className = "profileInfoContainer")
	List<WebElement> profileContainerElems;

	@FindBy(className = "userContainer")
	List<WebElement> userElems;

	@FindBy(className = "profileEditButton")
	WebElement profileEditButtonElem;

	@FindBy(className = "profileEditControl")
	List<WebElement> profileEditControls;

	@FindBy(className = "profileEditSubmitButton")
	List<WebElement> profileEditSubmitButtons;

	private String oldFirstname= "";
	private String oldLastname= "";
	private String oldUsername= "";
	private String oldEmail="";
	private String oldPassword = "";

	public ProfilePOM (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));
		
		PageFactory.initElements (this.driver, this);
	}

	public String getUsername() {
		WebElement usernameElement = this.userElems.get(0).findElement(By.className("usernameText"));
		String username = usernameElement.getText();
		return username.substring(1);	// strip off the '@' character
	}

	public void clickProfileElement() {
		driver.findElement(By.tagName("app-header")).findElement(By.tagName("app-user")).click();
	}

	public void clickEditProfile() { this.profileEditButtonElem.click(); }

	public Boolean waitForProfilePageToAppear() {
		String profileURL = "http://localhost:4200/@" + this.getUsername();
		System.out.println("profileURL="+profileURL);
		try {
			this.wait.until(ExpectedConditions.urlToBe(profileURL));
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public WebElement getFirstNameLastNameElem() {
		System.out.println("profileContainerElems.size()="+ userElems.size());
		//List<WebElement> webElemP = this.profileContainerElems.get(0).findElements(By.tagName("p"));
		List<WebElement> webElemP = this.userElems.get(0).findElements(By.tagName("div"));
		/*System.out.println("webElemP.size()="+webElemP.size());
		for (WebElement elem:webElemP) {
			System.out.println("elem.getTagname="+elem.getTagName()+" elem.getText()="+elem.getText());
		}*/
		return webElemP.get(0);
	}

	public String[] getFirstNameLastNameFromHeader() {
		// The first <p></p> tag in our <div></div> of class profileInfoContainer has user firstName lastName
		String firstNamePlusLastName = this.getFirstNameLastNameElem().getText();
		//System.out.println("firstNamePlusLastName="+firstNamePlusLastName);
		return firstNamePlusLastName.split("[ @]");
	}

	public void dumpChildElems(WebElement webElem) {
		List<WebElement> webElems = webElem.findElements(By.xpath("./child::*"));
		System.out.println(webElem.getAccessibleName()+" child node count="+webElems.size());
		for (WebElement elem:webElems) {
			System.out.println("elem.getTagname=" + elem.getTagName() + " elem.getText()=" + elem.getText());
		}
	}


	public String getEmailFromProfile() {
		// profileContainerElems.get(1) means the SECOND profileContainer which will be in the body right above posts, not get(0) which is
		// profileContainer from the header profileContainerElems.get(0)
		//this.dumpChildElems(profileContainerElems.get(0));
		String emailWithUnicodeLetter = this.profileContainerElems.get(0).findElements(By.tagName("p")).get(2).getText();
		return emailWithUnicodeLetter.substring(2);
	}

	public void waitForProfileEditElems() {
		this.wait.until(ExpectedConditions.visibilityOf(profileEditControls.get(0)));
		//this.wait.until(ExpectedConditions.
	}

	public Boolean validateProfileEditControlPlaceholders() {
		Boolean isValid = true;
		String[] firstNamePlusLastname = this.getFirstNameLastNameFromHeader();
		String firstName	 	= this.oldFirstname;
		String lastName 		= this.oldLastname;
		String username 		= this.oldUsername;
		String email 			= this.oldEmail ;
		String newPassword 		= "New Password";
		System.out.println("firstName=" +this.oldFirstname + "\n" +
				"lastName=" +this.oldLastname +	"\n" +
				"email=" +this.oldEmail  +		"\n" +
				"username=" +this.oldUsername +	"\n" +
				"newPassword="+this.oldPassword  +		"\n");

		for(int i=0; i<profileEditControls.size(); i++) {
			WebElement elem = profileEditControls.get(i);
			if (i==0) {
				if( !elem.getAttribute("placeholder").equals(firstName)) {
					isValid = false;
					//break;
					System.out.println("Invalid: "+elem.getAttribute("placeholder")+" firstName="+firstName);
				}
			}
			else if (i==1) {
				if (!elem.getAttribute("placeholder").equals(lastName)) {
					isValid = false;
					//break;
					System.out.println("Invalid: "+elem.getAttribute("placeholder")+" lastName="+lastName);
				}
			}
			else if (i==2) {
				if (!elem.getAttribute("placeholder").equals(email)) {
					isValid = false;
					//break;
					System.out.println("Invalid: "+elem.getAttribute("placeholder")+" email="+email);
				}
			}
			else if (i==3) {
				if (!elem.getAttribute("placeholder").equals(username)) {
					isValid = false;
					//break;
					System.out.println("Invalid: "+elem.getAttribute("placeholder")+" username="+username);
				}
			}
			else if (i==4) {
				if (!elem.getAttribute("placeholder").equals("New Password")) {
					isValid = false;
					//break;
					System.out.println("Invalid: "+elem.getAttribute("placeholder")+" newPassword="+newPassword);
				}
			}
			/*if (!isValid) {
				System.out.println("Invalid: profileEditControls.get("+ String.valueOf(i)+").getAttribute(\"placeholder\")="+elem.getAttribute("placeholder"));
			} else {
				System.out.println("Valid: profileEditControls.get("+ String.valueOf(i)+").getAttribute(\"placeholder\")="+elem.getAttribute("placeholder"));
			}*/
		}
		return isValid;
	}

	public void waitForEditProfileFieldsToBeHidden() {
		this.wait.until(ExpectedConditions.visibilityOf(profileEditButtonElem));
	}

	public Boolean validateEditProfileDidNotChangeProfileUser() {
		// We can check all fields from the edit profile page except password
		String[] firstNamePlusLastname = this.getFirstNameLastNameFromHeader();
		String firstName = firstNamePlusLastname[0];
		String lastName = firstNamePlusLastname[1].trim();
		String username = this.getUsername();
		String email = this.getEmailFromProfile();
		return oldFirstname.equals(firstName) && oldLastname.equals(lastName) && oldUsername.equals(username) && oldEmail.equals(email);
	}

	public void getProfileFieldsBeforeEditProfileClicked() {
		String[] firstNamePlusLastname = this.getFirstNameLastNameFromHeader();
		this.oldFirstname	= firstNamePlusLastname[0];
		this.oldLastname 	= firstNamePlusLastname[1].trim();
		this.oldEmail 		= this.getEmailFromProfile().trim();
		this.oldUsername 	= this.getUsername().trim();
		this.oldPassword  	= "New Password";
	}	

	public void clickProfileEditSubmitButton() {
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("profileEditSubmitButton"), 0));
		profileEditSubmitButtons.get(1).click();
	}

	public void clickProfileEditXButton() {
		profileEditSubmitButtons.get(0).click();
	}

	public WebElement getFirstnameElem() {
		return this.profileEditControls.get(0);
	}

	public WebElement getLastnameElem() {
		return this.profileEditControls.get(1);
	}

	public void setProfileEditFirstname(String firstname) {
		this.getFirstnameElem().sendKeys(firstname);
	}

	public void setProfileEditLastname(String lastname) {
		this.getLastnameElem().sendKeys(lastname);
	}

	public String getProfileEditFirstname() {
		return this.getFirstnameElem().getText();
	}

	public String getProfileEditLastname() {
		return this.getLastnameElem().getText();
	}

	public void clickLogoutButton() {
		driver.findElement(By.id("headerUser")).findElement(By.tagName("a")).click();
	}

	public String getProfileUrl() {
		return "http://localhost:4200/@"+this.getUsername();
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
}
