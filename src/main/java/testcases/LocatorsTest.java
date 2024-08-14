package testcases;


import utilities.WebUtility;

public class LocatorsTest {

	public static void main(String[] args) {
		WebUtility.launchBrowser("chrome");
		WebUtility.navigateURL("https://www.gmail.com");
		WebUtility.page.locator("#identifierId").fill("trainer@way2automation.com");
		WebUtility.page.locator("text=Next").click();
		WebUtility.page.locator("[type=password]").fill("Gaya3@143");
		WebUtility.page.locator("text=Next").click();
	}

}
