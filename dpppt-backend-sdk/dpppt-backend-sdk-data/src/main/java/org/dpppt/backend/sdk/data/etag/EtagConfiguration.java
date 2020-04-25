package org.dpppt.backend.sdk.data.etag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
@ComponentScan(basePackages = {"org.dpppt.backend.sdk.data.etag"})
public
class EtagConfiguration {

    @Bean("sha-256-digest")
    public MessageDigest sha256Digest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("sha-256");
    }
}
