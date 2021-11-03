package api.body;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class NestedBodyValidation {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void nestedBodyValidation() {
        RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .rootPath("resources.core")
                    .body("limit", equalTo(60))
                    .body("remaining", lessThanOrEqualTo(70))
                    .body("reset", notNullValue())
                .rootPath("resources.search")
                    .body("limit", equalTo(10))
                    .body("remaining", lessThanOrEqualTo(15))
                .noRootPath()
                    .body("resources.graphql.limit", is(0));
    }
}
