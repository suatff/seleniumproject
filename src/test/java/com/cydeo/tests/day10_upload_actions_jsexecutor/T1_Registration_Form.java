package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {
    @Test
    public void registration_form(){
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker=new Faker();


        WebElement firstName= Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String fakerFirstName = faker.name().firstName();
        firstName.sendKeys(faker.name().lastName());

        WebElement lastName= Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName= Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        String user = faker.bothify("helpdesk###");
        userName.sendKeys(user);

        WebElement email= Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(user + "@email.com");

        WebElement password= Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.numerify("########"));

        WebElement phone= Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(faker.numerify("###-###-####"));

        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();

        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //faker.number().numberBetween(2004, 1920)
        inputBirthday.sendKeys("03/08/2000");

        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

        //12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));
        //13. Select programming language from checkboxes
        WebElement inputLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        inputLanguage.click();
        //14. Click to sign up button
        WebElement singUp = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        singUp.click();
        //15. Verify success message “You’ve successfully completed registration.” is displayed.

        WebElement verifyMassage= Driver.getDriver().findElement(By.xpath("//p"));
        String actualMassage= verifyMassage.getText();
        String expectedMassage= "You’ve successfully completed registration.";
        Assert.assertEquals(actualMassage, expectedMassage);
    }
}


/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */