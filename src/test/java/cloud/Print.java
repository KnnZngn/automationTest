package cloud;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Print extends TestBase {
    @Test
    public void printTest() throws InterruptedException {

        driver.get("https://jqueryui.com/toggle/");

        WebElement iframe = driver.findElement(By.xpath(" //*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(iframe);

        String text1 = driver.findElement(By.xpath(" //*[@id=\"effect\"]/p ")).getText();
        System.out.println(text1);

        String text0 = driver.findElement(By.xpath("//div[@class='toggler']")).getText();
        System.out.println(text0);

        String text2 = driver.findElement(By.xpath("//div[@class='toggler']")).getText();
        System.out.println(text0);

        //after run effect
        driver.findElement(By.xpath("//*[@id=\"button\"]")).click();

        Thread.sleep(3000);

        String text3 = driver.findElement(By.xpath("//div[@class='toggler']")).getText();
        System.out.println("after run effect : "+text3);

        Assert.assertTrue(text3.isEmpty());

        driver.findElement(By.xpath("//*[@id=\"button\"]")).click();
        Thread.sleep(3000);

        String text4 = driver.findElement(By.xpath(" //*[@id=\"effect\"]/p ")).getText();
        System.out.println(text4);





        //Assert.assertTrue();

        //*[@id="effect"]/p   text
        //*[@id="button"]  run effect
        //*[@id="content"]/iframe
        //*[@id="effect"]/p
         //div[@class='toggler']

    }
}
