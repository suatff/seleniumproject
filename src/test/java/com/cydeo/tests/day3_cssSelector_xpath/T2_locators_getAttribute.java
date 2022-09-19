package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locators_getAttribute {
    public static void main(String[] args) {



        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel= driver.findElement(By.className("login-item-checkbox-label"));
        String expectedRememberMeLabel ="Remember me on this computer";
        String actualRememberMelabel= rememberMeLabel.getText();
        if(actualRememberMelabel.equals(expectedRememberMeLabel)){
            System.out.println("Label verification PASSED");
        }else {
            System.out.println("Label verification FAILED");
        }
        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPasswordLinkText= driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPasswordText= "FORGOT YOUR PASSWORD?";
        String actualForgotPasswordText= forgotPasswordLinkText.getText();
        if(actualForgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("Password Text verification PASSED");
        }else {
            System.out.println("actualForgotPasswordText = " + actualForgotPasswordText);
            System.out.println("expectedForgotPasswordText = " + expectedForgotPasswordText);
            System.out.println("Password Text verification FAILED");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedForgotAttribute= "forgot_password=yes";
        String actualForgotAttribute= forgotPasswordLinkText.getAttribute("href");
        if(actualForgotAttribute.contains(expectedForgotAttribute)){
            System.out.println("Attribute Text verification PASSED");
        }else {
            System.out.println("actualForgotAttribute = " + actualForgotAttribute);
            System.out.println("expectedForgotAttribute = " + expectedForgotAttribute);
            System.out.println("Attribute Text verification FAILED");
        }

        driver.close();




        //PS: Inspect and decide which locator you should be using to locate web elements.
    }
}
