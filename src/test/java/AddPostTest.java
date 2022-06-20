import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class AddPostTest {
    @Test
    public void addPost(){
        String newPost = "{\n" +
                "        \"title\": \"drugi-post\",\n" +
                "        \"author\": \"Bartosz\"\n" +
                "}";
        // taki post zwróci nam tylko id, pod którym nowy post będzie zwrócony
        given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .post("http://localhost:3000/posts")
                .then().log().all();
    }

    @Test
    public void addPostFromFile(){
        File newPost = new File("C:\\Users\\barte\\IdeaProjects\\MavenRestAssured\\src\\test\\resources\\post,json");

        given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .post("http://localhost:3000/posts")
                .then().log().all();
    }
}
