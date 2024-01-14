package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})

public interface WebBrowserConfig extends Config {
    String browserName();
    String browserVersion();
    String browserSize();
    String remoteURL();
    boolean isRemote();
}