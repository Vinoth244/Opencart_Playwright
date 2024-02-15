package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormUsingRelativeLocator {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
		
		page.locator("input:below(:text('We Just Need a Few Details.'))").first().fill("Vinoth");
		
	}

}
