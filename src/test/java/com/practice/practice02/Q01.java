package com.practice.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q01 extends TestBase {

    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// click on the "Animals and Nature" emoji
// click all the "Animals and Nature"  emoji elements
// fill the form
// press the apply button
    @Test
    public void test(){
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // first switch to the iframe
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        // click on the "Animals and Nature" emoji
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // click all the "Animals and Nature"  emoji elements
        List<WebElement> allEmojis = driver.findElements(By.xpath("//*[@id='nature']/div/img"));

//        for(WebElement w : allEmojis){
//            w.click();
//        }

        // Using lambda is recommended
        allEmojis.stream().forEach(t->t.click());

        driver.switchTo().defaultContent();

        // fill the form   LISTE DOLDURURKEN COK ONEMLI FARKLI BIR YOL FILL ICIN
        List<WebElement> inputs = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));//11 web elements
        List<String> words = new ArrayList<>(Arrays.asList("This","iframe","example", "looks", "very", "funny","does", "not","it","?","!"));//11

        for(int i = 0; i<inputs.size(); i++){
            inputs.get(i).sendKeys(words.get(i));
        }

        // press the apply button
        driver.findElement(By.id("send")).click();
        WebElement code = driver.findElement(By.id("code"));
        Assert.assertTrue(code.isDisplayed());
    }
}
