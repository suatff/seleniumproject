package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {
    //TC #5: Window Handle practice
    //1. Create a new class called: T5_WindowsPractice
    //2. Create new test and make set ups

WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }
    @Test
    public void multiple_window_test(){
        //String the main page's window handle as string is good practice for future re-usable purposes
        String mainHandle= driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Windows”
        String expectedTitel="Windows";
        String actualTitel= driver.getTitle();
        Assert.assertEquals(actualTitel,expectedTitel);


    //5. Click to: “Click Here” link
        WebElement clickHereLink= driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
    //6. Switch to new Window.
        for(String each: driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("Current titel while switching windows:" +driver.getTitle());
        }



    //7. Assert: Title is “New Window”
        String expectedTitelAfterClick= "New Window";
        actualTitel=driver.getTitle();

        Assert.assertEquals(actualTitel, expectedTitelAfterClick);

        System.out.println("Titel after click = " + actualTitel);

    }
}
