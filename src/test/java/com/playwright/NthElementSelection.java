package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelection {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.bigbasket.com/");
		
		Locator first_element =page.locator("div.container li a >> nth=0");
		String firstele = first_element.textContent();
		System.out.println(firstele);
		
		Locator last_element =page.locator("div.container li a >> nth=-1");
		String lastele =last_element.textContent();
		System.out.println(lastele);
		
	}

}
