package com.practice.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Q05 extends TestBase {

//Signup For Facebook by using Actions class
//Go to Facebook
//Click on Create New Account
//fill all the boxes by using keyboard actions
    @Test
    public void test(){

        //Go to Facebook
        driver.get("https://www.facebook.com");

        //Click on Create New Account
        driver.findElement(By.linkText("Create New Account")).click();  //LINK TE DIREK LINK TEXT INI YAZARIZ INSPECTE GERK YOK

        //fill all the boxes by using keyboard actions
        Actions actions = new Actions(driver);
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(firstNameBox)
                .sendKeys("John")
                .sendKeys(Keys.TAB)
                .sendKeys("Doe")
                .sendKeys(Keys.TAB)
                .sendKeys("123@123.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123@123.com")
                .sendKeys(Keys.TAB)
                .sendKeys("John123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("11")
                .sendKeys(Keys.TAB)
                .sendKeys("Feb")
                .sendKeys(Keys.TAB)
                .sendKeys("2008")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }
}