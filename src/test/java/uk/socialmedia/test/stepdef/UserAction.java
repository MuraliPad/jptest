package uk.socialmedia.test.stepdef;

import com.sun.org.apache.xpath.internal.operations.String;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import uk.socialmedia.commons.SystemEndPt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static uk.socialmedia.commons.Utils.readTestPostData;

public class UserAction {
    Response response;
    String idafterPost;
    ArrayList<LinkedHashMap<String, String>> lhpostsResponse;
    //JSONObject lhpostnew;
    LinkedHashMap<String, String> lhpostnew;
    StringBuilder resid = new StringBuilder();

    @Given("I could retrive the existing user")
    public void retriveExistingUser() {
        response = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.posturl)
                .then()
                .extract().response();
        Assert.assertTrue((response.getStatusCode() == 200));
        lhpostsResponse = response.jsonPath().get();

    }
    @And("I am able to create new posts")
    public void createnewPost() throws IOException, ParseException {
        JSONObject testObject = readTestPostData();
        StringBuilder userSBId = new StringBuilder();

        userSBId.append( lhpostsResponse.get(1).get("userId"));

        testObject.put("userId", userSBId);

        response = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .and()
                .body(testObject)
                .when()
                .post(SystemEndPt.posturl)
                .then()
                .statusCode(201)
                .extract().response();
        lhpostnew = response.jsonPath().get();
       resid.append(response.jsonPath().get("id").toString());





    }
    @And("I am able to update the created posts")
    public void updatethepost() throws IOException, ParseException {

        Response afterUpdate;
        JSONObject testObject = readTestPostData();
        StringBuilder userSBId = new StringBuilder();

        userSBId.append( lhpostsResponse.get(1).get("userId"));

        testObject.put("userId", userSBId);
         testObject.put("title","modify for put");
        response = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .and()
                .body(testObject)
                .when()
                .put(SystemEndPt.posturl+"/"+resid)
                .then()
                .statusCode(201)
                .extract().response();

        // Verify the response after update

        afterUpdate = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.posturl+ "/"+resid)
                .then()
                .extract().response();
        Assert.assertTrue(afterUpdate.jsonPath().get("title").toString().contains("modify for put") );


    }

}
