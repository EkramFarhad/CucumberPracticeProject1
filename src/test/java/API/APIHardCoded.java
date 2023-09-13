package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APIHardCoded {


    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUyMzQ4ODcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTI3ODA4NywidXNlcklkIjoiNTM3NiJ9.EpYJOVI3wimFfnH88dON-SXTAnLzbh4qFzuSaqV1QF8";

    // second classes
    static String employee_id;

    @Test
    public void acreateEmployee() {
        // prepare the request

        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Ekram\",\n" +
                        "  \"emp_lastname\": \"Farhad\",\n" +
                        "  \"emp_middle_name\": \"EF\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-01-01\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Engineer\"\n" +
                        "}");

        // hitting the endpoint/send the request
        Response response = preparedRequest.when().post("/createEmployee.php");

        // it will print the output in the console
        response.prettyPrint();

        // verifying the assertions/get response
        response.then().assertThat().statusCode(201);

        //we are capturing employee id from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        response.then().assertThat().body("Employee.emp_firstname", equalTo("Ekram"));

        response.then().assertThat().body("Employee.emp_lastname", equalTo("Farhad"));

        //verify the response headers
        response.then().assertThat().header("Content-Type", equalTo("application/json"));

        System.out.println("My test case is passed");


    }

    @Test
    public void getCreatedEmployee() {

        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        //hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        //verify the response
        response.then().assertThat().statusCode(200);

        String tempEmpID = response.jsonPath().getString("employee.employee_id");

        // we have 2 emp id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpID);


    }

    @Test
    public void updateEmployee() {

        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Uncle Joe\",\n" +
                        "  \"emp_lastname\": \"Uncle Biden\",\n" +
                        "  \"emp_middle_name\": \"FNU\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1925-01-01\",\n" +
                        "  \"emp_status\": \"JobSeeker\",\n" +
                        "  \"emp_job_title\": \"PRD\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Uncle Biden"));


    }

    @Test
    public void getOneEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("employee.emp_middle_name", equalTo("EF"));
    }

   // @Test
    public void getEmploymentStatus() {
        RequestSpecification requestSpecification = given().
                header("Content-Type", "application/json").
                header("Authorization", token);

        Response response = requestSpecification.when().get("/employeementStatus.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        System.out.println("Get employeeStatus has been passed");

    }

    @Test
    public void getJobTitle() {
        RequestSpecification requestSpecification = given().
                header("Content-Type", "application/json").
                header("Authorization", token);

        Response response = requestSpecification.when().get("/jobTitle.php");

        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        System.out.println("Get job title has been passed");
    //------------confused how fix it ------------
      // response.body().jsonPath().getString("Jobs.id.1");

    }
}
