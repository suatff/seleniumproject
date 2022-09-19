package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {

    public static void main(String[] args) {
//1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/checkboxes");

//2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1= driver.findElement(By.cssSelector("input[id=box1]"));
        System.out.println("checkbox1 is Selected = " + checkbox1.isSelected());

//3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2= driver.findElement(By.cssSelector("input[id=box2]"));
        System.out.println("checkbox2 is Selected = " + checkbox2.isSelected());
//4. Click checkbox #1 to select it.
        checkbox1.click();

//5. Click checkbox #2 to deselect it.
        checkbox2.click();

//6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1 is Selected = " + checkbox1.isSelected());
//7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2 is Selected = " + checkbox2.isSelected());

    }
}
