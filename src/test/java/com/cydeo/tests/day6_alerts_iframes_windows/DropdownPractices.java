package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
    @Test
    public void dropdown_task5(){

        //3. Select Illinois with visibletext
        Select stateDropdown= new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia with value
        stateDropdown.selectByValue("VA");

        //5. Select California  with index
        stateDropdown.selectByIndex(5);
        //6. Verify final selected option is California.
        String expectedOptionText="California";
        String actualOptionText= stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText,expectedOptionText);

    }

    @Test
    public void dropdownTask6(){

        ///3. Select “December 1st, 1923” and verify it is selected.
        //Select year using  : visible text
        //Select month using   : value attribute
        //Select day using : index number

        Select yearDropdown= new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown= new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown= new Select(driver.findElement(By.xpath("//select[@id='day']")));

        yearDropdown.selectByVisibleText("1923");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        //creating expected values
        String expectedYear="1923";
        String expectedMonth= "December";
        String expectedDay="1";

        //creating actual values from browser
        String actualYear= yearDropdown.getFirstSelectedOption().getText();
        String actualMonth=monthDropdown.getFirstSelectedOption().getText();
        String actualDay= dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualDay,expectedDay);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualYear, expectedYear);


    }

    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }







}
