package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.EmployeeSearchPage;
import Pages.LoginPage;

public class PageInitializer {

    // make the login page global
    public static LoginPage login;

    // make the addEmployeePage global
    public static AddEmployeePage addEmployeePage;

    // make the EmployeeSearch Page global
    public static EmployeeSearchPage employeeSearchPage;

    //------------project---------
    public static AddDependents addDependents;
    //--------------------------

    public static void initializePageObject() {

        // login page object
        login = new LoginPage();

        // object of employee page
        addEmployeePage = new AddEmployeePage();

        // object of employeeSearch page
        employeeSearchPage = new EmployeeSearchPage();

        //------------project---------
        addDependents = new AddDependents();

    }
}
