package com.practice.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Q03 extends TestBase {
    // go to amazon homepage
    // hover mouse over the hello,signIn element at the top right
    // Click on the Create list link in the menu that opens
    // and verify that title is equal to "Your List"

    @Test
    public void test(){
        // go to amazon homepage
        driver.get("https://www.amazon.com");

        // hover mouse over the "hello,signIn" element at the top right
        WebElement helloElement = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(helloElement).perform();


        // Click on the "Create list" link in the menu that opens
        driver.findElement(By.xpath("//*[@id='nav-al-wishlist']/a[1]/span")).click();

        // and verify that title is equal to "Your List"
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Your List"));

    }
}