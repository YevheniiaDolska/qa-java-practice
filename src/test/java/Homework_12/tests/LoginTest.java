package Homework_12.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import Homework_12.pages.LoginPage;


public class LoginTest {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @DataProvider (name="loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @Test (dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);

        loginPage.enterPassword(password);

        loginPage.clickLogin();

        //String title = driver.getTitle();
        //WebElement login_field = driver.findElement(By.cssSelector("#user-name"));
        //WebElement password_field = driver.findElement(By.cssSelector("#password"));

        //Assert.assertTrue(title.contains("Swag Labs"));

        //SoftAssert softAssert = new SoftAssert();

        //softAssert.assertTrue(login_field.isDisplayed());
        //softAssert.assertTrue(password_field.isDisplayed());

        //softAssert.assertAll();
    }

    //@Test(dataProvider = "loginData")
    //public void loginTest(String username, String password){
        //driver.findElement(By.id("user-name")).sendKeys(username);
        //driver.findElement(By.id("password")).sendKeys(password);
        //System.out.println("Username: " + username);
        //System.out.println("Password: " + password);
    //}

    @AfterMethod
    public void bye() {
        driver.quit();
    }
}

//Тест-кейси за посиланням: https://docs.google.com/spreadsheets/d/12HQp0FFUle3MYgWJzWfUALdwnOPAt8FcuBsw1t8Bseg/edit?gid=0#gid=0