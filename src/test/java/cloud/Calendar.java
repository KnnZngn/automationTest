package cloud;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Calendar extends TestBase {


    @Test
    public void calendar() {
        chooseDate(1,5);
        chooseDate(1,6);
    }

    public void chooseDate(int rowNum, int colNum) {  //tr yerine rowNum td yerine colNum ve method hazir
       driver.get("https://jqueryui.com/datepicker");
       //iframe switch
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();

       //raw1 cell 5              //table[@class='ui-datepicker-calendar']//tbody//tr[1]//td[5]
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr["+rowNum+"]//td["+colNum+"]")).click();
    }


}