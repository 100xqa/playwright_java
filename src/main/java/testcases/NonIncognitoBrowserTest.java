package testcases;

import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Page;

public class NonIncognitoBrowserTest {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchPersistentContextOptions launchPersistentContextOptions = new BrowserType.LaunchPersistentContextOptions();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get("C:\\Users\\Satish\\AppData\\Local\\Google\\Chrome\\User Data\\Default"),launchPersistentContextOptions.setHeadless(false).setViewportSize(null).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		Page page = browserContext.newPage();
		
		page.navigate("http://way2automation.com");
		String title = page.title();
		System.out.println(title);
		
		page.close();
		playwright.close();
	}

}
