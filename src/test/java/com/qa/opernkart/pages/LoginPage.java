package com.qa.opernkart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	// 1. String Locator - OR (Object repository)
	
	private String email = "input#input-email";
	private String password1 = "input#input-password";
	private String loginButton = "input[value='Login']";
	private String forgotPassLink = "a:has-text('Forgotten Password')";
	private String logoutLink = "(//a[text()='Logout'])[2]";
	
	// 2. Page constructor to get the page reference values

		public LoginPage(Page page) {
			this.page = page;
		}
		
	// 3. Page action/method
		
		public String getLoginPageTitle() {
			String title = page.title();
			return title;
		}
		
		public boolean isForgotPwdLinkExist() {
			boolean link = page.isVisible(forgotPassLink);
			return link;
		}
		
		public boolean doLogin(String username,String password) {
			System.out.println("Username is :"+username +"password is :"+password);
			page.fill(email,username);
			page.fill(password1, password);
			page.click(loginButton);
			if(page.isVisible(logoutLink)) {
				System.out.println("User successfully logged in...!!");
				return true;
			}
			return false;
				
		}
		
}
