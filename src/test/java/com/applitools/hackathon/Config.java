package com.applitools.hackathon;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.selenium.Configuration;

public class Config {

    private static String APPLITOOLS_KEY = "q98eCNGC3ydV9wjQS7TLkpJkVhCC8pWotI100BlADj5eUw110";

    public static Configuration getConfigForTest1And2(){
        Configuration config = new Configuration();

        // You can get your api key from the Applitools dashboard
        config.setApiKey(APPLITOOLS_KEY);

        // create a new batch info instance and set it to the configuration
        config.setBatch(new BatchInfo("HolidayShopping"));

        // Add browsers with different viewports
        config.addBrowser(1200, 800, BrowserType.CHROME);

        return config;
    }

    public static Configuration getConfigForTest3(){
        Configuration config = new Configuration();

        // You can get your api key from the Applitools dashboard
        config.setApiKey(APPLITOOLS_KEY);

        // create a new batch info instance and set it to the configuration
        config.setBatch(new BatchInfo("HolidayShopping"));

        // Add browsers with different viewports
        config.addBrowser(1200, 800, BrowserType.CHROME);
        config.addBrowser(1200, 800, BrowserType.FIREFOX);
        config.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
        config.addBrowser(1200, 800, BrowserType.SAFARI);
        config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

        return config;
    }


}
