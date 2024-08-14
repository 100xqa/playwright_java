package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowserTest {

	public static void main(String[] args) {
		try {
			Playwright playwright = Playwright.create();
			LaunchOptions launchOptions = new BrowserType.LaunchOptions();
			Browser browser = playwright.chromium().launch(launchOptions.setHeadless(false));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));
			Page page = context.newPage();
			page.navigate("https://www.way2automation.com");
			String title = page.title();
			System.out.println(title);
			page.close();
			browser.close();
			playwright.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
