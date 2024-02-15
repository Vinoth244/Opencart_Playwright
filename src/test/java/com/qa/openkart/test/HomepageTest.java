package com.qa.openkart.test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;

public class HomepageTest extends BaseTest{

	@Test(priority = 1)
	public void homepageTitle() {
		String actualTitle = homepage.getHomepageTitle();
		Assert.assertEquals(actualTitle,AppConstants.HOME_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void homepageURL() {
		String actualURL = homepage.getPageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}

	@DataProvider(name = "productName")
	public Object[][] productName() {
		return new Object[][] { { "Samsung" }, { "Iphone" } };
	}

	@Test(priority = 3, dataProvider = "productName")
	public void search(String productName) throws InterruptedException {
		Thread.sleep(3000);
		String actualproduct = homepage.searchMethod(productName);
		Assert.assertEquals(actualproduct, "Search - " + productName);
	}

	
}
