package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1-Setup the browser driver

        WebDriverManager.chromedriver().setup();

        //2-Create instance of the Selenium WebDriver
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //driver.manage().window().fullscreen();

        //3-Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //Use selenium to navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //Use selenium to navigate refresh
        driver.navigate().refresh();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //Use selenium to navigate() to()
        driver.navigate().to("https://www.google.com");

        //get the title of the page
        System.out. println("Titel: "+driver.getTitle());

        //Get the current URL
        String currentURL= driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //This will close the currently opened window
        driver.close();

        //this will close all of the opened windows. CAREFULL TO USE!
        driver.quit();






    }
}
