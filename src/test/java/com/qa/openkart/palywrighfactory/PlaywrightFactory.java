package com.qa.openkart.palywrighfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	Properties prop;
	
	private static ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
	private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> threadLocaBrowsercontext = new ThreadLocal<>();
	private static ThreadLocal<Playwright> threadLocaBrowserPlaywright = new ThreadLocal<>();
	
	public static Playwright getPlaywright() {
		return threadLocaBrowserPlaywright.get();
	}
	public static Browser getBrowser() {
		return threadLocalBrowser.get();
	}
	public static BrowserContext getBrowserContext() {
		return threadLocaBrowsercontext.get();
	}
	public static Page getPage() {
		return threadLocalPage.get();
	}

	public Page initializeMethod(Properties prob) {
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is :" + browserName);

//		playwright = Playwright.create();
		threadLocaBrowserPlaywright.set(Playwright.create());

		switch (browserName.toLowerCase()) {

		case "chromium":
//			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			threadLocalBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "firefox":
//			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			threadLocalBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
//			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			threadLocalBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
//			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			threadLocalBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		default:
			System.out.println("Enter the right browserName");
			break;

		}

//		browserContext = browser.newContext();
		threadLocaBrowsercontext.set(getBrowser().newContext());
		
//		page = browsercontext.newPage();
		threadLocalPage.set(getBrowserContext().newPage());
		getPage().navigate(prop.getProperty("url").trim());
		return getPage();

	}
	
	/**
	 * this method is used to initialize from the properties file
	 * @throws IOException 
	 */
	public Properties initproperties() throws IOException {
		
		FileInputStream ip = new 
				FileInputStream("C:\\Users\\Admin\\eclipse-workspace1\\Playwright_Practice"
						+ "\\src\\test\\resources\\config/config.properties");
			prop = new Properties();
			prop.load(ip);
			return prop;
			
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}

}
