package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})

public interface WebBrowserConfig extends Config {
    @Key("browserName")
    String browserName();
    @Key("browserVersion")
    String browserVersion();
    @Key("browserSize")
    String browserSize();
    @Key("remoteURL")
    String remoteURL();
    @Key("isRemote")
    boolean isRemote();
}