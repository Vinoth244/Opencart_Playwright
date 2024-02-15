package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JS_HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
	
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.onDialog(dialog -> {
			
			String textMessage = dialog.message();
			System.out.println(textMessage);
			dialog.accept("This is an alert");
			
			
		});
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.locator("button:text('Click for JS Alert')").click();
		String text = page.textContent("p[id=result]");
		System.out.println(text);
		
		page.locator("button:text('Click for JS Prompt')").click();
		text = page.textContent("p[id=result]");
		System.out.println(text);
		
		page.locator("button:text('Click for JS Confirm')").click();
		text = page.textContent("p[id=result]");
		System.out.println(text);
		
		page.close();
		browser.close();
		playwright.close();
		

	}

}
