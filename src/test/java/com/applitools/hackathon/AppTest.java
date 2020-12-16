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


public class AppTest {

	public static void main(String[] args) {
		// Create a new chrome web driver
		WebDriver webDriver = new ChromeDriver();

		// Create a runner with concurrency of 1
		VisualGridRunner runner = new VisualGridRunner(1);

		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		Eyes eyes = new Eyes(runner);

		setUp1and2(eyes);

		Tests tests = new Tests();

		try {
			Part1 part1 = new Part1();

			tests.mainPage(webDriver, eyes, part1.V1_PRODUCT_VERSION);
			tests.filterByColor(webDriver, eyes, part1.V1_PRODUCT_VERSION);
			tests.productDetails(webDriver, eyes, part1.V1_PRODUCT_VERSION);

		} finally  {
			eyes.abortAsync();
		}

		setUp1and2(eyes);

		try {
			Part2 part2 = new Part2();

			tests.mainPage(webDriver, eyes, part2.DEV_BRANCH_VERSION);
			tests.filterByColor(webDriver, eyes, part2.DEV_BRANCH_VERSION);
			tests.productDetails(webDriver, eyes, part2.DEV_BRANCH_VERSION);

		} finally  {
			eyes.abortAsync();
		}

		setUp3(eyes);
		try {

			Part3 part3 = new Part3();

			tests.mainPage(webDriver, eyes, part3.FINAL_PRODUCTION_VERSION);
			tests.filterByColor(webDriver, eyes, part3.FINAL_PRODUCTION_VERSION);
			tests.productDetails(webDriver, eyes, part3.FINAL_PRODUCTION_VERSION);

		} finally  {
			eyes.abortAsync();
		}

	}

	public static void setUp1and2(Eyes eyes) {

		Configuration config = new Configuration();
		config = Config.getConfigForTest1And2();
		// Set the configuration object to eyes
		eyes.setConfiguration(config);

	}

	public static void setUp3(Eyes eyes) {
		Configuration config = new Configuration();
		config = Config.getConfigForTest3();
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
