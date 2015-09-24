package com.aidar;

import com.aidar.data.Message;
import com.aidar.data.User;
import com.aidar.vkapi.UrlCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UrlCollection urls;

    @Autowired
    DAO dao;

    private String getCookie(Cookie[] mas) {
        if (mas == null)
            return "fail";
        Cookie cookie = null;
        for (Cookie c : mas)
            if (c.getName().equals("authId"))
                return c.getValue();
        return "fail";
    }

    private String parse(String s) {
        String res = "";
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if ('0' <= c && c <= '9')
                res += Character.toString(c);
        }
        return res;
    }

    @RequestMapping("/oAuth")
    public String oAuth(HttpServletRequest request, ModelMap model) {
        Cookie[] cookies = request.getCookies();
        String userId = getCookie(cookies);
        if (!userId.equals("fail"))
            return "redirect:/" + userId;
        else {
            model.addAttribute("url", urls.getAuthorizeUrl());
            return "oAuth_page";
        }
    }

    @RequestMapping("/recognizeUser")
    public String recognizeUser(@RequestParam("code") String code, HttpServletResponse response, ModelMap model) {
        Integer userId = dao.addUserAndGetId(code);
        response.addCookie(new Cookie("authId", userId.toString()));
        model.addAttribute("userUrl", "/" + userId);
        return "cookie_page";
    }

    @RequestMapping("/{id}")
    public String showUserHomePage(@PathVariable Integer id, HttpServletRequest request, ModelMap model) {
        if (getCookie(request.getCookies()).equals(id.toString())) {
            List<User> friends = dao.getFriends(id);
            List<User> users = dao.getOtherUsers(id, friends);
            model.addAttribute("user", dao.getCurrentUser(id));
            model.addAttribute("friends", friends);
            model.addAttribute("hasFriends", !friends.isEmpty());
            model.addAttribute("users", users);
            model.addAttribute("hasUsers", !users.isEmpty());
            return "user_page";
        } else
            return "redirect:/oAuth";
    }

    @RequestMapping(value = "/makeFriends", method = RequestMethod.POST)
    public String makeFriends(@RequestParam("sender") String senderId, @RequestParam("recipient") String recipientId,
                              HttpServletRequest request) {
        Integer sId = Integer.parseInt(parse(senderId));
        if (getCookie(request.getCookies()).equals(sId.toString())) {
            Integer rId = Integer.parseInt(parse(recipientId));
            dao.makeFriends(sId, rId);
            return "redirect:/" + sId;
        } else
            return "redirect:/oAuth";
    }

    @RequestMapping(value = "/removeFriends", method = RequestMethod.POST)
    public String removeFriends(@RequestParam("sender") String senderId, @RequestParam("recipient") String recipientId,
                                HttpServletRequest request) {
        Integer sId = Integer.parseInt(parse(senderId));
        if (getCookie(request.getCookies()).equals(sId.toString())) {
            Integer rId = Integer.parseInt(parse(recipientId));
            dao.removeFriends(sId, rId);
            return "redirect:/" + sId;
        } else
            return "redirect:/oAuth";
    }

    @RequestMapping("/dialog")
    public String showDialog(@RequestParam("sender") String senderId, @RequestParam("recipient") String recipientId,
                             HttpServletRequest request, ModelMap model) {
        Integer sId = Integer.parseInt(parse(senderId));
        if (getCookie(request.getCookies()).equals(sId.toString())) {
            Integer rId = Integer.parseInt(parse(recipientId));
            List<Message> messages = dao.getDialog(sId, rId);
            model.addAttribute("messages", messages);
            model.addAttribute("hasMessages", !messages.isEmpty());
            model.addAttribute("sender", dao.getCurrentUser(sId));
            model.addAttribute("recipient", dao.getCurrentUser(rId));
            return "dialog_page";
        } else
            return "redirect:/oAuth";
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public
    @ResponseBody
    String sendMessage(@RequestParam("sender") String senderId, @RequestParam("recipient") String recipientId,
                       @RequestParam("message") String message, ModelMap model) {
        Integer sId = Integer.parseInt(parse(senderId));
        Integer rId = Integer.parseInt(parse(recipientId));
        dao.sendMessage(sId, rId, message);
        return "<li>" + "You at " + new Date() + " : " + message + "</li>";
    }

    @RequestMapping("/getMessage")
    public
    @ResponseBody
    String getNewMessages(@RequestParam("sender") String senderId, @RequestParam("recipient") String recipientId,
                          ModelMap model) {
        Integer sId = Integer.parseInt(parse(senderId));
        Integer rId = Integer.parseInt(parse(recipientId));
        List<Message> messages = dao.getNewMessages(sId, rId);
        User recipient = dao.getCurrentUser(rId);
        String res = "";
        Iterator<Message> it = messages.listIterator();
        while (it.hasNext())
            res += "<li>" + recipient.getFirstName() + " at " + new Date() + " : " + it.next().getMessage() + "</li>";
        return res;
    }

}
