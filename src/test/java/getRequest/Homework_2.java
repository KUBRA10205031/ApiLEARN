package getRequest;

import baseURLs.HerokuAppBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Homework_2 extends HerokuAppBaseURL {


    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/


    @Test
    public void homework_2 (){

        //Kullanıcı GET Methodu ile Request Gönderir
        specification.pathParam("bookingpath","booking").queryParam("firstname","Sarah");
        Response response = given().
                spec(specification).
                when().
                get("/{bookingpath}");

        response.prettyPrint();

        //Kullanıcı GET Methodu ile Request Gönderir
        response.then().assertThat().statusCode(200);

        // Response body de "bookingid" olduğunu verify eder.
       //  String responseBody= response.asString();
       // assertTrue(responseBody.contains("bookingid"));

        //Kullanıcı firstname olarak Sarah i aratır.

        JsonPath jsonPath = response.jsonPath();

        try {
            jsonPath.getInt("[0].bookingid");
            Assert.assertTrue(true);

        }catch (NullPointerException e){

            Assert.fail("Bookingid bulunamadı");

        }
    }


}
