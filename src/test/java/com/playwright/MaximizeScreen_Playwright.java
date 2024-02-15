package com.playwright;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeScreen_Playwright {

	public static void main(String[] args) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width =(int) screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		System.out.println(width +":"+ height);
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcontext =browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		Page page = brcontext.newPage();
		page.navigate("https://www.flipkart.com/");
		
	}

}
