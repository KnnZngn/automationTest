package cloud;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Etsy {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

//    @After
//    public void tearDown(){
//       driver.quit();
//    }



    @Test
    public void test(){
        //1.get
      driver.get("https://www.etsy.com/");
        //2.navigate
      driver.navigate().to("https://www.npr.org/");
      driver.navigate().back();
        //3.manage
      driver.manage().window().getSize();
      //driver.manage().window().minimize();

        //4.locator findElement 8
//        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Furniture");
//        driver.findElement(By.xpath("//*[@id=\"gnav-search\"]")).click();
//        driver.findElement(By.name("email_address")).sendKeys("kmjh@hotmail.com");
        //driver.findElement(By.tagName());
//        driver.findElement(By.className("wt-body-max-width wt-text-heading-01"));
//        driver.findElement(By.linkText()); //tag a
//        driver.findElement(By.partialLinkText()); //tag a
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.id());

        //5.web element
        WebElement searchBar= driver.findElement(By.id("global-enhancements-search-query"));
        searchBar.sendKeys("Furniture");
        searchBar.submit();
        WebElement searchResult= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[7]/div[2]/div[1]/span/span/span[1]"));
        System.out.println(searchResult.getText());  //449,819 results,

        WebElement firstImg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[10]/div[1]/div/div/ul/li[1]/div/div/a[1]/div[1]/div/div/div/div[1]/div/img"));
        firstImg.click();  //yeni tab acildi ve driver i mizi oraya yasimamiz lazim switch ile
        //6 NEW TAB and switch Handles
        //yeni TAB a gecince handle aliriz handle unique dir set<xxx> 'le kullanilir

        //1. step getWindowHandle ve stringe koyariz
        String window1Handle = driver.getWindowHandle();

        //2. step getWindowHandleSSSSSSS ve sete koyariz
        Set<String> allWindowHandleS = driver.getWindowHandles();

        //3. adim for each
        for (String w_eachHandle: allWindowHandleS ) {
            //if(!w_eachHandle.equals(window1Handle))
            driver.switchTo().window(w_eachHandle);
            //break;
        }
        //4.step artik yeni tab dayiz driver i mizi da oraya tasidik simdi islemleri yapablrz
            WebElement priceFirstImg = driver.findElement(By.xpath("//*[@id=\"listing-page-cart\"]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/p/span[2]"));
            System.out.println(priceFirstImg.getText());

    }
}
