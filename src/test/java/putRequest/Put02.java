package putRequest;

import baseURLs.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.Put02herokuPojo;
import pojoDatas.Put02herokuPojoGenel;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends HerokuAppBaseURL {

       /*
        Given
	        1) https://restful-booker.herokuapp.com/booking/37
	        2) {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
        3) Kullanıcı Auth. olarak ilk olarak  Header a Cookie ile daha sonra ise Basic Autoh ile  req bulunmalı.
            Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

            Cookie =>>> token=001832eb39ba0ca
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
     */

    @Test
    public void Put02(){

        //Set URL
        specification.pathParams("bookingpath","booking","idpath","37");

        //SET EXPECTED AND REQUEST BODy

        Put02herokuPojo put02herokuPojo=new Put02herokuPojo("2022-01-01","2023-01-01");

        Put02herokuPojoGenel put02herokuPojoGenel=new Put02herokuPojoGenel("Drake","F..",4000,true,put02herokuPojo,"API and Appium");


        //SET RESPONSE
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Cookie","token:"+ "84e4c34a78ccdb6").
                body(put02herokuPojoGenel).
                when().
                put("/{bookingpath}/{idpath}");


        JsonPath jsonPath=response.jsonPath();
        assertEquals(jsonPath.getString("firstname"),put02herokuPojoGenel.getFirstname());
        assertEquals(jsonPath.getString("lastname"),put02herokuPojoGenel.getLastname());
        assertEquals(jsonPath.getString("totalprice"),put02herokuPojoGenel.getTotalprice());
        assertEquals(jsonPath.getString("depositpaid"),put02herokuPojoGenel.isDepositpaid());
        assertEquals(jsonPath.getString("bookingdates.checkin"),put02herokuPojoGenel.getBookingdates().getCheckin());
        assertEquals(jsonPath.getString("bookingdates.checkout"),put02herokuPojoGenel.getBookingdates().getCheckout());




    }
}
