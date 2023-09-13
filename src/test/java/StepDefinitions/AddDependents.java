package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddDependents extends CommonMethods {

    @When("user clicks on dependent button")
    public void user_clicks_on_dependent_button() {
        WebElement dependButton = driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[4]/a"));
        doClick(dependButton);

    }

    @When("user is clicks on add button")
    public void user_is_clicks_on_add_button() {
        WebElement addDependBtn = driver.findElement(By.id("btnAddDependent"));
        doClick(addDependBtn);

    }

    @When("Add Dependent text confirmed")
    public void add_dependent_text_confirmed() {
        boolean addDependentText = driver.findElement(By.id("heading")).isDisplayed();
        if (addDependentText) {
            System.out.println("Add Dependent");
        }

    }

    @When("user enter name")
    public void user_enter_name() {
        WebElement dependentName = driver.findElement(By.id("dependent_name"));
        sendText(dependentName, "Ekram");

    }

    @When("user clicks on dropDown and select dependent")
    public void user_clicks_on_drop_down_and_select_dependent() {
        WebElement dependentRelation = driver.findElement(By.id("dependent_relationshipType"));
        doClick(dependentRelation);
        WebElement childOption = driver.findElement(By.xpath("//*[@id=\"dependent_relationshipType\"]/option[3]"));
        doClick(childOption);
        WebElement specify = driver.findElement(By.id("dependent_relationship"));
        sendText(specify, "brother");
    }

    @When("user select date of birth")
    public void user_select_date_of_birth() {

        WebElement dateOfBirth = driver.findElement(By.id("dependent_dateOfBirth"));
        doClick(dateOfBirth);

        WebElement year = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
        selectByVisibleText(year,"2025");
        doClick(year);

        WebElement month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
        doClick(month);
        selectByVisibleText(month,"Jun");
        doClick(month);

//        WebElement day = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]"));
//        selectByOptions(day,"11");
//        doClick(day);

        //  WebElement next = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));


//------------------------
//        boolean isFound = false;
//
//        while (!isFound) {
//
//            String monthEver = dateOfBirth.getText();
//            if (monthEver.equalsIgnoreCase("Mar")) {
////                select the day
//                List<WebElement> days = driver.findElements(By.xpath("//*[@id=\"frmEmpDependent\"]/fieldset/ol/li[4]/img"));
//                for (WebElement day : days) {
//                    String day_text = day.getText();
//                    if (day_text.equalsIgnoreCase("20")) {
//                        doClick(day);
//                        // day.click();
//                        isFound = true;
//                        break;
//                    }
//                }
//
//            } else {
//                //next.click();
//                doClick(next);
//            }
//
//        }
    }


}
