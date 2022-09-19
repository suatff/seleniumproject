package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {


        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        //Locate homeLink with cssSelector
        WebElement homeLink_ex1= driver.findElement(By.cssSelector("a[class='nav-link']"));

        //Locate homeLink using cssSelector syntax#2
        //WebElement homeLink_ex2= driver.findElement(By.cssSelector("a.nav-link"));

        //b. “Forgot password” header
        //Locate header using cssSelector
        WebElement forgotPasswordHeader_ex1= driver.findElement(By.cssSelector("div.example>h2"));
        WebElement forgotPasswordHeader_ex2= driver.findElement(By.cssSelector("#content > div > h2"));

        //Locate header using xpath
        WebElement forgotPasswordHeader_ex3=driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        //c. “E-mail” text
        //Locate e-mailText using xpath
        WebElement emailText_ex1= driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement inputBox= driver.findElement(By.xpath("//input[@name='email']"));
        WebElement inputBox_ex1=driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

       // e. “Retrieve password” button
        WebElement passwordButton= driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));

        //f. “Powered by Cydeo text
        WebElement cydeoText= driver.findElement(By.xpath("//div[@style='text-align: center;']"));

       // 4. Verify all web elements are displayed.

        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("forgotPasswordHeader_ex1.isDisplayed() = " + forgotPasswordHeader_ex1.isDisplayed());
        System.out.println("emailText_ex1.isDisplayed() = " + emailText_ex1.isDisplayed());
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
        System.out.println("passwordButton.isDisplayed() = " + passwordButton.isDisplayed());
        System.out.println("cydeoText.isDisplayed() = " + cydeoText.isDisplayed());

        // First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible

       // Then solve the task using XPATH only. Try to create 2 different
       // XPATH locator if possible
    }
}
