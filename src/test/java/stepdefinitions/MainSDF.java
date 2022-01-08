package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.MainPOM;

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
	public void main_the_user_adds_an_image_to_their_draft_post () {
		
	}
	
	@Then ("Main: The image preview is displayed")
	public void main_the_image_preview_is_displayed () {
		
	}
	
	@When ("Main: The user clicks the remove button on the image preview")
	public void main_the_user_clicks_the_remove_button_on_the_image_preview () {
		
	}
	
	@Then ("Main: The image preview is removed")
	public void main_the_image_preview_is_removed () {
		
	}
	
	@When ("Main: The user posts an invalid post")
	public void main_the_user_posts_an_invalid_post () {
		
	}
	
	@Then ("Main: An invalid post error message is shown")
	public void main_an_invalid_post_error_message_is_shown () {
		
	}
	
	@When ("Main: The user posts with a body")
	public void main_the_user_posts_with_a_body () {
		
	}
	
	@Then ("Main: The post is displayed with a body")
	public void main_the_post_is_displayed_with_a_body () {
		
	}
	
	@When ("Main: The user posts with a body and images")
	public void main_the_user_posts_with_a_body_and_images () {
		
	}
	
	@Then ("Main: The post is displayed with a body and images")
	public void main_the_post_is_displayed_with_a_body_and_images () {
		
	}
	
	@When ("Main: The user posts with a body and a video link")
	public void main_the_user_posts_with_a_body_and_a_video_link () {
		
	}
	
	@Then ("Main: The post is displayed with a body and only the first video")
	public void main_the_post_is_displayed_with_a_body_and_only_the_first_video () {
		
	}
	
	@When ("Main: The user posts with a body and multiple video links")
	public void main_the_user_posts_with_a_body_and_multiple_video_links () {
		
	}
	
	@When ("Main: The user posts with a body and images and a video link")
	public void main_the_user_posts_with_a_body_and_images_and_a_video_link () {
		
	}
	
	@Then ("Main: The post is displayed with a body and images and only the first video")
	public void main_the_post_is_displayed_with_a_body_and_images_and_only_the_first_video () {
		
	}
	
	@When ("Main: The user posts with a body and images and multiple video links")
	public void main_the_user_posts_with_a_body_and_images_and_multiple_video_links () {
		
	}
	
	@When ("Main: The user clicks on the comment button on a post")
	public void main_the_user_clicks_on_the_comment_button_on_a_post () {
		
	}
	
	@Then ("Main: The comments open on the post")
	public void main_the_comments_open_on_the_post () {
		
	}
	
	@Then ("Main: The comments close on the post")
	public void main_the_comments_close_on_the_post () {
		
	}
	
	@When ("Main: The user clicks on the like button on a post")
	public void main_the_user_clicks_on_the_like_button_on_a_post () {
		
	}
	
	@Then ("Main: The post like count increases by one")
	public void main_the_post_like_count_increases_by_one () {
		
	}
	
	@Then ("Main: The post like count decreases by one")
	public void main_the_post_like_count_decreases_by_one () {
		
	}
	
	@When ("Main: The user comments on a post")
	public void main_the_user_comments_on_a_post () {
		
	}
	
	@Then ("Main: The comment is displayed")
	public void main_the_comment_is_displayed () {
		
	}
	
	@When ("Main: The user makes an invalid comment on a post")
	public void main_the_user_makes_an_invalid_comment_on_a_post () {
		
	}
	
	@Then ("Main: No new comment is displayed")
	public void main_no_new_comment_is_displayed () {
		
	}
	
	@When ("Main: The user scrolls to the bottom of the page")
	public void main_the_user_scrolls_to_the_bottom_of_the_page () {
		
	}
	
	@Then ("Main: Another page of posts is loaded")
	public void main_another_page_of_posts_is_loaded () {
		
	}
	
	@When ("Main: The user clicks on a user link")
	public void main_the_user_clicks_on_a_user_link () {
		
	}
	
	@Then ("Main: The user is redirected to the clicked user's profile page")
	public void main_the_user_is_redirected_to_the_clicked_user_s_profile_page () {
		
	}
	
	//todo test redirect to /login if not logged in
}
