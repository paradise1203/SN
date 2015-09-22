package com.aidar.vkapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Number expiresIn;

    @JsonProperty("user_id")
    private Number userId;

    public Token() {
    }

    public Token(String accessToken, Number expiresIn, Number userId) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Number getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Number expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Number getUserId() {
        return userId;
    }

    public void setUserId(Number userId) {
        this.userId = userId;
    }

}
