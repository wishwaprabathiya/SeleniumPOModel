import base.BaseClass;
import functions.KnocenCommenFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.VerifyUserLogin;

import java.time.Duration;

public class TC002 extends BaseClass {
    KnocenCommenFunctions knocenCommenFunctions;
    VerifyUserLogin verifyUserLogin;

    @BeforeMethod
    public void setup(){
        openPage();
        knocenCommenFunctions = new KnocenCommenFunctions(driver);
        verifyUserLogin = new VerifyUserLogin(driver);
    }

    @Test
    public void TC002(){

        knocenCommenFunctions.loginUser("soboy96538@jarars.com","Abcd1234");
        verifyUserLogin.verifyLogin();
        knocenCommenFunctions.updateBulding("updated line");

    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"toolbar\"]/div[2]/div[1]/ul/li/div/div"));
        logout.click();
        driver.quit();
    }
}

