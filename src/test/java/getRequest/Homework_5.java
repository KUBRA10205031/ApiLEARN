package getRequest;

import baseURLs.GorestTodosBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GorestCoInPojo;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class Homework_5 extends GorestTodosBaseURL {

 /*
        Given
            https://gorest.co.in/public/v2/users/697102
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular


{
    "id": 713683,
    "name": "Chandni Sinha",
    "email": "chandni_sinha@ohara-sporer.name",
    "gender": "male",
    "status": "active"
}

*/


@Test
    public void Homework_5(){

    //Step 1 : Get URL

    specification.pathParams("userspath","users","idpath","713683");

    //Step 2 :Expected Data


    GorestCoInPojo expectedData =new GorestCoInPojo(713683,"Chandni Sinha","chandni_sinha@ohara-sporer.name","male","active");

    System.out.println("Expected Data : " + expectedData);
    //Steep 3 : Send Request

    Response response =given().
            spec(specification).
            when().
            get("/{userspath}/{idpath}");
    response.prettyPrint();


    //Step 4 : Assertion

    Map<String,Object> actualData = response.as(HashMap.class);

    System.out.println("actual data:" + actualData);

    Assert.assertEquals(expectedData.getId(),actualData.get("id"));
    Assert.assertEquals(expectedData.getName(),actualData.get("name"));
    Assert.assertEquals(expectedData.getEmail(),actualData.get("email"));
    Assert.assertEquals(expectedData.getStatus(),actualData.get("status"));
    Assert.assertEquals(expectedData.getGender(),actualData.get("gender"));



}


}


