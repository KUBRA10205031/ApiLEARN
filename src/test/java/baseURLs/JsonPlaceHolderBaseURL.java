package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class JsonPlaceHolderBaseURL {

    protected RequestSpecification specification;
    //https://jsonplaceholder.typicode.com---> base URL
    // /todos/2

    @Before
    public void setUpBaseURL(){
        specification = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").
                build();

    }
}
