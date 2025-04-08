import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @BeforeMethod
    public void openChromeBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://qa.knocen.com/keycloak/realms/mdmsp/protocol/openid-connect/auth?client_id=knocen-frontend&redirect_uri=https%3A%2F%2Fqa.knocen.com&state=aafbb46a-7299-4018-99ea-bc798cdb0476&response_mode=fragment&response_type=code&scope=openid&nonce=36f60ab1-416a-4e65-89cc-f3d214a98472");

        WebElement username = driver.findElement(By.xpath("//input[@id= 'username']"));
        username.clear();
        username.sendKeys("soboy96538@jarars.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        password.sendKeys("Abcd1234");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='kc-login']"));
        loginButton.click();

        //verification part
        String expectedTitle = "Knocen Knowledge Management System" ;
        String actualTitle =  driver.getTitle();
        Thread.sleep(2000);
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Login was successful");
        }else{
            System.out.println("Login was unsuccesful");
        }
        Thread.sleep(10000);

        driver.findElement(By.xpath("//span[text()='User Management'][1]")).click();

        Thread.sleep(2000);
        WebElement addNewUserButton = driver.findElement(By.xpath("//button[@id='addNewUserButton']"));
        addNewUserButton.click();
        Thread.sleep(2000);

        WebElement firstNameFiled = driver.findElement(By.id("firstName"));
        firstNameFiled.sendKeys("Sandun");
        WebElement lastNameFiled = driver.findElement(By.id("lastName"));
        lastNameFiled.sendKeys("Samare");
        WebElement emailFiled = driver.findElement(By.id("email"));
        emailFiled.sendKeys("sandun@gmail.com");
        WebElement countrySelectFiled = driver.findElement(By.xpath("//div[@id='country']"));
        countrySelectFiled.click();
        WebElement country = driver.findElement(By.xpath("//li[normalize-space()='Sri Lanka (+94)']"));
        Thread.sleep(3000);
        country.click();
        WebElement teleNumberFiled = driver.findElement(By.id("telNumber"));
        teleNumberFiled.sendKeys("0773456712");
        WebElement roleSelectFiled = driver.findElement(By.id("role"));
        roleSelectFiled.click();
        WebElement role = driver.findElement(By.xpath("//li[normalize-space()='Inspector']"));
        Thread.sleep(3000);
        role.click();
        WebElement statusSelectedFiled = driver.findElement(By.xpath("//div[@id='status']"));
        statusSelectedFiled.click();
        WebElement status = driver.findElement(By.xpath("//li[normalize-space()='Active']"));
        Thread.sleep(2000);
        status.click();
        WebElement organizationSelectedFiled = driver.findElement(By.xpath("//div[@id='organization']"));
        organizationSelectedFiled.click();
        WebElement organization = driver.findElement(By.xpath("//li[normalize-space()='Milenium']"));
        Thread.sleep(2000);
        organization.click();

        driver.findElement(By.xpath("//div[normalize-space()='Save']")).click();
        Thread.sleep(2000);


        WebElement popup = driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']"));
        String popupMessage = popup.getText();
        String successCraeteMassage = "User create Successful" ;
        if(popupMessage.equals(successCraeteMassage)){
            System.out.println();
        }




//        Alert alert= driver.switchTo().alert();
//        Thread.sleep(2000);
//        String alertText = alert.getText();
//        System.out.println(alertText);








        Thread.sleep(10000);
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"toolbar\"]/div[2]/div[1]/ul/li/div/div"));
        logout.click();

        driver.quit();



    }
}
