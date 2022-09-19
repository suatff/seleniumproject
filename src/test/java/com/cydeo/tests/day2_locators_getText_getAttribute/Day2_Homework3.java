package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Homework3 {
    public static void main(String[] args) {



        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");
        driver.findElement(By.id("L2AGLb")).click();
        //3- Click to Gmail from top right.
        WebElement gmailButton= driver.findElement(By.linkText("Gmail"));
        gmailButton.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedTitle= "Gmail";
        String actualTitle =driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Verification is DONE");
        }else {
            System.out.println("Verification is FAILED");
        }

        //5- Go back to Google by using the .back();

        driver.navigate().back();
        //6- Verify title equals:
        //Expected: Google
        String expectedTitle2= "Google";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Verification is DONE");
        }else {
            System.out.println("Verification is FAILED");
        }
    }
}
