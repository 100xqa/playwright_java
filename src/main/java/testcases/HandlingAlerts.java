package testcases;

import utilities.WebUtility;

public class HandlingAlerts {

	public static void main(String[] args) {
		WebUtility.launchBrowser("chrome");
		WebUtility.navigateURL("https://mail.rediff.com/cgi-bin/login.cgi");
		WebUtility.page.onDialog(dialog -> {
			dialog.accept();
			System.out.println(dialog.message());
		});
		WebUtility.page.locator("[type='submit']").click();
	}

}
