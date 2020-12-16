package com.applitools.hackathon;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) {
		// Create a new chrome web driver
		WebDriver webDriver = new ChromeDriver();

		// Create a runner with concurrency of 1
		VisualGridRunner runner = new VisualGridRunner(1);

		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		Eyes eyes = new Eyes(runner);

		setUp(eyes);

		try {
			Part1 part1 = new Part1();
			Part2 part2 = new Part2();
			Part3 part3 = new Part3();

			part1.mainPage(webDriver, eyes, part1.V1_PRODUCT_VERSION);
			part1.filterByColor(webDriver, eyes, part1.V1_PRODUCT_VERSION);
			part1.productDetails(webDriver, eyes, part1.V1_PRODUCT_VERSION);
			part1.mainPage(webDriver, eyes, part2.DEV_BRANCH_VERSION);
			part1.filterByColor(webDriver, eyes, part2.DEV_BRANCH_VERSION);
			part1.productDetails(webDriver, eyes, part2.DEV_BRANCH_VERSION);
			part1.mainPage(webDriver, eyes, part3.FINAL_PRODUCTION_VERSION);
			part1.filterByColor(webDriver, eyes, part3.FINAL_PRODUCTION_VERSION);
			part1.productDetails(webDriver, eyes, part3.FINAL_PRODUCTION_VERSION);




	}

	public static void setUp(Eyes eyes) {

		// Initialize eyes Configuration
		Configuration config = new Configuration();

		// You can get your api key from the Applitools dashboard
		config.setApiKey("q98eCNGC3ydV9wjQS7TLkpJkVhCC8pWotI100BlADj5eUw110");

		// create a new batch info instance and set it to the configuration
		config.setBatch(new BatchInfo("HolidayShopping"));

		// Add browsers with different viewports
		config.addBrowser(1200, 800, BrowserType.CHROME);
		config.addBrowser(1200, 800, BrowserType.FIREFOX);
		config.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
		config.addBrowser(1200, 800, BrowserType.SAFARI);
		config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

		// Set the configuration object to eyes
		eyes.setConfiguration(config);

	}



	private static void tearDown(WebDriver webDriver, VisualGridRunner runner) {
		// Close the browser
		webDriver.quit();

		// we pass false to this method to suppress the exception that is thrown if we
		// find visual differences
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(allTestResults);
	}

}
