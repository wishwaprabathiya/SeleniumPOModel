package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;



    public void openPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa.knocen.com/keycloak/realms/mdmsp/protocol/openid-connect/auth?client_id=knocen-frontend&redirect_uri=https%3A%2F%2Fqa.knocen.com&state=aafbb46a-7299-4018-99ea-bc798cdb0476&response_mode=fragment&response_type=code&scope=openid&nonce=36f60ab1-416a-4e65-89cc-f3d214a98472");
    }

//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
