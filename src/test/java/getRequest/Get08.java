package getRequest;

import baseURLs.SwapiDevApiBaseURL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class Get08 extends SwapiDevApiBaseURL {
    /*

    Given
	   	     https://swapi.dev/api/vehicles/4
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
   {
    "name": "Sand Crawler",
    "model": "Digger Crawler",
    "manufacturer": "Corellia Mining Corporation",
    "cost_in_credits": "150000",
    "length": "36.8 ",
    "max_atmosphering_speed": "30",
    "crew": "46",
    "passengers": "30",
    "cargo_capacity": "50000",
    "consumables": "2 months",
    "vehicle_class": "wheeled",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/5/"
    ],
    "created": "2014-12-10T15:36:25.724000Z",
    "edited": "2014-12-20T21:30:21.661000Z",
    "url": "https://swapi.dev/api/vehicles/4/"
}


     */

    @Test
    public void homework4() {
        specification.pathParams("vehiclesPath", "vehicles", "idPath", "4");

        //Kullanıcı GET Methodu ile Request Gönderir
        Response response=given().
                when().
                spec(specification).
                get("/{vehiclesPath}/{idPath}");

        //Status Code un "200" olduğunu Assert et
        response.then().assertThat().statusCode(200);

        response.prettyPrint();
        //Response body nin bu şekilde olduğunu doğrular

     /*   String expectedData ="{\n" +
                "    \"name\": \"Sand Crawler\",\n" +
                "    \"model\": \"Digger Crawler\",\n" +
                "    \"manufacturer\": \"Corellia Mining Corporation\",\n" +
                "    \"cost_in_credits\": \"150000\",\n" +
                "    \"length\": \"36.8 \",\n" +
                "    \"max_atmosphering_speed\": \"30\",\n" +
                "    \"crew\": \"46\",\n" +
                "    \"passengers\": \"30\",\n" +
                "    \"cargo_capacity\": \"50000\",\n" +
                "    \"consumables\": \"2 months\",\n" +
                "    \"vehicle_class\": \"wheeled\",\n" +
                "    \"pilots\": [\n" +
                "        \n" +
                "    ],\n" +
                "    \"films\": [\n" +
                "        \"https://swapi.dev/api/films/1/\",\n" +
                "        \"https://swapi.dev/api/films/5/\"\n" +
                "    ],\n" +
                "    \"created\": \"2014-12-10T15:36:25.724000Z\",\n" +
                "    \"edited\": \"2014-12-20T21:30:21.661000Z\",\n" +
                "    \"url\": \"https://swapi.dev/api/vehicles/4/\"\n" +
                "}";



        String actualData =response.getBody().asString();

        Assert.assertEquals(expectedData,actualData); */

        //---------------  2.YOL -------------------


        // Step 2 : ---->>Expected Data
        //
        List<String>filmslist =new ArrayList<>();
        filmslist.add("https://swapi.dev/api/films/1/");
        filmslist.add("https://swapi.dev/api/films/5/");

        List<String>pilotlist =new ArrayList<>();
        System.out.println("pilotlist:"+pilotlist);

        Map<String, Object> expectedDataMap =new HashMap<>();
        expectedDataMap.put("name","Sand Crawler");
        expectedDataMap.put("model","Digger Crawler");
        expectedDataMap.put("manufacturer","Corellia Mining Corporation");
        expectedDataMap.put("cost_in_credits","150000");
        expectedDataMap.put("length","36.8 ");
        expectedDataMap.put("max_atmosphering_speed","30");
        expectedDataMap.put("crew","46");
        expectedDataMap.put("passengers","30");
        expectedDataMap.put("cargo_capacity","50000");
        expectedDataMap.put("consumables","2 months");
        expectedDataMap.put("vehicle_class","wheeled");
        expectedDataMap.put("pilots",pilotlist);
        expectedDataMap.put("films",filmslist);
        expectedDataMap.put("created","2014-12-10T15:36:25.724000Z");
        expectedDataMap.put("edited","2014-12-20T21:30:21.661000Z");
        expectedDataMap.put("url","https://swapi.dev/api/vehicles/4/");

        System.out.println("Expected Data Map :"+ expectedDataMap);




        //step 4 : Assertion
        //---------1.YOL ----------------

        response.then().assertThat().body("name",equalTo(expectedDataMap.get("name")),
                "model",equalTo(expectedDataMap.get("model")),
                "manufacturer",equalTo(expectedDataMap.get("manufacturer")),
                "length",equalTo(expectedDataMap.get("length")),
                "max_atmosphering_speed",equalTo(expectedDataMap.get("max_atmosphering_speed")),
                "crew",equalTo(expectedDataMap.get("crew")),
                "passengers",equalTo(expectedDataMap.get("passengers")),
                "cargo_capacity",equalTo(expectedDataMap.get("cargo_capacity")),
                "consumables",equalTo(expectedDataMap.get("consumables")),
                "vehicle_class",equalTo(expectedDataMap.get("vehicle_class")),
                "pilots",equalTo(expectedDataMap.get("pilots")),
                "films",equalTo(expectedDataMap.get("films")),
                "created",equalTo(expectedDataMap.get("created")),
                "edited",equalTo(expectedDataMap.get("edited")),
                "url",equalTo(expectedDataMap.get("url")));



        //-----------2.YOL ------------GSON yöntemiyle
        //Assertion Mantığı --> (Expected Data  = Actual Data )?

        Map<String,Object>actualData = response.as(HashMap.class);

        // ---> Step 3 'teki Response

        System.out.println("actual Data:"+actualData);

        assertEquals(expectedDataMap.get("name"),actualData.get("name")); // --> hard assertion
        assertEquals(expectedDataMap.get("max_atmosphering_speed"),actualData.get("max_atmosphering_speed"));
        assertEquals(expectedDataMap.get("crew"),actualData.get("crew"));
        assertEquals(expectedDataMap.get("passengers"),actualData.get("passengers"));
        assertEquals(expectedDataMap.get("cargo_capacity"),actualData.get("cargo_capacity"));
        assertEquals(expectedDataMap.get("consumables"),actualData.get("consumables"));
        assertEquals(expectedDataMap.get("vehicle_class"),actualData.get("vehicle_class"));
        assertEquals(expectedDataMap.get("pilots"),actualData.get("pilots"));
        assertEquals(expectedDataMap.get("films"),actualData.get("films"));
        assertEquals(expectedDataMap.get("created"),actualData.get("created"));
        assertEquals(expectedDataMap.get("edited"),actualData.get("edited"));
        assertEquals(expectedDataMap.get("url"),actualData.get("url"));
        assertEquals(expectedDataMap.get("model"),actualData.get("model"));
        assertEquals(expectedDataMap.get("manufacturer"),actualData.get("manufacturer"));
        assertEquals(expectedDataMap.get("length"),actualData.get("length"));


        /*
         * GSON ------ > Deserialization --> Json objesini JAVA objesine çevirmek(convert) etmek demektir.
         *
         *
         * */

        // -------->>> assertion en kısa yoluu ----

        assertEquals(expectedDataMap,actualData);

        //----------------------------------------------------

        /*
         * HOMEWORKS-1:
         * jsonpath --- Soft assertion kullanarak çözümünü yapınız.
         *
         */



        JsonPath actualJson = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expectedDataMap.get("name"),actualJson.getString("name"));
        softAssert.assertEquals(expectedDataMap.get("max_atmosphering_speed"), actualJson.getString("max_atmosphering_speed"));
        softAssert.assertEquals(expectedDataMap.get("cargo_capacity"), actualJson.getString("cargo_capacity"));
        softAssert.assertEquals(expectedDataMap.get("films"), actualJson.getList("films"));
        softAssert.assertEquals(expectedDataMap.get("passengers"), actualJson.getString("passengers"));
        softAssert.assertEquals(expectedDataMap.get("pilots"), actualJson.getList("pilots"));
        softAssert.assertEquals(expectedDataMap.get("edited"), actualJson.getString("edited"));
        softAssert.assertEquals(expectedDataMap.get("consumables"), actualJson.getString("consumables"));
        softAssert.assertEquals(expectedDataMap.get("created"), actualJson.getString("created"));
        softAssert.assertEquals(expectedDataMap.get("length"), actualJson.getString("length"));
        softAssert.assertEquals(expectedDataMap.get("url"), actualJson.getString("url"));
        softAssert.assertEquals(expectedDataMap.get("manufacturer"), actualJson.getString("manufacturer"));
        softAssert.assertEquals(expectedDataMap.get("crew"), actualJson.getString("crew"));
        softAssert.assertEquals(expectedDataMap.get("vehicle_class"),actualJson.getString("vehicle_class"));
        softAssert.assertEquals(expectedDataMap.get("cost_in_credits"), actualJson.getString("cost_in_credits"));
        softAssert.assertEquals(expectedDataMap.get("model"), actualJson.getString("model"));

        softAssert.assertAll();

        softAssert.assertEquals(expectedDataMap,actualData);
        softAssert.assertEquals(expectedDataMap,actualJson);


        System.out.println("softAssert ile yapıldı.");

        /*// Homeworks-2:

        /*
        GSON
        JsonPath

        metotoalrını kullanarak assertion işlemlerini tamamlayınız .
         */










    }

}
