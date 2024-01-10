package FrameWork.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWork.baseComponents.Base;

public class ErrorValidation extends Base{
	
	@Test(groups = {"Error Handling"})
	public void loginError() {
		landingPage.loginApplication("naveen@gfffmail.com", "Naveen@9797");
		Assert.assertEquals("Incorrect email or password.", landingPage.errormessageText());
		
	}

}
