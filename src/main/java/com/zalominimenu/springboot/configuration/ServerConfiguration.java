package com.zalominimenu.springboot.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "server")
public class ServerConfiguration {
    private String host;
    private int port;
    private String environment;
    private String version;
}
