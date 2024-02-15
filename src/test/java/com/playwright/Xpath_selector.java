package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Xpath_selector {

	public static void main(String[] args) {
	
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.flipkart.com/");
		
		// basic xpath
		page.locator("xpath=//input[@name='q']").fill("Iphone");
		
		// using contains xpath
		
		Locator linksFlipkar = page.locator("//a[contains(text(),'Flipkart')]");
		System.out.println(linksFlipkar.count());
		List<String> text =linksFlipkar.allInnerTexts();
		
		for(String ele:text) {
			System.out.println(ele);
		}
		
		// Xpath axis 
		
		page.locator("//div[@aria-label='Fashion']/preceding::span[text()='Grocery']").click();
	
	}

}
