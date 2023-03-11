/*package getRequest;

import baseURLs.DummyRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyRestApiTestData;
import testData.DummyRestApiTestDataHomework;
import testData.GoRestApiTestData;
import utilities.JavaToJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Homework_7 extends DummyRestApiBaseURL {

   /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}

   */

   /* @Test
    public void homework07(){
        specification.pathParam("createpath","create");

        String requestBody="{\n" +
                "  \"name\": \"Drake F.\",\n" +
                "  \"salary\": \"40000\",\n" +
                "  \"age\": \"27\"\n" +
                "}";

        DummyRestApiTestDataHomework dummyRestApiTestDataHomework=new DummyRestApiTestDataHomework();

        List<Map<String,Object>>expectedDataMap=dummyRestApiTestDataHomework.bodyExpectedData("success","data","Drake F.","40000","27",4545);



        System.out.println("dummyRestApiTestData = " + dummyRestApiTestDataHomework);

           HashMap<String,String>requestBodyMap=JavaToJson.convertJsonToJavaObject(requestBody,HashMap.class);


        Response response = given().
                when().
                spec(specification).
                contentType(ContentType.JSON).
                body(requestBody).
                post("/{createpath}");

        response.prettyPrint();

        HashMap<String ,String>actualBodyMap= JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("actualBodyMap = " + actualBodyMap);

        Assert.assertEquals(expectedDataMap.get(0).get("data"),actualBodyMap.get("data"));*/









