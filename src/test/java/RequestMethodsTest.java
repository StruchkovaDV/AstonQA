import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestMethodsTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void shouldSendGetRequest(){
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    void shouldSendPostRequestRawText(){

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain; charset=UTF-8")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    void shouldSendPostRequestFromData(){

        BodyWithParams body = new BodyWithParams();
        body.setFoo1("bar1");
        body.setFoo2("bar2");

        given()
                /**
                 * .contentType("application/x-www-form-urlencoded")
                 * .formParam("foo1", "bar1")
                 * .formParam("foo2", "bar2")
                 */
                .contentType("application/json")
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                /**
                 * .body("form.foo1", equalTo("bar1"))
                 *  .body("form.foo2", equalTo("bar2"));
                 */
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"));
    }

}
