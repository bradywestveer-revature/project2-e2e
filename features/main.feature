Feature: Main Page
	
	Background:
		Given Login: A user is on the login page
		When Login: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page

	Scenario: The user scrolls to the bottom of the page and another page of posts is loaded
		When Main: The user posts 21 posts
		Then Main: There are 21 posts
		When Main: The user scrolls to the bottom of the page
		Then Main: Another page of posts is loaded
	
	Scenario: The user adds an image to their draft post and the image preview is displayed
		When Main: The user adds an image to their draft post
		Then Main: The image preview is displayed
	
	Scenario: The user clicks the remove button on an image preview and the image preview is removed
		When Main: The user adds an image to their draft post
		When Main: The user clicks the remove button on the image preview
		Then Main: The image preview is removed
	
	Scenario: The user posts an invalid post and an error message is shown
		When Main: The user posts an invalid post
		Then Main: An invalid post error message is shown
	
	Scenario: The user posts with a body and the post is displayed with a body
		When Main: The user posts with a body
		Then Main: The post is displayed with a body
	
	Scenario: The user posts with a body and images and the post is displayed with a body and images
		When Main: The user posts with a body and images
		Then Main: The post is displayed with a body and images
	
	Scenario: The user posts with a body and a video link and the post is displayed with a body and the video
		When Main: The user posts with a body and a video link
		Then Main: The post is displayed with a only the first video
	
	Scenario: The user posts with a body and multiple video links and the post is displayed with only the first video
		When Main: The user posts with a body and multiple video links
		Then Main: The post is displayed with a only the first video
	
	Scenario: The user posts with a body and images and a video link and the post is displayed with images and only the first video
		When Main: The user posts with a body and images and a video link
		Then Main: The post is displayed with images and only the first video
	
	Scenario: The user posts with a body and images and multiple video links and the post is displayed with images and only the first video
		When Main: The user posts with a body and images and multiple video links
		Then Main: The post is displayed with images and only the first video
	
	Scenario: The user clicks on the comment button on a post twice and the comments open and close
		When Main: The user posts with a body
		Then Main: The post is displayed with a body
		When Main: The user clicks on the comment button on a post
		Then Main: The comments open on the post
		When Main: The user clicks on the comment button on a post
		Then Main: The comments close on the post
	
	Scenario: The user clicks on the like button on a post twice and the like number increases by one and then decreases by one
		When Main: The user posts with a body
		Then Main: The post is displayed with a body
		When Main: The user clicks on the like button on a post
		Then Main: The post like count increases by one
		Then Main: The user clicks on the like button on a post
		Then Main: The post like count decreases by one
	
	Scenario: The user comments on a post and the comment is shown
		When Main: The user posts with a body
		Then Main: The post is displayed with a body
		When Main: The user clicks on the comment button on a post
		When Main: The user comments on a post
		Then Main: The comment is displayed and the comment count goes up by one
	
	Scenario: The user makes an invalid comment on a post and no new comment is displayed
		When Main: The user posts with a body
		Then Main: The post is displayed with a body
		When Main: The user clicks on the comment button on a post
		When Main: The user makes an invalid comment on a post
		Then Main: No new comment is displayed and the comment count stays the same
	
	Scenario: The user clicks on a user link and is redirected to the clicked user's profile page
		When Main: The user clicks on a user link
		Then Main: The user is redirected to the clicked user's profile page