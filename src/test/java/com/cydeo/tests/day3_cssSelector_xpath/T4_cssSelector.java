package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector {
    public static void main(String[] args) {
        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");
        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
        WebElement resetButton=driver.findElement(By.cssSelector("button[value='Reset password'"));
        String expectedResetButtonText="Reset password";
        String actuallResetButtonText= resetButton.getAttribute("value");

        if(actuallResetButtonText.equals(expectedResetButtonText)){
            System.out.println("Reset Button verification PASSED!");
        }else {
            System.out.println("Reset Button verification FAILED!");
        }
    }
}
