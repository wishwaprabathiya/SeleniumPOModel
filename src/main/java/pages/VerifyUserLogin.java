package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class VerifyUserLogin {
    WebDriver driver;

    public VerifyUserLogin(WebDriver driver) {
        this.driver = driver;


    }


    public void verifyLogin(){
        String expectedTitle1 = "Knocen Knowledge Management System" ;
        String actualTitle = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if(expectedTitle1.equals(actualTitle)){
            System.out.println("Login was successful");
        }else{
            WebElement continueBtn_ele = driver.findElement(By.name ("continueSession") );
            continueBtn_ele.click();
            System.out.println("Login was successful");

        }
    }
}
