package StepDefinitions;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {

        //WebElement empIdTextBox = driver.findElement(By.id("empsearch_id"));
        sendText(employeeSearchPage.empIdTextBox, ConfigReader.getPropertyValue("empid"));
    }
    @When("Clicks on search button")
    public void clicks_on_search_button() {
        //WebElement searchButton = driver.findElement(By.id("searchBtn"));
        doClick(employeeSearchPage.searchButton);
    }

    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("  The employee is Displayed");
    }

    @When("user select Job Title")
    public void user_select_job_title() {

        // WebElement jobTitleDdl = driver.findElement(By.id("empsearch_job_title"));
        selectByIndex(employeeSearchPage.jobTitleDdl, 17);

        //WebElement EmpStatusDdl = driver.findElement(By.id("empsearch_employee_status"));
        selectByVisibleText(employeeSearchPage.EmpStatusDdl, "Active");

        // WebElement subUnit = driver.findElement(By.id("empsearch_sub_unit"));
        selectByIndex(employeeSearchPage.subUnit, 2);

        // WebElement includeDdl = driver.findElement(By.id("empsearch_termination"));
        selectByOptions(employeeSearchPage.includeDdl, "Past Employees Only");
    }

}
