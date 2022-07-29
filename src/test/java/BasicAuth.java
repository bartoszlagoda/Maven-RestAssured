import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@Test
public class BasicAuth {
    public void vasicAuth(){
        given()
                .auth().basic("postman", "password").
        when()
                .get("https://postman-echo.com/basic-auth").
        then()
                .log().all().statusCode(200);
    }
}
