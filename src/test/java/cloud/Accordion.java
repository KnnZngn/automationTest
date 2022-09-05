package cloud;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Accordion extends TestBase {

    @Test
    public void accordionTest(){
        driver.get("http://jqueryui.com/accordion/");

        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]")).click();

        String expected= driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/p")).getText();
        Assert.assertTrue(expected.contains("Sed non urna"));

    }
}
