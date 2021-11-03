package api.headers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ResponseTime {

    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void checkResponsesTime() {
        Response response = RestAssured.get(BASE_URL);
        System.out.print(response.getTime() + " miliseconds\n");
        System.out.print(response.getTimeIn(TimeUnit.MINUTES) + " minutes\n");
        System.out.print(response.getTimeIn(TimeUnit.MICROSECONDS) + " microseconds\n");
    }
}
