
import Config.APICredentials;
import Config.TestConfig;
import Config.TwitterEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class TwitterAPITest extends TestConfig {

    @Test
    public void searchUsers(){

        given()
                .pathParam("accountName","Twitter")
                .pathParam("isVerified","True")
                .pathParam("lang","en")
                .pathParam("count","1")

        .when()
                .get(TwitterEndpoints.SearchUsers)
        .then();

    }


    @Test
    public void getUserInfo(){                 // Get response

        Response response =
                given()
                        .pathParam("screen_name","BlackBeardTier1")
                .when()
                      .get(TwitterEndpoints.GetUserInfo)
                .then()
                      .header("Status",equalTo("200 OK"))
                      .body("screen_name",equalTo("BlackBeardTier1"))
                      .body("verified",equalTo(false))
                      .contentType(ContentType.JSON).extract().response();

        String jsonResponse = response.getBody().asString();
        System.out.println("--------------------- Response Body ---------------------------");
        System.out.println(jsonResponse);

        String headerResponse = response.getHeaders().toString();
        System.out.println("------------------------ Header ------------------------");
        System.out.println(headerResponse);

    }

}
