package api.body;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.Map;

public class Failures {

    public static final String BASE_URL = "https://api.github.com/rate_limit";

    @Test
    public void castingFailure() {
        JsonPath jPath = RestAssured.get(BASE_URL).body().jsonPath();
//
//        Map<String, String> isNull = jPath.get("incorrect.path"); //Null Pointer Exception
//        int aMap = jPath.get("resources.core"); //correct path, but it returns map not an integer --> ClassCastException
//        String value = jPath.get("resources.core.limit"); // correct path to specific value but wrong type! --> ClassCastException
    }
}
