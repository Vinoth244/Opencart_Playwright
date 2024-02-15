package com.playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.flipkart.com/");
//		page.locator("a:has-text('Become a Seller'),"
//				+ "a:has-text('become a seller'), "
//				+ "a:has-text('Became a sEller')").first().click();
//		
		// multiple elements 
		
		
		
		Locator multElements = page.locator("a:has-text('Become a Seller'), div:has-text('More'), span:has-text('Cart')");
		System.out.println(multElements.count());
		
		String text ="";
		
		for (int i=0;i<multElements.count(); i++) {
			
			 text =multElements.nth(i).textContent();
			 System.out.println(text);
		}
		
	}

}
