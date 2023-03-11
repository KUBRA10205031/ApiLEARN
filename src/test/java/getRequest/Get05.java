package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import baseURLs.TheMovieDBBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;

public class Get05  extends TheMovieDBBaseURL {

    /*
        Given
            https://api.themoviedb.org/3/movie/popular

            api_key = bb17b3b0592cd3101cf0815cbfff43b7 -------> query params
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.

     */

    @Test
    public void get05 (){

          /*
        1) Set URL
        2) Expecta Data   ---> Map, List, Arr
        3) Send REquest
        4) Assertion
         */

        //Step 1: Set URL

        specification.pathParams("moviepath","movie","popularpath","popular").
                queryParam("api_key","bb17b3b0592cd3101cf0815cbfff43b7"); // Key and value dökümandan alınmıştır. bizim kendimize ait olan değerimizdir.

        //Step 2: Set Expected Data (ignored)

        //Step 3 :Send REquest

        Response response = given().
                spec(specification).
                when().
                get("/{moviepath}/{popularpath}");  // get methodunun içerisine çalışacağım endpointeri syntax ine uygun bir şekilde yazmalıyım.

        response.prettyPrint();

        //Step 4: Assertion

      /*  And
        Content Type ın "application/json" olduğunu assert et
        And
        id lerin içerisnde
        646389
        536554
        640146 olduğunu assert ediniz.      */



        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("results.id",Matchers.hasItems(646389,536554, 640146));



















    }

}
