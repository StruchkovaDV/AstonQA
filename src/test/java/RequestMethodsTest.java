import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestMethodsTest {

    private static final String requestBody = "This is expected to be sent back as part of response body.";

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
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    void shouldSendPostRequestRawText() {
        given()
                .contentType("text/plain; charset=UTF-8")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void shouldSendPostRequestFromData() {

        BodyWithParams body = new BodyWithParams();
        body.setFoo1("bar1");
        body.setFoo2("bar2");

        given()
                .log().all()
                /**
                 .contentType("application/x-www-form-urlencoded")
                 .formParam("foo1", "bar1")
                 .formParam("foo2", "bar2")
                 */
                .contentType("application/json")
                .body(body)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
/**
 .body("form.foo1", equalTo("bar1"))
 .body("form.foo2", equalTo("bar2"));
 */
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void shouldReturnExpectedBodyForPut() {

        ResponsePojo expected = buildExpectedResponse(
                "This is expected to be sent back as part of response body.",
                "https://postman-echo.com/put"
        );

        ResponsePojo actual = given()
                .baseUri("https://postman-echo.com")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(ResponsePojo.class);

        assertEquals(expected.getArgs(), actual.getArgs());
        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getFiles(), actual.getFiles());
        assertEquals(expected.getForm(), actual.getForm());
        assertEquals(expected.getJson(), actual.getJson());
        assertEquals(expected.getUrl(), actual.getUrl());
    }

    private ResponsePojo buildExpectedResponse(String data, String url) {
        ResponsePojo pojo = new ResponsePojo();

        pojo.setArgs(Collections.emptyMap());
        pojo.setData(data);
        pojo.setFiles(Collections.emptyMap());
        pojo.setForm(Collections.emptyMap());

        Map<String, String> headers = new HashMap<>();
        headers.put("host", "postman-echo.com");
        headers.put("content-length", "58");
        headers.put("accept-encoding", "gzip, br");
        headers.put("accept", "*/*");
        headers.put("x-forwarded-proto", "https");
        headers.put("user-agent", "PostmanRuntime/7.49.0");
        headers.put("content-type", "text/plain");
        headers.put("postman-token", "4a1e981e-c3e6-4e57-a62d-a3746cd73d75");
        headers.put("cache-control", "no-cache");
        pojo.setHeaders(headers);

        pojo.setJson(null);
        pojo.setUrl(url);

        return pojo;
    }

    @Test
    void shouldSendPatchRequestRawText() {
        given()
                .log().all()
                .contentType("text/plain; charset=UTF-8")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    void shouldSendDeleteRequestRawText() {
        given()
                .log().all()
                .contentType("text/plain; charset=UTF-8")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
