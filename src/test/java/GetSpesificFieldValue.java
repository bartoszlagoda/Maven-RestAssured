import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetSpesificFieldValue {

    @Test
    public void checkSpecificField() {

        // definiujemy w Response URL
        Response response = RestAssured.get("http://localhost:3000/posts/1");
        // podajemu path, w którym deklarujemy chęć uzyskania author
        String author = response.path("author");
        // sprawdzamy, czy author jest równy Daria
        Assert.assertEquals(author, "Daria");
    }

    @Test
    public void checkSpecificFieldJsonPath() {

        // definiujemy w Response URL
        Response response = RestAssured.get("http://localhost:3000/posts/1");
        // podajemu path, w którym deklarujemy chęć uzyskania author
        JsonPath jsonPath = new JsonPath(response.asString());
        String author = jsonPath.get("author");
        // sprawdzamy, czy author jest równy Daria
        Assert.assertEquals(author, "Daria");
    }

    @Test
    public void checkSpecificFieldJsonPathSecond() {

        // definiujemy w Response URL
        Response response = RestAssured.get("http://localhost:3000/posts/1");
        // podajemu path, w którym deklarujemy chęć uzyskania author
        JsonPath jsonPath = new JsonPath(response.asString());
        String author = jsonPath.get("author");
        // sprawdzamy, czy author jest równy Daria
        Assert.assertEquals(author, "Daria");

        String stringResponse = RestAssured.get("http://localhost:3000/posts/1").asString();
        String author2 = JsonPath.from(stringResponse).get("author");

        Assert.assertEquals(author2, "Daria");
    }
}
