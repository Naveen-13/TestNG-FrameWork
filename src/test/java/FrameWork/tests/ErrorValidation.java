package FrameWork.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import FrameWork.baseComponents.Base;
import FrameWork.baseComponents.Retry;

public class ErrorValidation extends Base{
	
	@Test(groups = {"Error Handling"}, retryAnalyzer = Retry.class)
	public void loginError() {
		landingPage.loginApplication("naveen@gfffmail.com", "Naveen@9797");
		Assert.assertEquals("Incorrectt email or password.", landingPage.errormessageText());
		
	}

}
