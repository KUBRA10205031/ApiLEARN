package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.awt.image.ImageProducer;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseURL {


/*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    title ın "quis ut nam facilis et officia qui" olduğunu verify et.,
		And
		    "completed" ın false olduğunu verify et.
		And
		    "userId" in 1 olduğunu verify et
     */



    @Test

    /*
    1) Set URL
    2) Set Expected data
    3) Send a Request
    4) Assertion
     */

    public void get03(){

       //String URL ="https://jsonplaceholder.typicode.com/todos/2";
        // Step 3: Send Request
        //Response response = given().when().get(URL);

        //        response.then().assertThat().statusCode(200);
        //        response.then().assertThat().contentType("application/json");
        //        response.then().assertThat().body("title",equalTo("quis ut nam facilis et officia qui"));
        //        response.then().assertThat().body("completed",equalTo(false));
        //        response.then().assertThat().body("userId",equalTo(1));


       //Step 1: Set URL : "https://jsonplaceholder.typicode.com/todos/2"
         specification.pathParams("todosPath","todos","idPath","2");

         //Step 2: Expected datalar ı nasıl set leyebilirler:
        //-map
        // -arr /list

         // Step 3 : Send Request
         Response response = given().
                 spec(specification).
                 when().
                 get("/{todosPath}/{idPath}");

         response.prettyPrint();

         //Step 4 : Assertion operations

         //1.WAY
      /*  response.then().assertThat().statusCode(200).contentType("application/json");

        response.
                then().
                assertThat().
                body("title", Matchers.equalTo("quis ut nam facilis et officia qui"),
                        "completed", Matchers.equalTo(false),
                                    "userId",Matchers.equalTo(1));             */


        //2. WAY

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false),
                        "userId",equalTo(1));



    }

}
