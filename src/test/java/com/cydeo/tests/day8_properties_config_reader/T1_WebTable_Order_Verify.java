package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.WebDriverFactory;
import com.cydeo.tests.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables ");

}
@Test
    public void order_name_verfiy_test(){

    WebElement bobMartin =
            driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
    String actualName= bobMartin.getText();
    String expectedName="Bob Martin";
    Assert.assertEquals(actualName,expectedName);

    WebElement bobMartinDateCell=
            driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
    String expectedBobDate= "12/31/2021";
    String actualBobDate= bobMartinDateCell.getText();
    Assert.assertEquals(actualBobDate,expectedBobDate);
}
/*
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */
    //We use utility method we created
    @Test
    public void test2_(){
        System.out.println(WebTableUtils.returnOrderDate(driver, "Alexandra Gray"));


    }

    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver, "Alexandra Gray", "04/15/2021");

    }
}
