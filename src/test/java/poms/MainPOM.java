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

public class MainPOM {
	final WebDriver driver;
	final WebDriverWait wait;
	
	@FindBy (className = "createPostInput")
	WebElement createPostInput;
	
	@FindBy (className = "addPostImagesInput")
	WebElement addPostImagesInput;
	
	@FindBy (className = "previewImageContainer")
	List <WebElement> previewImageContainer;
	
	@FindBy (className = "removePreviewImageButton")
	WebElement removePreviewImageButton;
	
	@FindBy (className = "createPostSubmitContainer")
	WebElement createPostSubmitContainer;
	
	@FindBy (className = "card")
	List <WebElement> cards;
	
	@FindBy (className = "postComments")
	List <WebElement> postCommentsList;
	
	@FindBy (tagName = "app-user")
	List <WebElement> users;
	
	public MainPOM (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));
		
		PageFactory.initElements (this.driver, this);
	}
	
	public void addImageToPost () throws URISyntaxException {
		//get 1.jpg from src/test/resources/
		URL url = MainPOM.class.getResource ("/1.jpg");
		
		this.addPostImagesInput.sendKeys (url.getPath ().substring (1));
	}
	
	public boolean doesPreviewImageContainerExist () {
		return this.previewImageContainer.size () > 0;
	}
	
	public int getPreviewImageCount () {
		if (!this.doesPreviewImageContainerExist ()) {
			return -1;
		}
		
		return this.previewImageContainer.get (0).findElements (By.className ("previewImage")).size ();
	}
	
	public void removePreviewImage () {
		removePreviewImageButton.click ();
	}
	
	public void setPostBody (String body) {
		this.createPostInput.sendKeys (body);
	}
	
	public void submitPost () {
		int postCount = getPostCount ();
		
		createPostSubmitContainer.findElement (By.tagName ("button")).click ();
		
		//todo find a way to wait for the post without using postCount, because pagination doesn't allow post count to go above 20
		try {
			Thread.sleep (2000);
		}
		
		catch (InterruptedException ignored) {}
	}
	
	public String getAlertText () {
		this.wait.until (ExpectedConditions.alertIsPresent ());
		
		return this.driver.switchTo ().alert ().getText ();
	}
	
	public int getPostCount () {
		//return size of cards list - 1 (one of them is the create post component)
		return this.cards.size () - 1;
	}
	
	public String getPostBody (int index) {
		return this.cards.get (index + 1).findElement (By.className ("postBody")).getText ();
	}
	
	public boolean doesPostHaveImages (int index) {
		return this.cards.get (index + 1).findElements (By.className ("postImages")).size () > 0;
	}
	
	public String getPostVideoSrc (int index) {
		return this.cards.get (index + 1).findElements (By.className ("postYouTubePlayer")).get (0).getAttribute ("src");
	}
	
	public void clickCommentButton (int postIndex) {
		this.cards.get (postIndex + 1).findElement (By.className ("postControls")).findElements (By.className ("postControl")).get (0).findElement (By.tagName ("a")).click ();
	}
	
	public boolean areCommentsOpen (int postIndex) {
		return this.postCommentsList.get (postIndex).isDisplayed ();
	}
	
	public void clickLikeButton (int postIndex) {
		this.cards.get (postIndex + 1).findElement (By.className ("postControls")).findElements (By.className ("postControl")).get (1).findElement (By.tagName ("a")).click ();
	}
	
	public int getLikeCount (int postIndex) {
		try {
			return Integer.parseInt (this.cards.get (postIndex + 1).findElement (By.className ("postControls")).findElements (By.className ("postControl")).get (1).findElement (By.tagName ("p")).getText ());
		}
		
		//if the like count element wasn't found, it means that there are no likes, since the p is not rendered if there are no likes
		catch (NoSuchElementException exception) {
			return 0;
		}
	}
	
	public int getCommentCount (int postIndex) {
		try {
			return Integer.parseInt (this.cards.get (postIndex + 1).findElement (By.className ("postControls")).findElements (By.className ("postControl")).get (0).findElement (By.tagName ("p")).getText ());
		}
		
		//if the comment count element wasn't found, it means that there are no comments, since the p is not rendered if there are no comments
		catch (NoSuchElementException exception) {
			return 0;
		}
	}
	
	public int howManyComments (int postIndex) {
		return this.postCommentsList.get (postIndex).findElements (By.tagName ("app-comment")).size ();
	}
	
	public void postComment (int postIndex, String body) {
		this.postCommentsList.get (postIndex).findElement (By.className ("postCommentsInputContainer")).findElement (By.tagName ("input")).sendKeys (body);
		this.postCommentsList.get (postIndex).findElement (By.className ("postCommentsInputContainer")).findElement (By.tagName ("button")).click ();
		
		//todo find a better way to wait
		try {
			Thread.sleep (2000);
		}
		
		catch (InterruptedException ignored) {}
	}
	
	public void clickUser () {
		this.users.get (0).findElement (By.className ("userContainer")).click ();
	}
}
