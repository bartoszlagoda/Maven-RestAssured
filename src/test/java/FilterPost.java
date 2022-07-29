import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FilterPost {
    @Test
    public void filterPosts(){
        // filtrowanie po imiieniu autora
        given().queryParam("author","Daria")
                .when().get("http://localhost:3000/posts")
                .then().log().all();
    }
    @Test
    public void filterPostsById(){
        given().log().all().queryParam("id","1","2")
                .when().get("http://localhost:3000/posts")
                //.then().log().all().statusCode(200);
                //.then().log().all().statusCode(Matchers.equalTo(200));
                //.then().log().all().statusCode(Matchers.greaterThanOrEqualTo(200));
                .then().log().all().statusLine(Matchers.containsString("OK"));
    }

    @Test
    public void filterPostsByParams(){
        Map<String, Object> params = new HashMap<>();
        params.put("author","Bartosz");
        params.put("title","drugi-post");
        given().log().all().queryParams(params)
                .when().get("http://localhost:3000/posts")
                .then().log().all();
    }
}
