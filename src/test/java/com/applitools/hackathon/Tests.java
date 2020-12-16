package com.applitools.hackathon;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tests {
    public static void mainPage(WebDriver webDriver, Eyes eyes, String env) {

        try {

            webDriver.get(env);

            eyes.open(webDriver, "AppliFashion", "Test 1", new RectangleSize(1200, 800));

            eyes.check(Target.window().fully().withName("main page"));

            eyes.closeAsync();

        } finally  {
            eyes.abortAsync();
        }

    }

    public static void filterByColor(WebDriver webDriver, Eyes eyes, String env){
        try {

            // Navigate to the url we want to test
            webDriver.get(env);

            // Call Open on eyes to initialize a test session
            eyes.open(webDriver, "AppliFashion", "Test 2", new RectangleSize(1200, 800));

            if(!webDriver.findElement(By.id("colors__Black")).isSelected())
                webDriver.findElement(By.id("colors__Black")).click();
            webDriver.findElement(By.id("filterBtn")).click();
            eyes.checkRegion(By.id("product_grid"), "filter by color");

            // Call Close on eyes to let the server know it should display the results
            eyes.closeAsync();

        } finally  {
            eyes.abortAsync();
        }
    }

    public static void productDetails(WebDriver webDriver, Eyes eyes, String env){
        try {

            // Navigate to the url we want to test
            webDriver.get(env);

            // Call Open on eyes to initialize a test session
            eyes.open(webDriver, "AppliFashion", "Test 3", new RectangleSize(1200, 800));

            webDriver.findElement(By.xpath("//*[contains(@alt,'Appli Air x Night')]")).click();

            eyes.check(Target.window().fully().withName("product details"));

            // Call Close on eyes to let the server know it should display the results
            eyes.closeAsync();

        } finally  {
            eyes.abortAsync();
        }
    }
}
