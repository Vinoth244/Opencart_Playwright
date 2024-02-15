package com.qa.openkart.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.openkart.palywrighfactory.PlaywrightFactory;
import com.qa.opernkart.pages.HomePage;
import com.qa.opernkart.pages.LoginPage;

public class BaseTest {
	
	PlaywrightFactory playwrightfactory;
	Page page;
	protected HomePage homepage;
	protected LoginPage loginPage;
	protected Properties prop;
	
	@BeforeTest
	public void setupMethod() throws IOException {
		playwrightfactory = new PlaywrightFactory();
		prop = playwrightfactory.initproperties();
		page = playwrightfactory.initializeMethod(prop);
		homepage = new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
