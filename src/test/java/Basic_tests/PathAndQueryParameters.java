package Basic_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameters {

    String userId;

    @Test(dependsOnMethods = "createUser", priority = 2)
    public void getUser(){

        given().queryParam("id", userId)
                .when().get("http://localhost:3000/posts/")
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
