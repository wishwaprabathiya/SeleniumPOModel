package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CreateBuildingPage {
    WebDriver driver;

    public CreateBuildingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath= "//span[text()='Buildings'][1]")
    public  WebElement buldingButton_loc;

    @FindBy(xpath ="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-1tm8adr']")
    public WebElement addNewUserButton;

    @FindBy(id = "buildingName")
    public WebElement buldingName_loc;

    @FindBy(id = "email")
    public WebElement email_loc;

    @FindBy(id = "addressLine01")
    public WebElement addressLine01_loc;

    @FindBy(id = "addressLine02")
    public WebElement addressLine02_loc;

    @FindBy(id = "zipCode")
    public WebElement zipCode_loc;

    @FindBy(id = "city")
    public WebElement city_loc;

    @FindBy(id = "state")
    public WebElement state_loc;

    @FindBy(xpath = "//div[@id='country']")
    public WebElement country_loc;

    @FindBy(id = "telNumber")
    public WebElement telNumber_loc;

    @FindBy(xpath= "//div[normalize-space()='Save']")
    public WebElement savebtn_loc;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/span[1]/button[1]")
    public WebElement actionBtn_loc;

    @FindBy(xpath = "//li[normalize-space()='Delete']")
    public WebElement deleteAction_loc;

    @FindBy(xpath = "//button[normalize-space()='Yes']")
    public WebElement deleteActionconfirmBtn_loc;


    public void clickBuldingBtn(){ buldingButton_loc.click(); }
    public void clickAddBuldingBtn(){ addNewUserButton.click(); }
    public void setBuildingName(String buldingName){ buldingName_loc.sendKeys(buldingName); }
    public void setEmail(String email){ email_loc.sendKeys(email); }
    public void setAddressLine01(String addressLine01){ addressLine01_loc.sendKeys(addressLine01); }
    public void setaAdressLine02(String addressLine02){ addressLine02_loc.sendKeys(addressLine02); }
    public void setZipCode(String zipCode){ zipCode_loc.sendKeys(zipCode); }
    public void setCity(String city){ city_loc.sendKeys(city); }
    public void setState(String state){ state_loc.sendKeys(state); }
    public void selectCountry(){
        WebElement countrySelectFiled = driver.findElement(By.xpath("//div[@id='country']"));
        countrySelectFiled.click();
        WebElement country = driver.findElement(By.xpath("//li[normalize-space()='Afghanistan (+93)']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        country.click();
    }
    public void setTelNumber(String telNumber){ telNumber_loc.sendKeys(telNumber); }
    public void clickSavebtn(){ savebtn_loc.click(); }
    public void clickActionBtn(){ actionBtn_loc.click(); }
    public void clickDeleteAction()  {deleteAction_loc.click(); }
    public void clickDeleteActionConfirm(){ deleteActionconfirmBtn_loc.click();}


}
