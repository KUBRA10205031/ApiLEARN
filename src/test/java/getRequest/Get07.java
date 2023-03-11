package getRequest;

import baseURLs.DummyRestApiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.awt.geom.RectangularShape;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07 extends DummyRestApiBaseURL {
   /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And



     */

    @Test
    public void Get07(){
        specification.pathParam("employeespath","employees");
        Response response=given().
                spec(specification).
                when().
                get("/{employeespath}");
        response.prettyPrint();

        response.then().assertThat().
                statusCode(200);

        JsonPath jsonPath=response.jsonPath();

      /*  List<Integer> employeeAges =jsonPath.getList("data.employee_age");
        System.out.println("employeeAges:"+employeeAges);
        int count=0;
        for (Integer w :employeeAges) {
            if (w<55){
                count++;
            }

        }
        System.out.println("Count:"+count);
        assertEquals(8,count);             */

     // Test 2 : id


     /*   List<Integer> employeeAges =jsonPath.getList("data.employee_age");
        System.out.println("employeeAges:"+employeeAges);
        int count=0;
        for (Integer w :employeeAges) {
            if (w<55){
                count++;
            }

        }
        System.out.println("Count:"+count);
        assertEquals(8,count); */

     //Test 2 :id
        // 7 tane olduğunu assert et

        List<Integer>idS = jsonPath.getList("data.findAll{(it.id)<17}.id");
        System.out.println("idS:"+idS);



        //salary si 100.000'den az olanları konsola yazdırınız.
        //Doris Wilder'ın bunlardan biri olduğunu assert ediniz.

        List<Integer>idS1 = jsonPath.getList("data.findAll{(it.employee_salary)<100000}.employee_name");
        System.out.println("idS1:"+idS1);

        Assert.assertTrue(idS1.contains("Doris Wilder"));









    }



}
