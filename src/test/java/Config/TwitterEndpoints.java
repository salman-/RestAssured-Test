package Config;

public interface TwitterEndpoints {

    String GetUserInfo    = "users/show.json?screen_name={screen_name}";
    String SearchUsers = "users/search.json?q={accountName}&verified={isVerified}&status.lang={lang}&count={count}";
}
