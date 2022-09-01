package cloud;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Emoji extends TestBase {
    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// click on the "Animals and Nature" emoji
// click all the "Animals and Nature"  emoji elements
// fill the form
// press the apply button
    @Test
    public void emojiTest(){
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"tooltip-yuknr\"]"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//*[@id=\"tooltip-yuknr\"]/span[2]")).click();
    }

}
