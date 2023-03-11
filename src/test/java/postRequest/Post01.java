package postRequest;

import baseURLs.GorestTodosBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends GorestTodosBaseURL {

/*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et

   */

   //ACESS TOKEN : b3583c7e9e8ebffc920439bf1ae57eb7ef62446e400885c630e5e7dc4c8bb263

    @Test
    public void post01(){

        //Set URL
        specification.pathParam("userpath","users");

        //Set Expected Data

        GoRestApiTestData goRestApiTestData=new GoRestApiTestData();
        System.out.println("Expected Test Data  = " + goRestApiTestData.statusCodeForPostInvalid());

        Response response =given().
                spec(specification).
                when().
                header("Authorization","Bearer e7dbd4fc45a3e5f9ad861d49ff0348b8b33552178f9f96a69edf40106230ee0d").
                post("/{userpath}");
        System.out.println("Response : ");
        response.prettyPrint();


        //Step 4 :ASSERTİON
        assertEquals(goRestApiTestData.statusCodeForPostInvalid(),response.getStatusCode());
        response.then().assertThat().statusCode(422);


    }



























}
