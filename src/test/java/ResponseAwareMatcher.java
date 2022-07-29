import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;

public class ResponseAwareMatcher {

    @Test
    public void getPost(){
        when()
                .get("http://localhost:3000/posts/{postId}", 1).
                then()
                .body("specificField", response -> Matchers.equalTo("10192020" + response.path("secretString")));
                /*.body("specificField", new io.restassured.matcher.ResponseAwareMatcher<Response>() {
                    // poniższ kod utworzy się samoistnie po wywołaniu powyższego matchera
                    @Override
                    public Matcher<?> matcher(Response response) throws Exception {
                        return Matchers.equalTo("10192020" + response.path("secretString"));
                    }
                });*/
    }
}
