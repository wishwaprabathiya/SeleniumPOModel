package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateBuildingPage {
    WebDriver driver;
    public UpdateBuildingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//span[text()='Buildings'][1]")
    public  WebElement buldingButton_loc;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/span[1]/button[1]")
    public WebElement actionBtn_loc;

    @FindBy(xpath = "//li[normalize-space()='Edit']" )
    public WebElement editAction_loc;

    @FindBy(xpath = "//input[@id='addressLine01']")
    public WebElement adressline01InputField_loc;

    @FindBy(xpath = "//button[@id='btnOrgCreation']" )
    public WebElement saveBtn_loc;

    public void clickBuldingBtn(){ buldingButton_loc.click(); }
    public void clickActionBtn(){ actionBtn_loc.click(); }
    public void clickEditAction(){ editAction_loc.click(); }
    public void clearAdressline01InputField(){adressline01InputField_loc.clear();}
    public void setAdressline01InputField(String updateLine01){ adressline01InputField_loc.sendKeys(updateLine01); }
    public void clickSaveBtn(){ saveBtn_loc.click(); }


}
