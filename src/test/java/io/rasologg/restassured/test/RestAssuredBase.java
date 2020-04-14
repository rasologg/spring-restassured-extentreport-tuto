package io.rasologg.restassured.test;

import io.rasologg.restassured.listeners.TestListener;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class RestAssuredBase {
    Logger logger = Logger.getLogger(RestAssuredBase.class);

    @BeforeSuite
    public void setUp(){
        logger.info("Before suite method");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }
}
