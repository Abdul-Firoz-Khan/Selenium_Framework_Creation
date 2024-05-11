package com.afk.config;
import org.aeonbits.owner.Config;

@Config.Sources(value="file:C:/Users/lenovo/Documents/E/Testing/selenium-project/maven_project/MavenTest/src/test/resources/config/config.properties")

public interface FrameworkConfig extends Config {
    long timeout();
    String url();
    String username();
    String password();
    String browser();
    String expectedtitle();
}
