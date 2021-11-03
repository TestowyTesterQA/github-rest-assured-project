package api.payloadMapping;
import com.User;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ObjectMapping {

    public static final String BASE_URL = "https://api.github.com/users/dzikTestowy";

    @Test
    public void objectMapping() {

        User user = RestAssured.get(BASE_URL)
                .as(User.class);

        assertEquals(user.getLogin(), "dzikTestowy");
        assertEquals(user.getId(), 93586821);
        assertEquals(user.getPublicRepos(), 2);

    }

}
