package testcases;

import java.util.List;

import com.microsoft.playwright.ElementHandle;

import utilities.WebUtility;

public class LinksTest {

	public static void main(String[] args) {
		WebUtility.launchBrowser("edge");
		WebUtility.navigateURL("https://www.wikipedia.org");
		List<ElementHandle> links = WebUtility.page.querySelectorAll("a");
		links.forEach(link->{System.out.println(link.innerText()+"=>"+link.getAttribute("href"));});
		WebUtility.closeBrowser();
	}

}
