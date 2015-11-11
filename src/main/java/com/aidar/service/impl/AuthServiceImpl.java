package com.aidar.service.impl;

import com.aidar.repository.UserRepository;
import com.aidar.model.User;
import com.aidar.model.enums.Sex;
import com.aidar.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    @Qualifier("userRepository")
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    private String getCookie(Cookie[] cookies) {
        if (cookies == null)
            return null;
        for (Cookie c : cookies) {
            if (c.getName().equals("id"))
                return c.getValue();
        }
        return null;
    }

    private void deleteCookie(Cookie[] cookies, HttpServletResponse response) {
        Cookie cookie = null;
        for (Cookie c : cookies)
            if (c.getName().equals("id"))
                cookie = c;
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    @Override
    public void register(String fName, String lName, Integer sex, String city, String mobile, String login, String password) {
        userRepository.save(new User(login, encoder.encode(password), fName, lName, Sex.getSex(sex), city, mobile));
    }

    @Override
    public Integer checkCredentials(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            return 0;
        }
        if (!encoder.matches(password, user.getPassword())) {
            return 1;
        }
        return 2;
    }

    @Override
    public void grantAuthority(String login, Boolean remMe, HttpServletRequest request, HttpServletResponse response) {
        Long id = userRepository.findByLogin(login).getId();
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        if (remMe != null && remMe) {
            response.addCookie(new Cookie("id", id.toString()));
        }
    }

    @Override
    public void takeAuthority(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("id");
        deleteCookie(request.getCookies(), response);
    }

    @Override
    public boolean hasAuthority(HttpServletRequest request) {
        Long sId = (Long) request.getSession().getAttribute("id");
        String cVal = getCookie(request.getCookies());
        Long cId = cVal != null ? Long.parseLong(cVal) : null;
        boolean hasS = sId != null && userRepository.findOne(sId).getId() == sId;
        boolean hasC = cId != null && userRepository.findOne(cId).getId() == cId;
        return hasS || hasC;
    }

    @Override
    public Long getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        Long id = (Long) session.getAttribute("id");
        if (id == null) {
            id = Long.parseLong(getCookie(cookies));
        }
        return id;
    }

}
