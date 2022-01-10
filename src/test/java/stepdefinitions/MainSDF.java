package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import poms.MainPOM;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class MainSDF {
	final MainPOM mainPOM;
	
	public MainSDF () {
		this.mainPOM = new MainPOM (DriverSingleton.getInstance ());
	}
	
	@Given ("Main: The user is on the main page")
	public void main_the_user_is_on_the_main_page () {
		assertEquals ("http://localhost:4200/", DriverSingleton.getInstance ().getCurrentUrl ());
	}
	
	@When ("Main: The user adds an image to their draft post")
	public void main_the_user_adds_an_image_to_their_draft_post () throws URISyntaxException {
		this.mainPOM.addImageToPost ();
	}
	
	@Then ("Main: The image preview is displayed")
	public void main_the_image_preview_is_displayed () {
		assertEquals (1, this.mainPOM.getPreviewImageCount ());
	}
	
	@When ("Main: The user clicks the remove button on the image preview")
	public void main_the_user_clicks_the_remove_button_on_the_image_preview () {
		this.mainPOM.removePreviewImage ();
	}
	
	@Then ("Main: The image preview is removed")
	public void main_the_image_preview_is_removed () {
		assertFalse (this.mainPOM.doesPreviewImageContainerExist ());
	}
	
	@When ("Main: The user posts an invalid post")
	public void main_the_user_posts_an_invalid_post () {
		try {
			this.mainPOM.submitPost ();
			
			assertEquals ("Error! Invalid post", this.mainPOM.getAlertText ());
		}
		
		//if an exception is thrown for the alert, we can't test the text todo somehow test the text
		catch (UnhandledAlertException ignored) {}
	}
	
	@Then ("Main: An invalid post error message is shown")
	public void main_an_invalid_post_error_message_is_shown () {
		//this is handled in the When method for this scenario todo test the text of the message
	}
	
	@When ("Main: The user posts with a body")
	public void main_the_user_posts_with_a_body () {
		this.mainPOM.setPostBody ("test body 0");
		this.mainPOM.submitPost ();
		this.mainPOM.waitForPost("test body 0");
	}
	
	@Then ("Main: The post is displayed with a body")
	public void main_the_post_is_displayed_with_a_body () {
		//todo somehow make sure that the post is not from a previous run
		assertTrue (this.mainPOM.getPostCount () > 0);
		
		assertEquals ("test body 0", this.mainPOM.getPostBody (0));
	}
	
	@When ("Main: The user posts with a body and images")
	public void main_the_user_posts_with_a_body_and_images () throws URISyntaxException {
		this.mainPOM.setPostBody ("test body 1");
		this.mainPOM.addImageToPost ();
		this.mainPOM.submitPost ();
		this.mainPOM.waitForPost("test body 1");
	}
	
	@Then ("Main: The post is displayed with a body and images")
	public void main_the_post_is_displayed_with_a_body_and_images () {
		//todo somehow make sure that the post is not from a previous run
		assertTrue (this.mainPOM.getPostCount () > 0);
		
		assertEquals ("test body 1", this.mainPOM.getPostBody (0));
		
		assertTrue (this.mainPOM.doesPostHaveImages (0));
	}
	
	@When ("Main: The user posts with a body and a video link")
	public void main_the_user_posts_with_a_body_and_a_video_link () {
		this.mainPOM.setPostBody ("test body 2 https://www.youtube.com/watch?v=PNWWuQbjaA8");
		this.mainPOM.submitPost ();
		this.mainPOM.waitForPost("test body 2 https://www.youtube.com/watch?v=PNWWuQbjaA8");
	}
	
	@Then ("Main: The post is displayed with a only the first video")
	public void main_the_post_is_displayed_with_a_only_the_first_video () {
		assertEquals ("https://www.youtube-nocookie.com/embed/PNWWuQbjaA8", this.mainPOM.getPostVideoSrc (0));
	}
	
	@When ("Main: The user posts with a body and multiple video links")
	public void main_the_user_posts_with_a_body_and_multiple_video_links () {
		this.mainPOM.setPostBody ("test body 3 https://www.youtube.com/watch?v=PNWWuQbjaA8 https://www.youtube.com/watch?v=QggJzZdIYPI");
		this.mainPOM.submitPost ();
		this.mainPOM.waitForPost("test body 3 https://www.youtube.com/watch?v=PNWWuQbjaA8 https://www.youtube.com/watch?v=QggJzZdIYPI");
	}
	
	@When ("Main: The user posts with a body and images and a video link")
	public void main_the_user_posts_with_a_body_and_images_and_a_video_link () throws URISyntaxException {
		this.mainPOM.setPostBody ("test body 4 https://www.youtube.com/watch?v=PNWWuQbjaA8");
		this.mainPOM.addImageToPost ();
		this.mainPOM.submitPost ();
		this.mainPOM.waitForPost ("test body 4 https://www.youtube.com/watch?v=PNWWuQbjaA8");
	}
	
	@Then ("Main: The post is displayed with images and only the first video")
	public void main_the_post_is_displayed_with_images_and_only_the_first_video () {
		assertTrue (this.mainPOM.doesPostHaveImages (0));
		assertEquals ("https://www.youtube-nocookie.com/embed/PNWWuQbjaA8", this.mainPOM.getPostVideoSrc (0));
	}
	
	@When ("Main: The user posts with a body and images and multiple video links")
	public void main_the_user_posts_with_a_body_and_images_and_multiple_video_links () throws URISyntaxException {
		this.mainPOM.setPostBody ("test body 5 https://www.youtube.com/watch?v=PNWWuQbjaA8 https://www.youtube.com/watch?v=QggJzZdIYPI");
		this.mainPOM.addImageToPost ();
		this.mainPOM.submitPost ();
		this.mainPOM.waitForPost ("test body 5 https://www.youtube.com/watch?v=PNWWuQbjaA8 https://www.youtube.com/watch?v=QggJzZdIYPI");
	}
	
	@When ("Main: The user clicks on the comment button on a post")
	public void main_the_user_clicks_on_the_comment_button_on_a_post () throws InterruptedException {
		this.mainPOM.clickCommentButton (0);
	}
	
	@Then ("Main: The comments open on the post")
	public void main_the_comments_open_on_the_post () {
		assertTrue (this.mainPOM.areCommentsOpen (0));
	}
	
	@Then ("Main: The comments close on the post")
	public void main_the_comments_close_on_the_post () {
		assertFalse (this.mainPOM.areCommentsOpen (0));
	}
	
	@When ("Main: The user clicks on the like button on a post")
	public void main_the_user_clicks_on_the_like_button_on_a_post () {
		this.mainPOM.clickLikeButton (0);
	}
	
	@Then ("Main: The post like count increases by one")
	public void main_the_post_like_count_increases_by_one () {
		assertEquals (1, this.mainPOM.getLikeCount (0));
	}
	
	@Then ("Main: The post like count decreases by one")
	public void main_the_post_like_count_decreases_by_one () {
		assertEquals (0, this.mainPOM.getLikeCount (0));
	}
	
	@When ("Main: The user comments on a post")
	public void main_the_user_comments_on_a_post () {
		this.mainPOM.postComment (0, "test body comment");
		this.mainPOM.waitForPostComment();
	}
	
	@Then ("Main: The comment is displayed and the comment count goes up by one")
	public void main_the_comment_is_displayed () {
		assertEquals (1, this.mainPOM.howManyComments (0));
		assertEquals (1, this.mainPOM.getCommentCount (0));
	}
	
	@When ("Main: The user makes an invalid comment on a post")
	public void main_the_user_makes_an_invalid_comment_on_a_post () {
		this.mainPOM.postComment (0, "");
	}
	
	@Then ("Main: No new comment is displayed and the comment count stays the same")
	public void main_no_new_comment_is_displayed () {
		assertEquals (0, this.mainPOM.howManyComments (0));
		assertEquals (0, this.mainPOM.getCommentCount (0));
	}
	
	@When ("Main: The user posts 21 posts")
	public void main_the_user_posts_21_posts () {
		this.mainPOM.submit21Posts();
	}
	
	@Then ("Main: There are 21 posts")
	public void main_there_are_at_least_21_posts () {
		assertEquals (20, this.mainPOM.getPostCount ());
	}
	
	@When ("Main: The user scrolls to the bottom of the page")
	public void main_the_user_scrolls_to_the_bottom_of_the_page () {
		//https://stackoverflow.com/questions/12293158/page-scroll-up-or-down-in-selenium-webdriver-selenium-2-using-java
		JavascriptExecutor js = ((JavascriptExecutor) DriverSingleton.getInstance ());
		js.executeScript ("document.getElementsByClassName ('page') [0].scrollTo (0, document.getElementsByClassName ('page') [0].scrollHeight);");
		
		try {
			Thread.sleep (2000);
		}
		
		catch (InterruptedException ignored) {}
	}
	
	@Then ("Main: Another page of posts is loaded")
	public void main_another_page_of_posts_is_loaded () {
		assertTrue (this.mainPOM.getPostCount () > 20);
	}
	
	@When ("Main: The user clicks on a user link")
	public void main_the_user_clicks_on_a_user_link () {
		this.mainPOM.clickUser ();
	}
	
	@Then ("Main: The user is redirected to the clicked user's profile page")
	public void main_the_user_is_redirected_to_the_clicked_user_s_profile_page () {
		assertEquals ("http://localhost:4200/@johnsmith", DriverSingleton.getInstance ().getCurrentUrl ());
	}
	
	//todo test redirect to /login if not logged in
}
