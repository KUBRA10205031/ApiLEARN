package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseURL {


       /*
        Given
            https://jsonplaceholder.typicode.com/users
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    Data uzunluğunun 10 olduğunu assert ediniz.

     */

    @Test
    public void get04(){
        /*
        1) Set URL
        2) Set Expected data
        3) Send a Request
        4) Assertion
         */

        //1) Set URL
       specification.pathParams("userspath","users");
        Response response=given().
                spec(specification).
                get("/{userspath}");

        response.prettyPrint();

        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                body("id", Matchers.hasSize(10));



    }
}
