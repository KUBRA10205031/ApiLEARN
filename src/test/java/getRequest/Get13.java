package getRequest;

import baseURLs.GorestTodosBaseURL;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Test;
import pojoDatas.GorestCoInPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Get13 extends GorestTodosBaseURL {
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
"id": 480339,
"name": "Bhupen Deshpande PhD",
"email": "bhupen_phd_deshpande@prosacco.biz",
"gender": "male",
"status": "active"
}



     */
@Test
    public void Get13(){

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

    //pojo --> expected Data ,Rewuest Body , Actual Data

    GorestCoInPojo actualDataPojo = response.as(GorestCoInPojo.class);

   // assertEquals(GorestCoInPojo)




}

}
