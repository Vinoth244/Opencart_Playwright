package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasElement {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
		
		Locator Countries = page.locator("select[id=Form_getForm_Country]:has(option[value=India])");
		List<String> listOfCountries =  Countries.allInnerTexts();
		System.out.println(listOfCountries.size());
		
		for(String ele:listOfCountries) {
			System.out.println(ele);
		}
	}

}
