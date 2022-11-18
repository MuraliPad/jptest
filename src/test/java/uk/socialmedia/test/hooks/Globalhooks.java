package uk.socialmedia.test.hooks;

import io.cucumber.java.Before;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import uk.socialmedia.commons.SystemEndPt;

public class Globalhooks {

    @Before
    public void readTestEndPoints() throws IOException, ParseException {

       JSONParser parser = new JSONParser();
       Object obj = parser.parse(new FileReader("src/main/resources/EndPoints.json"));

       JSONObject systemEntPts = (JSONObject) obj;
       String env = System.getProperty("env");
       JSONObject envObject = (JSONObject) systemEntPts.get("dev");


        SystemEndPt.baseurl = (String) envObject.get("base_url");
        SystemEndPt.posturl = (String) envObject.get("makepost");
        SystemEndPt.commenturl = (String) envObject.get("comment");
        SystemEndPt.usersurl = (String) envObject.get("users");

    }


}
