package testcases;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class MaximizingWindow {
	
	static Playwright playwright = null;
	static Browser browser = null;
	static BrowserContext browserContext = null;
	static Page page = null;

	public static void main(String[] args) {
		launchBrowser("webkitheadless");
		navigateURL();
		closeBrowser();
	}	
	
	private static void launchBrowser(String browserName) {
		playwright = Playwright.create();
		LaunchOptions launchOptions = new BrowserType.LaunchOptions();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		switch(browserName) {
		case "chrome" -> browser = playwright.chromium().launch(launchOptions.setChannel("chrome").setHeadless(false).setArgs(arguments));
		case "edge" -> browser = playwright.chromium().launch(launchOptions.setChannel("msedge").setHeadless(false).setArgs(arguments));
		case "firefox" -> browser = playwright.firefox().launch(launchOptions.setChannel("firefox").setHeadless(false).setArgs(arguments));
		case "webkit" -> browser = playwright.webkit().launch(launchOptions.setChannel("webkit").setHeadless(false).setArgs(arguments));
		case "chromeheadless" -> browser = playwright.chromium().launch(launchOptions.setChannel("chrome").setHeadless(true).setArgs(arguments));
		case "edgeheadless" -> browser = playwright.chromium().launch(launchOptions.setChannel("msedge").setHeadless(true).setArgs(arguments));
		case "firefoxheadless" -> browser = playwright.firefox().launch(launchOptions.setChannel("firefox").setHeadless(true).setArgs(arguments));
		case "webkitheadless" -> browser = playwright.webkit().launch(launchOptions.setChannel("webkit").setHeadless(true).setArgs(arguments));
		}		
		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = browserContext.newPage();
	}
	
	private static void navigateURL() {
		page.navigate("http://way2automation.com");
		String title = page.title();
		System.out.println(title);
	}
	
	private static void closeBrowser() {
		page.close();
		browser.close();
		playwright.close();
	}

}
