package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DynamicWeb_Table {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
//		page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
//		
//		Locator row = page.locator("table#example tr");
//		row.locator(":scope", new Locator.LocatorOptions().setHasText("Bradley Greer")).
//		locator("td.select-checkbox").click();
//		
//		List<String> rowText =row.locator(":scope").allInnerTexts();
//		for (String ele:rowText) {
//			System.out.println(ele);
//		}
		
		page.navigate("https://primeng.org/");
		
		Locator row = page.locator("table#pn_id_1-table tr");
		row.locator(":scope", new Locator.LocatorOptions().setHasText("Josephine Darakjy")).
		locator(".p-checkbox").click();
		
		List<String>rowText = row.locator(":scope").allInnerTexts();
		for(String ele:rowText) {
			System.out.println(ele);
		}
		

	}

}
