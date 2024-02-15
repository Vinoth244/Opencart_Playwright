package com.playwright;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcontext = browser.
				newContext(new Browser.NewContextOptions().
						setRecordVideoDir(Paths.get("myvideos/")));
		Page page= brcontext.newPage();
		page.navigate("https://www.flipkart.com/");
		
		page.fill("input[name='q']","Pants for men");
		Thread.sleep(3000);
		Locator searchOption = page.locator("form[action='/search'] ul li");
		System.out.println(searchOption.count());
//		List<String> text = searchOption.allInnerTexts();
//		System.out.println(text.size());
//		
//			if(searchOption.textContent().contains("jeans for men")) {
//				searchOption.click();
//			}
		brcontext.close();
		page.close();
		browser.close();
		
		
		
		
	}

}
