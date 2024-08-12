package testcases;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class MaximizingWindow {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions launchOptions = new BrowserType.LaunchOptions();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(launchOptions.setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.navigate("http://way2automation.com");
		String title = page.title();
		System.out.println(title);
		page.close();
		browser.close();
		playwright.close();
	}

}
