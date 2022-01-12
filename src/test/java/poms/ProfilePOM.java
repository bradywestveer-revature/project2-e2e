package poms;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ProfilePOM {
	static final String PROFILE_IMAGE_TEST="1.jpg";

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

	@FindBy(className = "profileContainer")
	List<WebElement> profileContainer;

	@FindBy (className = "editProfileImageInput")
	WebElement editProfileImageInput;

	@FindBy (className = "profileImage")
	WebElement profileImage;

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

	public void clickEditProfile() {
		this.profileEditButtonElem.click();
	}

	public void clickProfileEditSubmitButton() {
		this.waitForProfileEditElems();
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("profileEditSubmitButtons"), 0));
		profileEditSubmitButtons.get(1).click();
	}

	public void clickProfileEditXButton() {
		this.waitForProfileEditElems();
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("profileEditSubmitButtons"), 0));
		profileEditSubmitButtons.get(0).click();
	}

	public Boolean waitForProfilePageToAppear() {
		String profileURL = "http://localhost:4200/@" + this.getUsername();
		//System.out.println("profileURL="+profileURL);
		try {
			this.wait.until(ExpectedConditions.urlToBe(profileURL));
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public WebElement getFirstNameLastNameElem() {
		//System.out.println("profileContainerElems.size()="+ userElems.size());
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
		System.out.println("*** dumpChildElems ***");
		List<WebElement> webElems = webElem.findElements(By.xpath("./child::*"));
		System.out.println(webElem.getAttribute("class")+" child node count="+webElems.size());
		for (WebElement elem:webElems) {
			System.out.println("\telem.getTagname=" + elem.getTagName() + " elem.getText()=" + elem.getText());
		}
		System.out.println("*** End dump ***");
	}

	public List<WebElement> getChildElems(WebElement webElem) {
		List<WebElement> webElems = webElem.findElements(By.xpath("./child::*"));
		return webElems;
	}

	public String getEmailFromProfile() {
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("profileContainer"), 0));
		Integer pCount = 0;
		for ( WebElement elem:this.getChildElems(profileContainerElems.get(0)) ) {
			if (elem.getTagName().equals("p")) {
				pCount++;
				if (pCount==3) {
					return elem.getText().substring(2);
				}
			}
		}
		// If we got this far we could not find our WebElement for email so dump useful error message
		this.dumpChildElems(profileContainerElems.get(0));
		return "***ERROR in getEmailFromProfile()***";
	}

	public void waitForProfileEditElems() {
		this.wait.until(ExpectedConditions.visibilityOf(profileEditControls.get(0)));
		//this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("profileEditControls")));
	}

	public Boolean validateProfileEditControlPlaceholders() {
		Boolean isValid = true;
		String[] firstNamePlusLastname = this.getFirstNameLastNameFromHeader();
		String firstName	 	= this.oldFirstname;
		String lastName 		= this.oldLastname;
		String username 		= this.oldUsername;
		String email 			= this.oldEmail ;
		String newPassword 		= "New Password";
		/*System.out.println("firstName=" +this.oldFirstname + "\n" +
				"lastName=" +this.oldLastname +	"\n" +
				"email=" +this.oldEmail  +		"\n" +
				"username=" +this.oldUsername +	"\n" +
				"newPassword="+this.oldPassword  +		"\n");*/

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
		}
		return isValid;
	}

	public void waitForEditProfileFieldsToBeHidden() {
		// Waiting for the "Edit Profile" button is equivalent to all the fields being hidden
		try {
			this.wait.until(ExpectedConditions.visibilityOf(profileEditButtonElem));
			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("profileEditButton"))));
			this.wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("profileEditButton")), "Edit Profile"));
			this.wait.until(ExpectedConditions.textToBe(By.tagName("Button"), "Edit Profile"));
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			this.dumpChildElems(driver.findElements(By.className("profileInfoContainer")).get(0));
		} catch (NoSuchElementException e2) {
			e2.printStackTrace();
		}
	}

	public void waitForProfileInfoContainerToAppear() {
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("profileInfoContainer"), 0));
	}

	public Boolean validateEditProfileDidNotChangeProfileUser() {
		Boolean isValid = true;
		// We can check all fields from the edit profile page except password
		String[] firstNamePlusLastname = this.getFirstNameLastNameFromHeader();
		String firstName = firstNamePlusLastname[0];
		String lastName = firstNamePlusLastname[1].trim();
		String username = this.getUsername();
		String email = this.getEmailFromProfile();
		if (!oldFirstname.equals(firstName)) {
			System.out.println("Invalid: oldFirstName="+this.oldFirstname + " firstName=" + firstName);
			isValid = false;
		}
		if (!oldLastname.equals(lastName)) {
			System.out.println("Invalid: oldLastName="+this.oldLastname+" lastName="+lastName);
			isValid=false;
		}
		if (!oldEmail.equals(email)) {
			System.out.println("Invalid: oldEmail="+this.oldEmail+" email="+email);
			isValid=false;
		}
		if (!oldUsername.equals(username)){
			System.out.println("Invalid: oldUsername="+this.oldUsername+" username="+username);
			isValid=false;
		}
		return isValid;
	}

	public void getProfileFieldsBeforeEditProfileClicked() {
		String[] firstNamePlusLastname = this.getFirstNameLastNameFromHeader();
		this.oldFirstname	= firstNamePlusLastname[0];
		this.oldLastname 	= firstNamePlusLastname[1].trim();
		this.oldEmail 		= this.getEmailFromProfile().trim();
		this.oldUsername 	= this.getUsername().trim();
		this.oldPassword  	= "New Password";
	}

	public WebElement getFirstnameElem() {
		return this.profileEditControls.get(0);
	}

	public WebElement getLastnameElem() {
		return this.profileEditControls.get(1);
	}

	public WebElement getEmailElem() {
		this.waitForProfileEditElems();
		return this.profileEditControls.get(2);
	}

	public WebElement getUsernameElem() {
		this.waitForProfileEditElems();
		return this.profileEditControls.get(3);
	}

	public WebElement getPasswordElem() {
		this.waitForProfileEditElems();
		return this.profileEditControls.get(4);
	}

	public void setProfileEditFirstname(String firstname) {
		this.getFirstnameElem().sendKeys(firstname);
	}

	public void setProfileEditLastname(String lastname) {
		this.getLastnameElem().sendKeys(lastname);
	}

	public void setProfileEditEmail(String email) {
		this.getEmailElem().sendKeys(email);
	}

	public void setProfileEditUsername(String username) {
		this.getUsernameElem().sendKeys(username);
	}

	public void setProfileEditPassword(String password) {
		this.getPasswordElem().sendKeys(password);
	}

	public String getProfileEditFirstname() {
		return this.getFirstnameElem().getAttribute("value");
	}

	public String getProfileEditLastname() {
		return this.getLastnameElem().getAttribute("value");
	}

	public String getProfileEditEmail() {
		return this.getEmailElem().getAttribute("value");
	}

	public String getProfileEditUsername() {
		return this.getUsernameElem().getAttribute("value");
	}

	public String getProfileEditPassword() {
		return this.getPasswordElem().getAttribute("value");
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

	public void addImageToProfile () throws URISyntaxException {
		//get 1.jpg from src/test/resources/
		URL url = ProfilePOM.class.getResource ("/"+this.PROFILE_IMAGE_TEST);
		//System.out.println("url.getPath ().substring (1)="+url.getPath ().substring (1));
		this.editProfileImageInput.sendKeys (url.getPath ().substring (1));
	}


	public Boolean validateTempProfileImageWasSet() {
		wait.until(ExpectedConditions.attributeContains(profileImage, "src", "blob:http"));
		// A temp image appears to be set in the web element
		String imgURL = profileImage.getAttribute("src");
		//System.out.println("imgURL="+imgURL);
		if (imgURL.contains("blob:http")) return true;
		return true;
	}

	public Boolean validateProfileImageWasSet() {
		String searchString = this.getUsername()+this.PROFILE_IMAGE_TEST;
		wait.withTimeout(Duration.ofSeconds(60)).until(ExpectedConditions.attributeContains(profileImage, "src", searchString));
		String imgURL = profileImage.getAttribute("src");
		//System.out.println("imgURL="+imgURL);
		if (imgURL.contains(searchString)) return true;
		return false;
	}
}
