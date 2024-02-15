package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth_Login {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcontext =browser.newContext();
		Page page = brcontext.newPage();
		page.navigate("https://www.instagram.com/");
		page.locator("input[name='username']").fill("imvinothoffl_");
		page.locator("input[name='password']").fill("186915854051");
		page.click("button:has-text('Log in')");
		
		page.click("button:has-text('Save info')");
		page.click("button:has-text('Not Now')");
		
		brcontext.
		storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("application.json")));
		
		
		
	}

}
