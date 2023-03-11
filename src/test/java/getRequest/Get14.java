package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;
import utilities.JavaToJson;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Get14 extends JsonPlaceHolderBaseURL {

     /*


        Given
            https://jsonplaceholder.typicode.com/todos/198
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

  {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }

     */
    @Test
    public void get14() {
        specification.pathParams("todopath", "todos", "idpath", "198");


        //step 2 :Expected Data
        String expectedData = "{\n" +
                "   \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "   \"completed\": true\n" +
                " }";

        HashMap<String, Object> expectedDataMap = JavaToJson.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap = " + expectedDataMap);

        //Homework :Expected data yı JsonPlaceHolderTestData classında bir tane method create ederek yapınız.
        /*
        * JsonPlaceHolderBaseURL jsonPlaceHolderBaseURL = new JsonPlaceHolderBaseURL();

        String ex = jsonPlaceHolderBaseURL.createEdilen(userId); */

        //Step 3 : Send Rewuest
        Response response = given().
                spec(specification).
                when().
                get("/{todopath}/{idpath}");


        //step 4 :Assertion
        //actualData response 'dan alınır.

        //  HashMap<String,Object>actualDataMap =response.as(HashMap.class);//---> Gson
        //  JsonPath jsonPath=response.jsonPath();//--> json
        //  response.then().assertThat().body("");-->> response body
        //  HashMap<String,Object>actualDataMap = JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class); ---> object mapper


        HashMap<String, Object> actualDataMap = JavaToJson.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

  /*
        ASSERTION HOMEWORK


         */


        for (String key : actualDataMap.keySet()) {

            Assert.assertEquals(expectedDataMap.get(key), actualDataMap.get(key));
        }

        for (Object value : actualDataMap.values()){
            Assert.assertEquals(expectedDataMap.get(value),actualDataMap.get(value));
        }


        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
        HashMap<String,Object>expectedDataMap1=jsonPlaceHolderTestData.setUpDataJson();

        System.out.println("expectedDataMap1 = " + expectedDataMap1);

        for (String key :expectedDataMap1.keySet()){

            Assert.assertEquals(expectedDataMap1.get(key),actualDataMap.get(key));
        }


    }

}
