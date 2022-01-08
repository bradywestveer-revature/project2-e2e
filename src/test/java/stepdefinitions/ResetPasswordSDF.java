package stepdefinitions;

import poms.ResetPasswordPOM;

import static org.junit.jupiter.api.Assertions.*;

public class ResetPasswordSDF {
	final ResetPasswordPOM resetPasswordPOM;
	
	public ResetPasswordSDF () {
		this.resetPasswordPOM = new ResetPasswordPOM (DriverSingleton.getInstance ());
	}
}
