import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestMethodsTest {

    private static final String REQUEST_BODY = "This is expected to be sent back as part of response body.";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void shouldSendGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(2))
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    void shouldSendPostRequestRawText() {
        given()
                .contentType("text/plain; charset=UTF-8")
                .body(REQUEST_BODY)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json", equalTo(null))
                .body("data", equalTo(REQUEST_BODY))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void shouldSendPostRequestJson() {

        BodyWithParams body = new BodyWithParams();
        body.setFoo1("bar1");
        body.setFoo2("bar2");

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void shouldSendPostRequestFormData() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(""))
                .body("files.size()", equalTo(0))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void shouldSendPutRequest() {
        given()
                .contentType("text/plain; charset=UTF-8")
                .body(REQUEST_BODY)
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json", equalTo(null))
                .body("data", equalTo(REQUEST_BODY))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    void shouldSendPatchRequestRawText() {
        given()
                .contentType("text/plain; charset=UTF-8")
                .body(REQUEST_BODY)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json", equalTo(null))
                .body("data", equalTo(REQUEST_BODY))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    void shouldSendDeleteRequestRawText() {
        given()
                .contentType("text/plain; charset=UTF-8")
                .body(REQUEST_BODY)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json", equalTo(null))
                .body("data", equalTo(REQUEST_BODY))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
