package com.aidar.controller;

import com.aidar.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("")
    public String getGuestPage(HttpServletRequest request) {
        if (authService.hasAuthority(request)) {
            return "redirect:/user/main";
        }
        return "guest";
    }

    @RequestMapping("registration")
    public String getRegistrationPage(HttpServletRequest request, ModelMap model) {
        if (authService.hasAuthority(request)) {
            return "redirect:/user/main";
        }
        if (request.getParameter("mes") == null) {
            return "redirect:/login";
        }
        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String processRegistrationPage(HttpServletRequest request) {
        authService.register(request.getParameter("fName"), request.getParameter("lName"), Integer.parseInt(request.getParameter("sex")),
                request.getParameter("city"), request.getParameter("mobile"), request.getParameter("login"), request.getParameter("password"));
        return "redirect:/login";
    }

    @RequestMapping("login")
    public String getLoginPage(HttpServletRequest request, Model model) {
        if (authService.hasAuthority(request)) {
            return "redirect:/user/main";
        }
        String mes = request.getParameter("mes");
        if (mes != null) {
            model.addAttribute("error", mes.equals("login") ? "No such login" : "Password is incorrect");
        }
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginPage(@RequestParam("login") String login, @RequestParam("password") String password,
                                   @RequestParam(value = "remMe", required = false) Boolean remMe, HttpServletRequest request,
                                   HttpServletResponse response) {
        switch (authService.checkCredentials(login, password)) {
            case 0: {
                return "redirect:/login?mes=login";
            }
            case 1: {
                return "redirect:/login?mes=password";
            }
            default: {
                authService.grantAuthority(login, remMe, request, response);
                return "redirect:/user/main";
            }
        }
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        authService.takeAuthority(request, response);
        return "redirect:/";
    }

}
