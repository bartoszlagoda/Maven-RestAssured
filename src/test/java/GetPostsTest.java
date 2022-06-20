import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetPostsTest {
    //public static void main(String[] args) {
        // metoda get potrzebuje tylko wyświetlenia całego zasobu
        // nic nie dostarczamy
        // response body
        //when().get("http://localhost:3000/posts").then().log().body();
        // wszystko co było potrzebne do uzyskania odpowiedzi
        //when().get("http://localhost:3000/posts").then().log().all();
        // błąd będzie tylko wtedy gdy status code nie będzie równy 200
        //when().get("http://localhost:3000/posts").then().log().ifValidationFails().statusCode(200);
    //}

    @Test
    public void getPosts(){
        // response body
        when().get("http://localhost:3000/posts").then().log().body();
    }
}
