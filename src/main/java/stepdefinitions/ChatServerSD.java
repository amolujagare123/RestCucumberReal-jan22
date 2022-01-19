package stepdefinitions;

import Util.pojo.ChatCreateUserPOJO;
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

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class ChatServerSD {

    RequestSpecification reqSpec;
    RequestSpecification request;
    ChatCreateUserPOJO chatCreateUserPOJO;
    Response response;
    ResponseSpecification resp;
    String responseStr;

    @Given("Add user payload is created")
    public void add_user_payload_is_created() {

        chatCreateUserPOJO = new ChatCreateUserPOJO();
        chatCreateUserPOJO.setName("amol333");
        chatCreateUserPOJO.setSurname("ujagare");
        chatCreateUserPOJO.setUsername("amol3335");
        chatCreateUserPOJO.setPassword("1234");
        chatCreateUserPOJO.setChat_nickname("am");
        chatCreateUserPOJO.setEmail("amol@gmail.com");

        ArrayList<Integer> dept = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        chatCreateUserPOJO.setDepartments(dept);


        ArrayList<Integer> deptGrp = new ArrayList<Integer>() {{
            add(1);

        }};

        chatCreateUserPOJO.setDepartment_groups(deptGrp);

        ArrayList<Integer> usrGrp = new ArrayList<Integer>() {{
            add(1);

        }};

        chatCreateUserPOJO.setUser_groups(usrGrp);

        ArrayList<Integer> deptRead = new ArrayList<Integer>() {{

            add(2);
        }};

        chatCreateUserPOJO.setDepartments_read(deptRead);

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

           reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin")
                .setAuth(auth)
                .addHeader("Content-Type", "application/json")
                   .build();

         request = given().log().all().spec(reqSpec);

    }
    @When("User calls CreateUser request using POST method")
    public void user_calls_create_user_request_using_post_method() {

         response = request.body(chatCreateUserPOJO).when().post("/restapi/user");

    }
    @Then("the API call got success with status code {string}")
    public void the_api_call_got_success_with_status_code(String statusCode) {

         resp = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

          responseStr  = response.then().log().all().spec(resp).extract().asString();

    }
    @Then("{string} should be {string};")
    public void should_be(String jsonPath, String expectedValue) {

        JsonPath js = new JsonPath(responseStr);

        String actual = js.getString(jsonPath);

        Assert.assertEquals("the json path value doesnot match",expectedValue,actual);
    }
}
