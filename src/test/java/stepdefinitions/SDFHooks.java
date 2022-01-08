package stepdefinitions;

import io.cucumber.java.After;

public class SDFHooks {
	//runs after every scenario
	@After
	public void tearDown () {
		DriverSingleton.quitInstance ();
	}
}
