package uk.socialmedia.test.stepdef;

import com.sun.org.apache.xpath.internal.operations.String;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import com.google.inject.Inject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonPathJsonbObjectDeserializer;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import uk.socialmedia.commons.SystemEndPt;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;


public class BasicCheck {


    Response response;

//@Inject
//    SystemEndPt systemEndPt;
    @Given("^as a system user$")
    public void asASystemUser() {
    }
    @And("^I am able to provide status of the backend site$")
    public void checkStatus() {
      //  System.out.println(SystemEndPt.baseurl);
        response = given().get(SystemEndPt.baseurl);
        Assert.assertTrue((response.getStatusCode() == 200));

        
    }
    @And("I am able to retrive all the posts successfully")
    public void postsretrival() {
        response = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.posturl)
                .then()
                .extract().response();
        Assert.assertTrue((response.getStatusCode() == 200));
        ArrayList<LinkedHashMap<String, String>> lhpostsResponse = response.jsonPath().get();
        //System.out.println(lhpostsResponse.get(1));
        Assert.assertTrue(lhpostsResponse.size() != 0);

    }
    @And("I am able to retrive all the comments succesfully")
    public void commentsretrival() {

        response = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.commenturl)
                .then()
                .extract().response();
        Assert.assertTrue((response.getStatusCode() == 200));
        ArrayList<LinkedHashMap<String, String>> lhpostsResponse = response.jsonPath().get();
        //System.out.println(lhpostsResponse.get(1));
        Assert.assertTrue(lhpostsResponse.size() != 0);


    }
    @And("I am able to retrive all the users succesfully")
    public void usersretrival() {

        response = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.usersurl)
                .then()
                .extract().response();
        Assert.assertTrue((response.getStatusCode() == 200));
        ArrayList<LinkedHashMap<String, String>> lhpostsResponse = response.jsonPath().get();
        System.out.println(lhpostsResponse.get(1));
        Assert.assertTrue(lhpostsResponse.size() != 0);


    }
}
