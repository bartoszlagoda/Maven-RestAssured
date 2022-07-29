import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class JiraGetIssue {
    @Test
    public void getIssue(){
        given()
                .auth().preemptive().basic("bartosz.lagoda95@gmail.com", "ZzVYmY0gtIk4Vpwyo7Km939F").
        when()
                .get("https://bartoszlagoda95.atlassian.net/rest/api/2/issue/TEST-1").
        then()
                .log().all();
    }
}
