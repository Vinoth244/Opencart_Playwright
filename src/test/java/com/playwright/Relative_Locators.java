package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Relative_Locators {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.flipkart.com/");
		
		String text = page.
		locator("div:has-text('Shop Now!'):below(div:has-text('Top Mirrorless Cameras'))").first().textContent();
		System.out.println(text);
		
		String text1 = page.
				locator("div:has-text('From ₹3999'):left-of(div:has-text('Premium PowerBanks'))").
				first().textContent();
		System.out.println(text1);
				
	}

}
