import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateANDUpdateBulding {
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
        Thread.sleep(15000);

        driver.findElement(By.xpath("//span[text()='Buildings'][1]")).click();

        Thread.sleep(2000);
        WebElement addNewUserButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-1tm8adr']"));
        addNewUserButton.click();
        Thread.sleep(2000);

        WebElement BuildingNameFiled = driver.findElement(By.id("buildingName"));
        BuildingNameFiled.sendKeys("CBL Building");
        WebElement emailFiled = driver.findElement(By.id("email"));
        emailFiled.sendKeys("cbl@gmail.com");
        WebElement AddressLine1Filed = driver.findElement(By.id("addressLine01"));
        AddressLine1Filed.click();
        AddressLine1Filed.sendKeys("No 25/2");
        WebElement AddressLine2Filed = driver.findElement(By.id("addressLine02"));
        AddressLine2Filed.click();
        AddressLine2Filed.sendKeys("Boralla");
        WebElement ZipCodeFiled = driver.findElement(By.id("zipCode"));
        ZipCodeFiled.click();
        ZipCodeFiled.sendKeys("683729");
        WebElement CityFiled = driver.findElement(By.id("city"));
        CityFiled.click();
        CityFiled.sendKeys("Colombo");
        WebElement StateFiled = driver.findElement(By.id("state"));
        StateFiled.click();
        StateFiled.sendKeys("Western");
        WebElement countrySelectFiled = driver.findElement(By.xpath("//div[@id='country']"));
        countrySelectFiled.click();
        WebElement country = driver.findElement(By.xpath("//li[normalize-space()='Sri Lanka (+94)']"));
        Thread.sleep(3000);
        country.click();
        WebElement teleNumberFiled = driver.findElement(By.id("telNumber"));
        teleNumberFiled.sendKeys("113456712");

        driver.findElement(By.xpath("//div[normalize-space()='Save']")).click();
        Thread.sleep(2000);


        WebElement popup = driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']"));
        String popupMessage = popup.getText();
        String successCraeteMassage = "Building created successfully." ;
        if(popupMessage.equals(successCraeteMassage)){
            System.out.println(successCraeteMassage);
        }
        else{
            System.out.println("unsccessful create");
        }
        //action button click
        WebElement buldingActionButton = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/div[1]/span[1]/button[1]"));
        buldingActionButton.click();

        //update newly record
        WebElement updateActionButton = driver.findElement(By.xpath("//li[normalize-space()='Edit']"));
        updateActionButton.click();
        WebElement adressline01InputField = driver.findElement(By.xpath("//input[@id='addressLine01']"));
        adressline01InputField.click();
        adressline01InputField.clear();
        adressline01InputField.sendKeys("Updated line");
        WebElement saveButton = driver.findElement(By.xpath("//button[@id='btnOrgCreation']"));
        saveButton.click();

        Thread.sleep(2000);
        WebElement popup2 = driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']"));
        String popupMessage2 = popup2.getText();
        String successUpdateMassage = "Building updated successfully." ;
        if(popupMessage2.equals(successUpdateMassage)){
            System.out.println(successUpdateMassage);
        }
        else{
            System.out.println("unsccessful updated");
        }
         Thread.sleep(3000);





        //delete newly record
        WebElement buldingActionButtonNew = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/div[1]/span[1]/button[1]"));
        buldingActionButtonNew.click();
        WebElement deleteActionButton = driver.findElement(By.xpath("//li[normalize-space()='Delete']"));
        deleteActionButton.click();
        WebElement deletecomfirmButton = driver.findElement(By.xpath("//button[normalize-space()='Yes']"));
        deletecomfirmButton.click();




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

