package com.aidar.vkapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfResponse {

    @JsonProperty("response")
    private List<UserInf> userInfList;

    public List<UserInf> getUserInfList() {
        return userInfList;
    }

    public void setUserInfList(List<UserInf> userInfList) {
        this.userInfList = userInfList;
    }

}
