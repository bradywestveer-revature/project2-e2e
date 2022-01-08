package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.ProfilePOM;

public class ProfileSDF {
	final ProfilePOM profilePOM;
	
	public ProfileSDF () {
		this.profilePOM = new ProfilePOM (DriverSingleton.getInstance ());
	}
	

}
