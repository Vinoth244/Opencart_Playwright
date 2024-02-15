package com.playwright;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Downloadfile {

public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.jenkins.io/download/");
		
		Download download = page.waitForDownload(()-> {
			page.locator("span:has-text(' Generic Java package (.war)')").first().click();
		});
		
		System.out.println(download.url());
		String path = download.path().toString();
		System.out.println(path);
		
		download.saveAs(Paths.get("C://Jenkins SetupFile/jenkins.war"));
		

	}

}
