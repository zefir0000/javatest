package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class CVConfig {

    private static final Config config = ConfigFactory.load("CVConfig.conf");
    private static final String environment = config.getString("environment");
    private static final Config env = config.getConfig("environments").getConfig(environment);


    public static class Api {
        public static final String apiUrl = env.getString("api.url");
    }
}
