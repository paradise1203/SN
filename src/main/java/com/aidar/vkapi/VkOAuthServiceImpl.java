package com.aidar.vkapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VkOAuthServiceImpl implements VkOAuthService {

    @Autowired
    private UrlCollection urls;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserInf processUser(String code) {
        Token token = restTemplate.getForObject(urls.getTokenUrl() + "code=" + code, Token.class);
        UserInfResponse userInfResponse = restTemplate.getForObject(urls.getUserInfUrl()
                + "access_token=" + token.getAccessToken(), UserInfResponse.class);
        return userInfResponse.getUserInfList().get(0);
    }

}
