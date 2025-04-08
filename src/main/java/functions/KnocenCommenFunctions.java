package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateBuildingPage;
import pages.LoginPage;
import pages.UpdateBuildingPage;

import java.time.Duration;

public class KnocenCommenFunctions {
    WebDriver driver;

    public KnocenCommenFunctions(WebDriver driver) {
        this.driver = driver;
    }


    public void loginUser(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.loginBtnClick();
    }

    public void createBulding(String buldingName, String email , String addressLine01, String addressLine02, String zipCode , String city , String state, String telNumber){
        CreateBuildingPage createBuildingPage = new CreateBuildingPage(driver);

        createBuildingPage.clickBuldingBtn();
        createBuildingPage.clickAddBuldingBtn();
        createBuildingPage.setBuildingName(buldingName);
        createBuildingPage.setEmail(email);
        createBuildingPage.setAddressLine01(addressLine01);
        createBuildingPage.setaAdressLine02(addressLine02);
        createBuildingPage.setZipCode(zipCode);
        createBuildingPage.setCity(city);
        createBuildingPage.setState(state);
        createBuildingPage.selectCountry();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createBuildingPage.setTelNumber(telNumber);
        createBuildingPage.clickSavebtn();
//        createBuildingPage.clickActionBtn();
//        createBuildingPage.clickDeleteAction();
//        createBuildingPage.clickDeleteActionConfirm();
    }

    public void updateBulding(String updateLine01){
        UpdateBuildingPage updateBuildingPage = new UpdateBuildingPage(driver);
        updateBuildingPage.clickBuldingBtn();
        updateBuildingPage.clickActionBtn();
        updateBuildingPage.clickEditAction();
        updateBuildingPage.clearAdressline01InputField();
        updateBuildingPage.setAdressline01InputField(updateLine01);
        updateBuildingPage.clickSaveBtn();


    }

}
