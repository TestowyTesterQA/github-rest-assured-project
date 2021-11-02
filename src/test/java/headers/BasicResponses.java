package headers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class BasicResponses {

    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.get(BASE_URL);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkContentType() {
        Response response = RestAssured.get(BASE_URL);
        assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }

    @Test
    public void checkHeaders() {
        Response response = RestAssured.get(BASE_URL);

        assertEquals(response.getHeader("server"), "GitHub.com");
        assertEquals(response.getHeader("x-ratelimit-limit"), "60"); // getHeaders always return string
        //OR
        assertEquals(Integer.parseInt(response.getHeader("x-ratelimit-limit")), 60);
    }

    @Test
    public void basicValidatableExample() {
        RestAssured.get(BASE_URL)
                .then()
                .assertThat() // syntactic sugar
                    .statusCode(200)
                .and()
                    .contentType(ContentType.JSON)
                .and()
                    .header("x-ratelimit-limit", "60")
                .and()
                    .header("server", "GitHub.com")
                .and()
                .assertThat()
                    .header("x-xss-protection", "0");
    }


}
