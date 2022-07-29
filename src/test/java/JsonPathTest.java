import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JsonPathTest {
    @Test
    public void checkSpecificFieldJsonPath() {

        // definiujemy w Response URL
        Response response = RestAssured.get("http://localhost:3000/posts/1");
//        System.out.println(response.asString());
//        // wyciąganie elementów za pomocą JSONPatha
//        String secretString = response.path("secretString");
//        List<Integer> winningNumbers = response.path("winning-numbers");
//        String firstWinnerName = response.path("winners.name[0]");
//        String secondWinnerName = response.path("winners[1].name");
//        // lub w tablicach możemy się odwoływać do elementów ujemnymi liczbami
//        String secondWinnerNameSec = response.path("winners[-1].name");
//        // Lista zwycięzców
//        List<String> winnerNames = response.path("winners.name");
//        // pierwszy zwycięzca za pomocą mapy
//        Map<String,?> winner = response.path("winners[0]");
//        // wszyscy zwycięzcy za pomocą mapy
//        List<Map<String,?>> winners = response.path("winners");

        //Map<String,?> winnerInfo = response.path("winners.find {it.name=='Andrew'}");
        //Integer winnerId = response.path("winners.find {it.name=='Andrew'}.winnerId");
        /*Integer maxNumber = response.path("winning-numbers.max()");
        Integer minNumber = response.path("winning-numbers.min()");
        Map<String,?> winnerMaxId = response.path("winners.max{it.winnerId}");
        Integer moneySum = response.path("winners.collect{it.money}.sum()");*/

        List<Integer> winnersId = response.path("winners.findAll {it.name=='John'}.winnerId");




    }
}
