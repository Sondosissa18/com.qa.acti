package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acti.pages.LoginPage;

public class LoginPageTest extends BaseTest {


	@Test
	public void testLoginPageTitle() {

		String expected = "actiTIME - Login";
		String actual = lp.getTilePage();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void testActiImgisDisplayed() {
		boolean flag = lp.verifyActiImg();
		Assert.assertTrue(flag);
	}

	@Test
	public void testForgotPasswordDisplayed() {
		initApplication();
		LoginPage lp = new LoginPage();
		boolean flag = lp.veriyForgotpasswordLink();
		Assert.assertTrue(flag);
	}

	@Test
	public void testLginFunction() {
		lp.enterUsername("admin");
		lp.enterPassword("manger");
		lp.clickLoginButton();

	}

	@Test
	public void testLoginInvalidCredentials() throws InterruptedException {
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		Thread.sleep(3000);
		String errMsg = lp.getErrormsgText();
		System.out.println(errMsg);
		Assert.assertTrue(errMsg.contains("Username or Password is invalid"));

	}
}
