package com.aidar.vkapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlCollection {

    @Value("${AuthorizeUrl}")
    private String authorizeUrl;

    @Value("${TokenUrl}")
    private String TokenUrl;

    @Value("${UserInfUrl}")
    private String UserInfUrl;

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public String getTokenUrl() {
        return TokenUrl;
    }

    public String getUserInfUrl() {
        return UserInfUrl;
    }

}
