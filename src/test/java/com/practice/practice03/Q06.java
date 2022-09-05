package com.practice.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q06 extends TestBase {
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculator under Micro Apps
    // Type 9 in the first input
    // Type 3 in the second input
    // Click on Calculate
    // Get the result
    // Verify the result
    // Print the result
    // Do same process for each math operation on page.
    @Test
    public void test(){

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type 9 in the first input
        driver.findElement(By.id("number1")).sendKeys("9");

        // Type 3 in the second input
        driver.findElement(By.id("number2")).sendKeys("3");

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result = driver.findElement(By.id("answer")).getText();

        // Verify the result
        Assert.assertEquals("12",result);

        // Print the result
        System.out.println(result);

        // Do same process for each math operation on page.
        //Multiplication
        WebElement selectElement = driver.findElement(By.id("function"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("times");
        driver.findElement(By.id("calculate")).click();
        String resultMult = driver.findElement(By.id("answer")).getText();
        Assert.assertEquals("27",resultMult);
        System.out.println(resultMult);

        //Division
        WebElement selectElement1 = driver.findElement(By.id("function"));
        Select select1 = new Select(selectElement1);
        select1.selectByVisibleText("divide");
        driver.findElement(By.id("calculate")).click();
        String resultDiv = driver.findElement(By.id("answer")).getText();
        Assert.assertEquals("3",resultDiv);
        System.out.println(resultDiv);

        //Subtraction
        WebElement selectElement2 = driver.findElement(By.id("function"));
        Select select2 = new Select(selectElement2);
        select2.selectByVisibleText("minus");
        driver.findElement(By.id("calculate")).click();
        String resultSub = driver.findElement(By.id("answer")).getText();
        Assert.assertEquals("6",resultSub);
        System.out.println(resultSub);
    }
}