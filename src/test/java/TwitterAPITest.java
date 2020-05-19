
import Config.APICredentials;
import Config.TestConfig;
import Config.TwitterEndpoints;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class TwitterAPITest extends TestConfig {

    @Test
    public void getUserInfo() {
        given()
                .pathParam("screen_name","BlackBeardTier1")
        .when()
                .get(TwitterEndpoints.GetUserInfo)
        .then();
    }

}
