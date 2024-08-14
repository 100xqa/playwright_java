package utilities;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class WebUtility {
	
	public static Playwright playwright = null;
	public static Browser browser = null;
	public static BrowserContext browserContext = null;
	public static Page page = null;
	
	public static void launchBrowser(String browserName) {
		playwright = Playwright.create();
		LaunchOptions launchOptions = new BrowserType.LaunchOptions();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		switch(browserName) {
		case "chrome" -> browser = playwright.chromium().launch(launchOptions.setChannel("chrome").setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")).setHeadless(false).setArgs(arguments));
		case "edge" -> browser = playwright.chromium().launch(launchOptions.setChannel("msedge").setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe")).setHeadless(false).setArgs(arguments));
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
	
	public static void navigateURL(String url) {
		page.navigate(url);
		String title = page.title();
		System.out.println(title);
	}
	
	public static void closeBrowser() {
		page.close();
		browser.close();
		playwright.close();
	}

}
