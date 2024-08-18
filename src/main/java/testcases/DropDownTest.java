package testcases;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

import utilities.WebUtility;

public class DropDownTest {

	public static void main(String args[]) {
		WebUtility.launchBrowser("edge");
		WebUtility.navigateURL("https://www.wikipedia.org");
		WebUtility.page.selectOption("#searchLanguage","hi");
		WebUtility.page.selectOption("select", new SelectOption().setLabel("Eesti"));
		WebUtility.page.selectOption("select", new SelectOption().setIndex(2));
		List<ElementHandle> elementHandles = WebUtility.page.locator("//option").elementHandles();
		for(ElementHandle element: elementHandles) {
			System.out.println(element.textContent());
		}
		Locator values = WebUtility.page.locator("select > option");
		System.out.println(values.count());
		
		List<ElementHandle> ehList = WebUtility.page.querySelectorAll("select > option");
		ehList.forEach(eh->{System.out.println(eh.getAttribute("lang"));});
		WebUtility.closeBrowser();
	}

}
