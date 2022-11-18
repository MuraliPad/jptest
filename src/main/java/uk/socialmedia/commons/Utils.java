package uk.socialmedia.commons;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static JSONObject readTestPostData () throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/resources/PostTestData.json"));
        JSONObject jsonObject = (JSONObject) object;
        return jsonObject;

    }


}
