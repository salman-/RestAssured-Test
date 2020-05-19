package Config;

import lombok.Data;

@Data
public class APICredentials {

    String consumer_key     = "consumer_key";
    String consumer_secret  = "consumer_secret";
    String access_token     = "access_token";
    String token_secret     = "token_secret";



}
