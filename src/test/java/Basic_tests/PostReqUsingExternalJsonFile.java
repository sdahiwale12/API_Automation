package Basic_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostReqUsingExternalJsonFile {

    String userId;

    @Test(dependsOnMethods = "createUser", priority = 2)
    public void getUser(){

        given().
                when().pathParam("id", userId).get("http://localhost:3000/posts/{id}")
                .then().statusCode(200).log().all();

    }

    @Test(priority = 1)
    public void createUser() throws IOException {

        ObjectMapper mapper = new JsonMapper();
        File datafile = new File(".\\bodydata.json");
        postdata data  = mapper.readValue(datafile, postdata.class);

        Response response = given().contentType("application/json").body(data).
                when().post("http://localhost:3000/posts").
                then().statusCode(201).extract().response();

        userId = response.jsonPath().getString("id");
    }


}
