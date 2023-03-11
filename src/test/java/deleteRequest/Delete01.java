package deleteRequest;

import baseURLs.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.JavaToJson;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Delete01 extends HerokuAppBaseURL {

      /*
        Given
            1)https://restful-booker.herokuapp.com/booking/5
            2)Auth olarak HEader da Cookie ile token=001832eb39ba0ca gönderiniz
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */
    @Test
    public void Delete01(){
        specification.pathParams("p1","booking","p2","11");

        //Step 2 :Ecpected AndREquest body
        //Setlememiz gereken bir data olmadığı için ignore edilmiştir.


        //step 3: Send A Request

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                when().
                delete("/{p1}/{p2}");
        response.prettyPrint();

        response.then().assertThat().statusCode(201);
        Assert.assertTrue(response.body().asString().contains("Created"));
        String responseBody=response.asString();
       Assert.assertEquals(responseBody,"created");





    }
}
