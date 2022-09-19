package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Task5 {

    WebDriver driver;
    @BeforeMethod
    public void beforeMEthod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void stateDrodown (){
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select stateDropdown= new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Illinois");
        stateDropdown.selectByValue("CA");
        stateDropdown.selectByVisibleText("Virginia");

        String expectedOption= "Virginia";
        String actualOption= stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption);
    }
}
