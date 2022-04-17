package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
        @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

            //find the email field element
            WebElement usernameField = driver.findElement(By.id("txtUsername"));
            // sending email to email field to element
            usernameField.sendKeys("Admin");
            // find password field element
            WebElement passwordField = driver.findElement(By.name("txtPassword"));
            //sending password to password field element
            passwordField.sendKeys("admin123");

            WebElement loginbutton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
            loginbutton.click();



            String expectedMessage = "Welcome mahesh";

            WebElement actualMessageelement = driver.findElement(By.xpath("//a[@id='welcome']"));
            String actualMessage = actualMessageelement.getText();
            Assert.assertEquals("successfully login",expectedMessage,actualMessage);


        }

}
