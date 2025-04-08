package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath ="//input[@id= 'username']")
    public WebElement userName_ele;

    @FindBy(xpath ="//input[@id='password']")
    public WebElement password_ele;

    @FindBy(xpath ="//button[@id='kc-login']")
    public WebElement loginBtn_ele;

    public void setUserName(String userName){
        userName_ele.sendKeys(userName);
    }
    public void setPassword(String password){
        password_ele.sendKeys(password);
    }
    public void loginBtnClick(){  loginBtn_ele.click();}



}
