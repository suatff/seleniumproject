package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {

    public static void main(String[] args) {


    //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
    //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
    //3- Verify “Log in” button text is as expected: Expected: Log In

        //WebElement logInButton= driver.findElement(By.cssSelector("input[type='submit']"));
        WebElement logInButton=driver.findElement(By.cssSelector("input[value='Log In']"));
        String expectedLogInButton= "Log In";
        String actuallLogInButton= logInButton.getAttribute("value");
        if(actuallLogInButton.equals(expectedLogInButton)){
            System.out.println("Log In button verification PASSED");
        }else {
            System.out.println("actuallLogInButton = " + actuallLogInButton);
            System.out.println("expectedLogInButton = " + expectedLogInButton);
            System.out.println("Log In button verification FAILED");
        }
        driver.close();





    //PS: Inspect and decide which locator you should be using to locate webelements.
    //PS2: Pay attention to where to get the text of this button from
} }
