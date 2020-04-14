package io.rasologg.restassured.test;

import com.aventstack.extentreports.Status;
import io.rasologg.restassured.extentreports.ExtentTestManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class RestAssuredExample extends RestAssuredBase {

    Logger logger = LogManager.getLogger(RestAssuredExample.class);

    @Test
    public void whenGetEmplyeesThenSuccess(){
        ExtentTestManager.getTest().log(Status.INFO, "Base URI : "+RestAssured.baseURI);

        String path = "/employees";
        ExtentTestManager.getTest().log(Status.INFO, "Path : "+path);

        Response response = given()
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo("1"))
                .body("data[0].employee_salary", equalTo("320800"))
                .extract().response();
        logger.info(response.body().prettyPrint());
        ExtentTestManager.getTest().log(Status.INFO, "Response Body <br> "+response.body().prettyPrint());
    }
}
