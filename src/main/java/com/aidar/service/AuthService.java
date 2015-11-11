package com.aidar.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    public void register(String fName, String lName, Integer sex, String city, String mobile, String login, String password);

    public Integer checkCredentials(String login, String password);

    public void grantAuthority(String login, Boolean remMe, HttpServletRequest request,
                               HttpServletResponse response);

    public void takeAuthority(HttpServletRequest request, HttpServletResponse response);

    public boolean hasAuthority(HttpServletRequest request);

    public Long getUserId(HttpServletRequest request);

}
