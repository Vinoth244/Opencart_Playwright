package com.playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;

public class WindowPopup {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); 
		BrowserContext browserContext= browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		Page popup = page.waitForPopup(() ->{
//			
//			page.click("a[href='https://www.linkedin.com/company/orangehrm/mycompany/']");
//			
//		});
//		
//		page.waitForLoadState();
//		System.out.println(popup.title());
//		popup.close();
//		System.out.println(page.title());
		
		Page popup = page.waitForPopup(() ->{
			
			page.click("a[target='_blank']");
			
		});
		
		page.waitForLoadState();
		popup.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		System.out.println(popup.title());
		popup.close();
		System.out.println(page.title());
	
	}
}
