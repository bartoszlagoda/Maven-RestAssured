import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import org.testng.annotations.Test;

import java.util.List;

public class XmlPathTests {

    @Test
    public void testXmlPath(){
        String xml = "<filmy>\n" +
                "    <film gatunek =\"komedia\">\n" +
                "\t    <id>1</id>\n" +
                "\t\t<nazwa>Forrest Gump</nazwa>\n" +
                "\t\t<ocena>8</ocena>\n" +
                "\t</film>\n" +
                "\t<film gatunek =\"komedia\">\n" +
                "\t    <id>2</id>\n" +
                "\t\t<nazwa>American Pie</nazwa>\n" +
                "\t\t<ocena>7</ocena>\n" +
                "\t</film>\n" +
                "\t<film gatunek =\"komedia\">\n" +
                "\t    <id>3</id>\n" +
                "\t\t<nazwa>Zielona mila</nazwa>\n" +
                "\t\t<ocena>9</ocena>\n" +
                "\t</film>\n" +
                "</filmy>";

        String nazwa = XmlPath.from(xml).get("filmy.film.nazwa[0]");
        List<String> nazwy = XmlPath.from(xml).getList("filmy.film.nazwa");
        String gatunek = XmlPath.from(xml).get("filmy.film[0].@gatunek");

        List<Node> filmy = XmlPath.from(xml).get("filmy.film.findAll {element -> return element}");
        String nazwaFilmu = filmy.get(2).get("nazwa").toString(); // Zielona mila

        List<Node> komedie = XmlPath.from(xml).get("filmy.film.findAll {film -> film.@gatunek == 'komedia'}");
        Node filmOcenaDziewiec = XmlPath.from(xml).get("filmy.film.find{film -> def ocena = film.ocena; ocena == '9'}");
        List<Node> wiekszeNizSiedem = XmlPath.from(xml).get("filmy.film.findAll{film -> def ocena = film.ocena.toFloat(); ocena > 7}");
        List<String> nazwyCollect = XmlPath.from(xml).get("filmy.film.collect {it.nazwa}");

    }
}
