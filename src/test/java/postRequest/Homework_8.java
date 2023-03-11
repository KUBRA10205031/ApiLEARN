package postRequest;

import baseURLs.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GorestCoInPojo;
import pojoDatas.HerokuGenelPojo;
import pojoDatas.HerokuikiPojo;
import pojoDatas.HerokuilkPojo;
import utilities.JavaToJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Homework_8 extends HerokuAppBaseURL {

     /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }
                 "additionalneeds": "Full Stack Test Automation Course with API and Appium"
             }
        When
 		    Kullanıcı POST metodu ile request göderir
 	    Then
              Status Code un 200 olduğu doğrulanır
 		And
 		      Response Body nin aşağıdaki gibi olduğu verify edilir
 		    {
    "bookingid": 3844,
    "booking": {
        "firstname": "Drake",
        "lastname": "F.",
        "totalprice": 4000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-09-05",
            "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
}
     */




    @Test
    public void homework8(){
        //Set URL
        specification.pathParam("bookingid","booking");

        //Step 2 :Set Request Body -->> dökümandan aldım
   /* Kullanılacak Request Body:
     {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }
                 "additionalneeds": "Full Stack Test Automation Course with API and Appium"
             }
    */

        HerokuilkPojo herokuilkPojo =new HerokuilkPojo("2022-09-05","2023-06-01");
        HerokuikiPojo reqBody=new HerokuikiPojo("Drake","F.",4000,true,herokuilkPojo,"Full Stack Test Automation Course with API and Appium");
        HerokuGenelPojo expectedBody = new HerokuGenelPojo(13777,reqBody,herokuilkPojo,"Full Stack Test Automation Course with API and Appium");

        //Map<String,Object> expectedData



        //Step 3 : Send A REquest

        Response response =given().
                contentType(ContentType.JSON).
                when().
                spec(specification).
                body(reqBody).
                post("/{bookingid}");

        RESPONSE :
        System.out.println("RESPONSE :");
        response.prettyPrint();


        //Step 4 :ASEERTİON

        //Map<String,Object> actualData= JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class);


        HerokuGenelPojo actualData= response.as(HerokuGenelPojo.class);

        response.then().assertThat().statusCode(200);
        Assert.assertEquals(expectedBody.getBooking().getLastname(), actualData.getBooking().getLastname());
        Assert.assertEquals(expectedBody.getBooking().getFirstname(), actualData.getBooking().getFirstname());
        Assert.assertEquals(expectedBody.getBooking().getTotalprice(), actualData.getBooking().getTotalprice());
       Assert.assertEquals(expectedBody.getBooking().isDepositpaid(), actualData.getBooking().isDepositpaid());
       Assert.assertEquals(expectedBody.getBooking().getTotalprice(), actualData.getBooking().getTotalprice());
       Assert.assertEquals(expectedBody.getBooking().getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
       Assert.assertEquals(expectedBody.getBooking().getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
      // Assert.assertEquals(expectedBody.getBookingid(),actualData.getBookingid());
        Assert.assertEquals(expectedBody.getAdditionalneeds(),actualData.getAdditionalneeds());












    }
}
