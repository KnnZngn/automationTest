package cloud;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignInTest extends TestBase {
    @Test
    public void testSignIn() throws InterruptedException {
        //1
        driver.get("http://automationpractice.com/index.php");
        //2
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

//       4.Send your email and click on create an account button.We will use that email. Make sure to save that email.
//       If the email is already used for account creation you can not use it again
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);
        Thread.sleep(15000);

        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Thread.sleep(15000);

//        5.Verify the Text : CREATE AN ACCOUNT
        String textOfCreate = driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1")).getText();
        Assert.assertEquals("CREATE AN ACCOUNT",textOfCreate);

//        6. Verify the Text : YOUR PERSONAL INFORMATION
        String textOfY_P_I = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3")).getText();
        Assert.assertEquals("YOUR PERSONAL INFORMATION",textOfY_P_I);

//        7. Verify the Text : Title
        String textOfTitle = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/label")).getText();
        Assert.assertEquals("Title",textOfTitle);

//        8. Select your title
        driver.findElement(By.id("id_gender1")).click();

//        9. Enter your first name
        String firstName =faker.name().firstName();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(firstName);

//        10. Enter your last name
        String lastName = faker.name().lastName();
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(lastName);

//        11. Enter your email
         //String email1 = faker.internet().emailAddress();  Note:email comes automatically
         //driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);

//        12. Enter your password
        String password = faker.internet().password();
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);

//        13. ENTER DATE OF BIRTH
        WebElement days = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        Select selectDays = new Select(days);
        selectDays.selectByIndex(14);

        WebElement months = driver.findElement(By.xpath(" //*[@id=\"months\"]"));
        Select selectMonths = new Select(months);
        selectMonths.selectByIndex(6);

        WebElement years = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        Select selectYears = new Select(years);
        selectYears.selectByValue("2001");

//        14. Click on Sign up for our newsletter!
        driver.findElement(By.xpath("//*[@id=\"uniform-newsletter\"]")).click();

//        15. Enter your first name   Note:first name comes automatically
//        16. Enter your last lane    Note:last name comes automatically

//        17. Enter your company  //*[@id="company"]
        String companyName = faker.company().name();
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(companyName);

//        18. Enter your Address
        String fullAddress = faker.address().fullAddress();
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys(fullAddress);

//        19. Enter your City
        String cityName = faker.address().city();
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(cityName);

//        20. SELECT STATE
        WebElement states = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
        Select selectStates = new Select(states);
        selectStates.selectByVisibleText("Colorado");

//        21. Enter Postal Code
        String zipCode= faker.address().zipCode();
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys(zipCode);

//        22.SELECT COUNTRY
        WebElement country = driver.findElement(By.xpath("//*[@id=\"id_country\"]"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United States");

//        23. Enter additional information
        driver.findElement(By.xpath(" //*[@id=\"other\"]")).sendKeys("Eventually We have just completed");

//        24. Enter home phone
        String phoneNumber= faker.phoneNumber().phoneNumber();
        driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys(phoneNumber);

//        25. Enter mobile phone
        String cellNumber= faker.phoneNumber().cellPhone();
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys(cellNumber);

//        26. Enter reference name
        driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("My address");

//        27. Click Register
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
        Thread.sleep(15000);

//        28. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
        String accountVerification= driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",accountVerification);

    }
}
