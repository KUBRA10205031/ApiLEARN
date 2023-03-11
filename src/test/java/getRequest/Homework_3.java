package getRequest;

import baseURLs.DummyRestApiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework_3 extends DummyRestApiBaseURL {

    /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}

*/

    @Test
    public void homework3(){

        specification.pathParams("employeemath","employee","idpath","1");

        //Kullanıcı GET Methodu ile Request Gönderir
        Response response= given().
                when().
                spec(specification).
                get("/{employeemath}/{idpath}");

        response.prettyPrint();

        //Status Code un "200" olduğunu Assert et
        response.then().assertThat().statusCode(200);



        //Response body nin bu şekilde olduğunu doğrular

        String expectedData="{\n" +
                "    \"status\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"employee_name\": \"Tiger Nixon\",\n" +
                "        \"employee_salary\": 320800,\n" +
                "        \"employee_age\": 61,\n" +
                "        \"profile_image\": \"\"\n" +
                "    },\n" +
                "    \"message\": \"Successfully! Record has been fetched.\"\n" +
                "}";

        String actualData=response.getBody().asString();

        assertEquals(expectedData,actualData);



    }
}
