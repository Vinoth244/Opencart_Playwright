package com.playwright;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUploadHandle {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
//		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
//		// upload a single file 
//		page.setInputFiles("input#filesToUpload", Paths.get("application.json"));
//		Thread.sleep(3000);
//		page.setInputFiles("input#filesToUpload", new Path[0]);
		
		// upload a multiple file 
		
//		page.setInputFiles("input#filesToUpload", new Path[] 
//				{
//						Paths.get("application.json"),
//						Paths.get("C:\\Users\\Admin\\OneDrive\\Documents\\apidata.csv"),
//						Paths.get("C:\\Users\\Admin\\OneDrive\\Pictures\\icicicci.png")
//				});
//		
//		Thread.sleep(3000);
//		page.setInputFiles("input#filesToUpload", new Path[0]);
		
		// run time file upload 
		
//		page.setInputFiles("input#filesToUpload", 
//				new FilePayload("Vinoth.text","text/plain","this is vinoth".getBytes(StandardCharsets.UTF_8)));
		
		// read the content of file 
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		page.setInputFiles("input[name=upfile]", 
				new FilePayload("Vinoth.text","text/plain","this is vinoth".getBytes(StandardCharsets.UTF_8)));
		
		page.locator("input[type='submit']").click();
	}

}
