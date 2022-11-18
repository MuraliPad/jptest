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

public class UserValidation {

    Response response;

    @And("I am able to validate the posts successfully")
    public void postsvalidation() {


        response = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.posturl)
                .then()
                .extract().response();
        Assert.assertTrue((response.getStatusCode() == 200));
        ArrayList<LinkedHashMap<String, String>> lhpostsResponse = response.jsonPath().get();
        System.out.println(lhpostsResponse.get(1));
        Assert.assertTrue(lhpostsResponse.size() != 0);
        //postId =  lhpostsResponse.get(1).get("id");
       // userId = lhpostsResponse.get(1).get("userId");
        Assert.assertTrue(lhpostsResponse.get(1).get("id") != null);
        Assert.assertTrue(lhpostsResponse.get(1).get("userId") != null);


    }
    @And("I am able to validate the comments successfully")
    public void commentsvalidation() {


        response = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.commenturl)
                .then()
                .extract().response();
        Assert.assertTrue((response.getStatusCode() == 200));
        ArrayList<LinkedHashMap<String, String>> lhpostsResponse = response.jsonPath().get();
     //   System.out.println(lhpostsResponse.get(1));
        Assert.assertTrue(lhpostsResponse.size() != 0);
        //postId =  lhpostsResponse.get(1).get("id");
        // userId = lhpostsResponse.get(1).get("userId");
        Assert.assertTrue(lhpostsResponse.get(1).get("id") != null);
        Assert.assertTrue(lhpostsResponse.get(1).get("postId") != null);


    }
    @And("I am able to validate the users successfully")
    public void usersvalidation() {


        response = given()
                .contentType(ContentType.JSON)
                .get(SystemEndPt.usersurl)
                .then()
                .extract().response();
        Assert.assertTrue((response.getStatusCode() == 200));
        ArrayList<LinkedHashMap<String, String>> lhpostsResponse = response.jsonPath().get();
        System.out.println(lhpostsResponse.get(1));
        Assert.assertTrue(lhpostsResponse.size() != 0);
        //postId =  lhpostsResponse.get(1).get("id");
        // userId = lhpostsResponse.get(1).get("userId");
        Assert.assertTrue(lhpostsResponse.get(1).get("id") != null);
        Assert.assertTrue(lhpostsResponse.get(1).get("name") != null);
        Assert.assertTrue(lhpostsResponse.get(1).get("username") != null);
        Assert.assertTrue(lhpostsResponse.get(1).get("email") != null);


    }
}
