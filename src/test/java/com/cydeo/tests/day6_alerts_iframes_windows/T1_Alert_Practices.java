package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test1(){
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert =driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT display");

    }

    @Test
    public void alertPractice_1(){
        WebElement clickForJSConfirm= driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJSConfirm.click();

        Alert alert=driver.switchTo().alert();

        alert.accept();

        WebElement resultText= driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not display");


    }

    @Test
    public void alertPractice_2(){
        WebElement clickForJSPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJSPrompt.click();

        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        String expectedresult= "You entered: hello";
        WebElement resultText= driver.findElement(By.xpath("//p[.='You entered: hello']"));
        String actualresult= resultText.getText();
        Assert.assertEquals(actualresult,expectedresult);
    }


}
