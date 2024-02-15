package com.qa.openkart.test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@Test (priority =1)
	public void loginPagenavigationTest() {
		loginPage = homepage.navigateToLoginPage();
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("Title is :"+actualTitle);
		Assert.assertEquals(actualTitle,AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test (priority =2)
	public void forgotPwdLinkExist() {
		assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test (priority =3)
	public void loginTest() {
		
		boolean status = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertTrue(status);
	}
	
}
