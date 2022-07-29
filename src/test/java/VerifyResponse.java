import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.Post;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class VerifyResponse {

    @Test
    public void getPost() {

        String expected = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"Post Darii\",\n" +
                "  \"author\": \"Daria\"\n" +
                "}";


        given().log().all().when().get("http://localhost:3000/posts/{id}", 1)
                .then().log().all().body(Matchers.equalTo(expected));


    }

    @Test
    public void getPostContains() {

        // sprawdzamy czy body odpowiedzi zawiera jakieś słowo
        given().log().all().when().get("http://localhost:3000/posts/{id}", 1)
                //.then().log().all().body(Matchers.containsString("Daria"));
        .then().log().all().body(Matchers.containsStringIgnoringCase("daria"));
    }

    @Test
    public void checkSpecificField() {

        // sprawdzamy czy body odpowiedzi zawiera jakieś słowo
        when().
                get("http://localhost:3000/posts/{id}", 1).
                then().
                assertThat().body("title",Matchers.equalTo("Post Darii")).
        and().
                assertThat().body("author", Matchers.equalTo("Daria"));
    }

    @Test
    public void getPostObject(){
        Post newPost = given().log().all().when().get("http://localhost:3000/posts/{id}", 1)
                .then().log().all().body("title",Matchers.equalTo("Post Darii"))
                .and().body("author", Matchers.equalTo("Daria")).extract().body()
                .as(Post.class);

        Assert.assertEquals(newPost.getAuthor(), "Daria");
        Assert.assertEquals(newPost.getTitle(), "Post Darii");
        Assert.assertEquals(newPost.getId(), 1);
    }

    @Test
    public void addPostObject(){
        Post newPost = new Post();
        newPost.setTitle("Tytuł obiektowy");
        newPost.setAuthor("Autor obiektowy");


        Post createdPost = given().log().all().contentType(ContentType.JSON)
                .body(newPost).when()
                .post("http://localhost:3000/posts")
                .then().log().all()
                .extract().body().as(Post.class);

        Assert.assertEquals(newPost.getAuthor(),"Autor obiektowy");
        Assert.assertEquals(newPost.getTitle(),"Tytuł obiektowy");
    }
}
