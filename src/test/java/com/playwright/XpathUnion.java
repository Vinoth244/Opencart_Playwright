package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathUnion {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.flipkart.com/");
		
		Locator elements =page.locator("//a[text()='More'] | //a[text()='Cart']");
		System.out.println(elements.textContent());
		elements.click();

	}

}
