package testcases;


import com.microsoft.playwright.Locator;

import utilities.WebUtility;

public class CheckboxesTest {

	public static void main(String[] args) {
		WebUtility.launchBrowser("edge");
		WebUtility.navigateURL("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		Locator checkboxes = WebUtility.page.locator("[type='checkbox']");
		System.out.println(checkboxes.count());
		for(int i=0;i<checkboxes.count();i++) {
			checkboxes.nth(i).check();
		}
		WebUtility.closeBrowser();
	}

}
