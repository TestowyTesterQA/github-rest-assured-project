package body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CheckLoginValue {

    public static final String BASE_URL = "https://api.github.com/users/";
    public static final String USERNAME = "dzikTestowy";

    @Test
    public void checkLogin() {
        RestAssured.get(BASE_URL + USERNAME)
                .then()
                .body("url", response -> Matchers.containsString(response.body().jsonPath().get("login")));
    }
}
