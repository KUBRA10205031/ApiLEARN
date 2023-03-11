package getRequest;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class Get02 {

      /*
    Given
        https://restful-booker.herokuapp.com/booking/78100
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "404" olduğunu Assert et
    And
        Response Body nin "Not Found" olduğunu assert et
    And
        Via nın "1.1 vegur" olduğunu assert et.
    And
        Response body nin "Clarusway" yazmadığını assert et
    And
        Status Line "HTTP/1.1 404 Not Found" olduğunu assert et.

     */
@Test

public void get02(){


/* 4 adımdan oluşuyordu:
  1. Set url
  2. set expected data (step 2 ignore edildi şuan)
  3.Send Request
  4.Assertion
    */

    //Assertion işlemlerini yaparken temelde iki farklı metot kullanıyoruz
    //a.Hard Assertion
    //b.Soft Assertion


//Step 1 :
    String URL = "https://restful-booker.herokuapp.com/booking/78100";

//step 3:
    Response response =given().
            when().
            get(URL);
        System.out.println("RESPONSE: ");
        response.prettyPrint();

     //Step 4 : Assertions operations

    // Test2: Status Line: exp: HTTP/1.1 404 Not Found

    // response.then().assertThat().statusLine("HTTP/1.1 404 Not Found");
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");


    // Test 3: Response Body ---- >> Not Found
    // Response body nasıl string bir ifadeye çevrilir?

        String responseBodyStr=response.asString();

        System.out.println("response Body:"+responseBodyStr);

        assertTrue(responseBodyStr.contains("Not Found"));  //Eğer assertTrue() nun içerisi True return oluyorsa testiniz pass olur



        //Test 4 : Headers dan via nın 1.1 vegur
          response.then().assertThat().headers("Via",equalTo("1.1 vegur"));

        //System.out.println("Butun Headers: " + response.getHeaders()); // Bütün headersları alabiliyoruz.

       // Tek bir tane headera ulaşabilmek için ise;

       //System.out.println("Single Header: " + response.getHeader("Via"));




    // Test 5: Response body nin "Clarusway" yazmadığını assert et

        assertEquals("1.1 vegur",response.getHeader("Via")); //assertEquals()  ---> içine girilen değerler biribiri ile eşit ise TRUE döner ve böylece Testimiz PASS olmuş olur


        assertFalse(responseBodyStr.contains("Clarusway"));  //assertFalse() içine girmiş olduğum veri FALSE return oluyorsa benim testimiz PASS olur



}
}
