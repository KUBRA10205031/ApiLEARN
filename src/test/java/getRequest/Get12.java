package getRequest;

import baseURLs.GorestTodosBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GorestCoInPojo;
import utilities.JavaToJson;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends GorestTodosBaseURL {

     /*


        Given
            https://gorest.co.in/public/v2/users/702440
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

    {
    "id": 702440,
    "name": "Adheesh Chopra",
    "email": "adheesh_chopra@schamberger-langosh.biz",
    "gender": "male",
    "status": "active"
}



     */

    @Test
    public void get12(){

        //Step 1 :set URL

        // https://gorest.co.in/public/v2/users/702440

        specification.pathParams("usersPath","users","idPath","702440");

        //Step 2 :Expected Data

        String expectedData = "{\n"+
                "    \"id\": 702440,\n" +
                "    \"name\": \"Adheesh Chopra\",\n" +
                "    \"email\": \"adheesh_chopra@schamberger-langosh.biz\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Object Mapper  --> kullanabilmek için maven projelerinde pom.xml  object mapper ile yapılıydı.
        //              ---> depency eklemem gerekiyor. --> maven repo

        // json objelerine java objesine çevirmek.
        System.out.println("Expected Data :"+ expectedData);


        GorestCoInPojo goRestCoApiPojo = JavaToJson.convertJsonToJavaObject(expectedData, GorestCoInPojo.class);
        System.out.println("goRestCoApiPojo: " + goRestCoApiPojo);


        HashMap<String,Object> expectedDataMap = JavaToJson.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap: " + expectedDataMap );




        //Step 3 : Send Request

        Response response = given().spec(specification).when().get("/{usersPath}/{idPath");
        System.out.println("Response :"+ response);
        response.prettyPrint();


        // Step 4 : Assertion
        HashMap<String,Object> actualdataMap = JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("Actual Data :"+actualdataMap);

        assertEquals(expectedDataMap.get("gender"),actualdataMap.get("gender"));
        assertEquals(expectedDataMap.get("name"),actualdataMap.get("name"));
        assertEquals(expectedDataMap.get("id"),actualdataMap.get("id"));
        assertEquals(expectedDataMap.get("email"),actualdataMap.get("email"));
        assertEquals(expectedDataMap.get("status"),actualdataMap.get("status"));












    }
}
