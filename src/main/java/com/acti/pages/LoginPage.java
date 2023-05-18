package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Name: LoginPage
 * Description: Manage the locators and methods of loginPage
 * Developed By: Sondos
 * Reviewed By: Srini
 * Date Reviewed: 05-16-2023
 * */

public class LoginPage extends DriverScript {

//********************************** Page Locators ****************************************

	@FindBy(id = "username") WebElement usernameTextbox;
	@FindBy(name = "pwd") WebElement passwordTexbsox;
	@FindBy(xpath = "//div[text()='Login ']") WebElement loginButton;
	@FindBy(className = "errormsg") WebElement errmsgText;
	@FindBy(linkText = "Forgot your password?") WebElement forgotpassword;
	@FindBy(xpath = "//div[@class= 'atLogoImg']") WebElement actiImg;

//********************************** Page Initilization ****************************************

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//********************************** Page Methods ****************************************
	public void enterUsername(String username) {
		usernameTextbox.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTexbsox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getErrormsgText() {
		return errmsgText.getText();
	}

	public boolean veriyForgotpasswordLink() {
		return forgotpassword.isDisplayed();
	}

	public boolean verifyActiImg() {
		return actiImg.isDisplayed();
	}

	public String getTilePage() {
		return driver.getTitle();
	}

}
