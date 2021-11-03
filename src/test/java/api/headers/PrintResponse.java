package api.headers;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PrintResponse {

    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void prettyPrint() {
        RestAssured.get(BASE_URL)
                .prettyPrint();
    }
}
