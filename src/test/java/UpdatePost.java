import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePost {

    @Test
    public void replacePost(){
        Map<String,Object> newPost = new HashMap<>();
        newPost.put("title","Tytul po aktualizacji");
        newPost.put("author", "Daria");

        given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .put("http://localhost:3000/posts/1")
                .then().log().all();
    }

    @Test
    public void replacePostObject(){
        Post newPost = new Post();
        newPost.setAuthor("Tomasz");
        //newPost.setTitle("Tytuł Tomka"); // niepodanie tej wartości spowoduje pojawienie się wartości domyślnej null

        given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .put("http://localhost:3000/posts/1")
                .then().log().all();
    }

    @Test
    public void updatePostObject(){
        Post newPost = new Post();
        //newPost.setAuthor("Dariusz");
        newPost.setTitle("Całkowicie nowy tytuł dla Dariusza"); // niepodanie tej wartości spowoduje pojawienie się wartości domyślnej null

        // metoda patch
        given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .patch("http://localhost:3000/posts/1")
                .then().log().all();
    }
}
