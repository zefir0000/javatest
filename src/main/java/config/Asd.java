package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Asd {

    private static final Config config = ConfigFactory.load("asd.conf");
    private static final String environment = config.getString("environment");
    private static final Config env = config.getConfig("environments").getConfig(environment);

    public static class Api {
        public static final String apiUrl = env.getString("api.url");
        public static final String xUserIdentityType = env.getString("x_user_identity_type");
        public static final String xUserIdentityName = env.getString("x_user_identity_name");
    }
}