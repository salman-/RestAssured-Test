package Config;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.BeforeClass;

public class TestConfig {


    @BeforeClass
    public static void setup(){

        APICredentials ac = new APICredentials();

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.twitter.com")
                .setBasePath("/1.1/")
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        requestSpecification.auth().oauth(ac.getConsumer_key(),ac.getConsumer_secret(),ac.getAccess_token(),ac.getToken_secret());
        RestAssured.requestSpecification = requestSpecification;

        /*ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
        RestAssured.responseSpecification = responseSpecification; */



    }
}
