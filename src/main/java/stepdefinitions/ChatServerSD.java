package stepdefinitions;

import Util.ChatServerUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ChatServerSD extends ChatServerUtil {

    RequestSpecification reqSpec;
    RequestSpecification request;
  //  ChatCreateUserPOJO chatCreateUserPOJO;
    Response response;
    ResponseSpecification resp;
    String responseStr;

    @Given("Add user payload is created")
    public void add_user_payload_is_created() throws IOException {

         reqSpec =getRequestSpecification();
         request = given().log().all().spec(reqSpec);

    }

 /*   @When("User calls CreateUser request using POST method")
    public void user_calls_create_user_request_using_post_method() {

         response = request.body(getCreateUserPayload()).when().post("/restapi/user");

    }*/

    @When("^User calls CreateUser request using POST method with (.+) , (.+), (.+),(.+)$")
    public void user_calls_createuser_request_using_post_method_with_(String username, String password, String name, String surname)
            {
        response = request.body(getCreateUserPayload(username,password,name,surname)).when().post("/restapi/user");
    }

    @Then("the API call got success with status code {string}")
    public void the_api_call_got_success_with_status_code(String statusCode) {

         resp = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

          responseStr  = response.then().log().all().spec(resp).extract().asString();

    }
    @Then("{string} should be {string};")
    public void should_be(String jsonPath, String expectedValue) {

        JsonPath js = new JsonPath(responseStr);

        String actual = js.get(jsonPath).toString();

        Assert.assertEquals("the json path value doesnot match",expectedValue,actual);
    }
}
