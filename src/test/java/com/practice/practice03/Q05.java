package com.practice.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Q05 extends TestBase {
    //Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    //Click on Ajax Loader
    //Then click on "Click Me!" button.
    //Take screenshot after each step.

    @Test
    public void test() throws IOException {
        //Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeScreenShot();

        //Click on Ajax Loader
        driver.findElement(By.xpath("//span[@id='button3']/p/a")).click();
        takeScreenShot();

        //Then click on "Click Me!" button.
        driver.findElement(By.id("button1")).click();
        takeScreenShot();

        //Take screenshot after each step.
    }
}