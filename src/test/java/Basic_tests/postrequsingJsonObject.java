package Basic_tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class postrequsingJsonObject {

    @Test(dependsOnMethods = "createUser", priority = 2)
    public void getUser(){

       given().when().get("http://localhost:3000/posts/31")
               .then().statusCode(200).log().all();

    }

    @Test(priority = 1)
    public void createUser(){

        JSONObject data = new JSONObject();
        data.put("id", "31");
        data.put("title", "first-post");
        data.put("author", "Sahil");

        given().contentType("application/json").body(data.toString()).
        when().post("http://localhost:3000/posts").
        then().statusCode(201).log().all();

    }
}
