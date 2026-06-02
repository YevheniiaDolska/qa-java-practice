package Homework_12.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement inputLoginField(){

        return driver.findElement(By.id("user-name"));
    }

    private WebElement inputPassword() {
        return driver.findElement(By.id("password"));
    }

    private WebElement clickLoginButton(){
        return driver.findElement(By.id("login-button"));
    }

    public void enterUsername(String username){
        inputLoginField().clear();
        inputLoginField().sendKeys(username);
    }

    public void enterPassword(String password){

        inputPassword().clear();
        inputPassword().sendKeys(password);
    }

    public void clickLogin(){
        clickLoginButton().click();
    }

}


