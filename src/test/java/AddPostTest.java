import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void addPostMap(){
        Map<String,Object> newPost = new HashMap<>();
        newPost.put("title","Tytul z mapy");
        newPost.put("author", "Daria");

        given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .post("http://localhost:3000/posts")
                .then().log().all();
    }

    @Test
    public void addPostObject(){
        Post newPost = new Post();
        newPost.setTitle("Tytuł obiektowy");
        newPost.setAuthor("Autor obiektowy");


        given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .post("http://localhost:3000/posts")
                .then().log().all();
    }
}
