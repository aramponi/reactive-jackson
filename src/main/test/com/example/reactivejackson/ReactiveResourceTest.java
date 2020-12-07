package com.example.reactivejackson;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(ReactiveResource.class)
class ReactiveResourceTest {

    @Test
    public void ensure_there_is_no_null_attribute() {
        given().when()
                .log().all()
                .get("quarks")
                .then()
                .log().all()
                .body(
                        "name", is("???"),
                        "size()", is(1)
                )
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

}