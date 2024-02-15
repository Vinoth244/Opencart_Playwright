package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {

	static Page page;
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		//page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
		selectUser("Joe.Root");
		selectUser("John.Smith");
		selectUser("Kevin.Mathews");
		
//		String jobRole =	page.locator("td:right-of(:text('Joe.Root'))").first().textContent();
//		System.out.println(jobRole);
		
//		System.out.println(jobRolre("Joe.Root"));
		
		Locator getAboveUser =page.locator("a:has-text('Jordan.Mathews'):above(:text('Kevin.Mathews'))");
		System.out.println(getAboveUser.textContent());
		
		Locator getBelowUser =page.locator("a:has-text('Jasmine.Morgan'):below(:text('Garry.White'))");
		System.out.println(getBelowUser.textContent());
		
		Locator nearElements = page.locator("td:near(:text('Garry.White'),200)");
		System.out.println(nearElements.count());
		List<String> listOfElements = nearElements.allInnerTexts();
		for(String ele:listOfElements) {
			System.out.println(ele);
		}
	}
	
	public static void selectUser(String userName) {
		
		page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
		
	}
	
	public static String jobRolre(String userName) {
		
		String jobRole =	page.locator("td:right-of(:text('"+userName+"'))").first().textContent();
		return jobRole;
	}

}
