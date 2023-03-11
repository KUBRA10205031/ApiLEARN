package postRequest;

import baseURLs.GorestTodosBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GorestCoInPojo;
import pojoDatas.GorestPostPojo;
import testData.GoRestApiTestData;
import utilities.JavaToJson;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Post02 extends GorestTodosBaseURL {

       /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */


    @Test
    public void post02(){
        specification.pathParam("userpath","users");
        //Step 2 :Set Expected

       // GoRestApiTestData goRestApiTestData =new GoRestApiTestData();
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        HashMap<String,String> reqBodyAndExpectedDataMap = goRestApiTestData.reqBodyAndExpectedData("pembgüül","female",
                "pembgül@gmail.com","active");

        System.out.println("reqBodyAndExpectedDataMap: " + reqBodyAndExpectedDataMap);

        GorestPostPojo expectedDataPojo = new GorestPostPojo("pembgüül","pembgül@gmail.com","female","active");

        System.out.println("expectedDataPojo = " + expectedDataPojo);
//Step 3: Send a request

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBodyAndExpectedDataMap).
                when().
                header("Authorization","Bearer e7dbd4fc45a3e5f9ad861d49ff0348b8b33552178f9f96a69edf40106230ee0d").
                post("/{userpath}");

        System.out.println("Response Body :");
        response.prettyPrint();


       //Step 4: Assertion
        //Pojo kullanrak assert ediniz.

      // GorestPostPojo expectedDataPojo = new GorestPostPojo("pembegl","pembegl@gmail.com","female","active");
      //  GorestPostPojo actualDataPojo =response.as(GorestPostPojo.class);
      //  Assert.assertEquals(expectedDataPojo,actualDataPojo);


        HashMap<String,Object> actualdataMap = JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("Actual Data :"+actualdataMap);


        Assert.assertEquals(expectedDataPojo.getEmail(),actualdataMap.get("email"));
       Assert.assertEquals(expectedDataPojo.getGender(),actualdataMap.get("gender"));
       Assert.assertEquals(expectedDataPojo.getName(),actualdataMap.get("name"));
       Assert.assertEquals(expectedDataPojo.getStatus(),actualdataMap.get("status"));








    }
}
