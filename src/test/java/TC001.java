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

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TC001 extends BaseClass {
    KnocenCommenFunctions knocenCommenFunctions;
    VerifyUserLogin verifyUserLogin;

    public static String GeneratedBuildingNam() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String buildingName = "Building_" + timeStamp;
        return  buildingName;
    }






    @BeforeMethod
    public void setup(){
        openPage();
        knocenCommenFunctions = new KnocenCommenFunctions(driver);
        verifyUserLogin = new VerifyUserLogin(driver);
    }

    @Test
    public void TC001() throws InterruptedException {

        String buldingName = GeneratedBuildingNam();
        knocenCommenFunctions.loginUser("soboy96538@jarars.com","Abcd1234");
        Thread.sleep(2000);
        verifyUserLogin.verifyLogin();
        knocenCommenFunctions.createBulding(buldingName, "abc@gmail.com", "No 25", "Nugegoda", "78654", "Colombo", "Western", "115725497" );


    }
   @AfterMethod
    public void closeBrowser() throws InterruptedException {
       Thread.sleep(4000);
       WebElement logout = driver.findElement(By.xpath("//*[@id=\"toolbar\"]/div[2]/div[1]/ul/li/div/div"));
       logout.click();
       driver.quit();
   }
}
