package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ApiZippopotamBaseURL {

 //   http://api.zippopotam.us/TR/34010

    protected RequestSpecification specification;
    @Before
    public void setUoBaseURL (){

        specification =new RequestSpecBuilder().
                setBaseUri("http://api.zippopotam.us").
                build();
    }
}
