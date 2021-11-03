package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;


public class GitHubSteps {

    public static final String BASE_URL = "https://api.github.com/user/repos";
    public static final String TOKEN = "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";
//    public static final String USERNAME = "dzikTestowy";

    @Given("User is authorized")
    public void user_is_authorized() {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                .then()
                    .statusCode(200);
    }

    @When("^User creates new GitHub repo (.*)$")
    public void new_repo_is_created(String repo_name) {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"" + repo_name + "\"")
                .when()
                    .post(BASE_URL)
                .then()
                    .statusCode(201);
    }

    @Then("^User edits GitHub repo name from (.*) to (.*)$")
    public void repo_name_is_edited(String current_repo_name, String new_repo_name) {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"" + new_repo_name + "\"")
                .when()
                    .patch("https://api.github.com/repos/dzikTestowy/" + current_repo_name)
                .then()
                    .statusCode(200);
    }

    @Then("^User deletes GitHub repo (.*)$")
    public void repo_is_deleted(String repo_name) {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                .when()
                    .delete("https://api.github.com/repos/dzikTestowy/" + repo_name)
                .then()
                    .statusCode(204);
    }

}
