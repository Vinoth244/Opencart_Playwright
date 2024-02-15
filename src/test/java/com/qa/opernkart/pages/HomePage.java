package com.qa.opernkart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	// 1. String Locator - OR (Object repository)

	private String search = "input[name='search']";
	private String searchButton = "div#search button";
	private String searchHeader = "div#content h1";
	private String loginLink = "a:has-text('Login')";
	private String myAccLink = "a[title='My Account']";
	
	// 2. Page constructor to get the page reference values

	public HomePage(Page page) {
		this.page = page;
	}

	// 3. Page action/method

	public String getHomepageTitle() {
		String title = page.title();
		System.out.println("Page title is :" + title);
		return title;
	}

	public String getPageURL() {
		String URL = page.url();
		System.out.println("Page URL is :" + URL);
		return URL;
	}

	public String searchMethod(String productName) {
		page.fill(search, productName);
		page.click(searchButton);
		String header = page.textContent(searchHeader);
		System.out.println(header);
		return header;

	}
	
	public  LoginPage navigateToLoginPage() {
		page.click(myAccLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
}
