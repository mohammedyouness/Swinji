package api.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoredApiSteps {

    private final String baseURL = "https://www.boredapi.com/api";
    private Response response;

    @Given("GET Bored API")
    public void get_bored_api() {
        RestAssured.baseURI = baseURL;
    }

    @When("I request a random activity from the Bored API")
    public void i_request_a_random_activity_from_the_bored_api() {
        response = RestAssured.given().get("/activity");
    }

    @Then("The response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

//    @Then("The response should contain property {string}")
//    public void the_response_should_contain_property(String expectedProperty) {
//        response.then().assertThat().body("$", hasKey(expectedProperty));
//    }
}
