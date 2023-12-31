package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimModule;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "middleName")

    public WebElement middleNameTextBox;
    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;


}
