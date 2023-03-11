package getRequest;

import baseURLs.ApiZippopotamBaseURL;

import io.restassured.response.Response;

import org.junit.Test;
import pojoDatas.ZippoPotamPlaces;
import pojoDatas.ZippoPotamPojos;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Get11 extends ApiZippopotamBaseURL {

     /*

        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}

     */

@Test
    public void get11() {

    //step 1 : Set URL
    specification.pathParams("countrypath","TR","postcodepath","34010");

    //Step 2 :SEt Expected Data

  /*  {
        "post code": "34010",
            "country": "Turkey",
            "country abbreviation": "TR",
            "places": [
        {
            "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
        }
    ]
    }
     */

    ZippoPotamPlaces zippoPotamPlaces=new ZippoPotamPlaces("Maltepe Mah.","32.3609","İstanbul","34","40.1589");
    ZippoPotamPojos zippoPotamPojos =new ZippoPotamPojos("34010","Turkey","TR",zippoPotamPlaces);
    System.out.println("Expected Data:" + zippoPotamPojos);

    Response response=given().spec(specification).when().get("/{countrypath}/{postcodepath}");

    System.out.println("Response");
    response.prettyPrint();

    //Step 4 :Assertion with Gson


    Map<String,Object>actualDataMap = response.as(HashMap.class);
    System.out.println("Actual Data :"+actualDataMap);

    //get(key)

    assertEquals(zippoPotamPojos.getCountry(),actualDataMap.get("country"));
    assertEquals(zippoPotamPojos.getPostCode(),actualDataMap.get("post code"));
    assertEquals(zippoPotamPojos.getCountryabbreviation(),actualDataMap.get("country abbreviation"));
    assertEquals(zippoPotamPojos.getZippoPotamPlaces().getPlaceName(),(((Map)((List)actualDataMap.get("places")).get(0))).get("place name"));
    assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLatitude(),(((Map)((List)actualDataMap.get("places")).get(0)).get("latitude")));



}

}
