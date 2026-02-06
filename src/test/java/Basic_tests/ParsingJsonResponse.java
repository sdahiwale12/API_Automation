package Basic_tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingJsonResponse {

    @Test
    public void parsedata(){

       Response commentsdata =  given().contentType(ContentType.JSON).
                when().get("http://localhost:3000/comments");

       //Assert.assertEquals(commentsdata.getHeader("contentType"), "application/json charSet=");
       String comment = commentsdata.jsonPath().getString("[1].body");
       Assert.assertEquals(comment, "Informative!");
    }
}
