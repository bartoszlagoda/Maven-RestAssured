import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetSpecificPostTest {

    @Test
    public void getPosts(){
        // test będzie poprawny, choć takie id nie jest wprowadzone
        // nie sprawdzamy tutaj konkretnej wartości response
        when().get("http://localhost:3000/posts/2").then().log().all();
    }
}
