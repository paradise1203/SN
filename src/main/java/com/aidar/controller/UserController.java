package com.aidar.controller;

import com.aidar.model.Message;
import com.aidar.model.Post;
import com.aidar.model.User;
import com.aidar.service.*;
import com.aidar.util.FriendsWithLastMessage;
import com.aidar.util.Parser;
import com.aidar.util.ToFriendsWithLastMessageTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ToFriendsWithLastMessageTransformer transformer;

    @RequestMapping("main")
    public String getMainPage(HttpServletRequest request, HttpServletResponse response) {
        return "main";
    }

    @RequestMapping("home")
    public
    @ResponseBody
    ModelAndView getHomePage(HttpServletRequest request, Model model) {
        User user = userService.getUser(authService.getUserId(request));
        model.addAttribute("user", user);
        List<Post> posts = postService.getPosts(user);
        model.addAttribute("posts", posts);
        return new ModelAndView("home");
    }

    @RequestMapping("info/change")
    public
    @ResponseBody
    ModelAndView showChangeInfoPage(HttpServletRequest request, Model model) {
        model.addAttribute("user", userService.getUser(authService.getUserId(request)));
        return new ModelAndView("change_info");
    }

    @RequestMapping(value = "info/change", method = RequestMethod.POST)
    public
    @ResponseBody
    void changeUserInfo(HttpServletRequest request) {
        userService.updateUser(authService.getUserId(request), request.getParameter("fName"), request.getParameter("lName"),
                Integer.parseInt(request.getParameter("sex")), request.getParameter("city"), request.getParameter("mobile"));
    }

    @RequestMapping(value = "posts/send", method = RequestMethod.POST)
    public
    @ResponseBody
    ModelAndView sendPost(HttpServletRequest request, @RequestParam("post") String post, Model model) {
        model.addAttribute("post", postService.addPost(userService.getUser(authService.getUserId(request)), post));
        return new ModelAndView("post");
    }

    @RequestMapping(value = "posts/remove", method = RequestMethod.POST)
    public
    @ResponseBody
    void removePost(@RequestParam("postId") String postId) {
        postService.removePost(postId);
    }

    @RequestMapping(value = "posts/comments/add", method = RequestMethod.POST)
    public
    @ResponseBody
    String addComment(HttpServletRequest request, @RequestParam("postId") String postId, @RequestParam("text") String text, Model model) {
        User user = userService.getUser(authService.getUserId(request));
        Post post = postService.getPost(Long.parseLong(Parser.parseId(postId)));
        postService.addComment(user, text, post);
        return "<li>" + text + "</li>";
    }

    @RequestMapping(value = "posts/likes/add", method = RequestMethod.POST)
    public
    @ResponseBody
    String addLike(HttpServletRequest request, @RequestParam("postId") String postId) {
        return postService.toggleLike(userService.getUser(authService.getUserId(request)),
                postService.getPost(Long.parseLong(Parser.parseId(postId)))).toString();
    }

    @RequestMapping("friends")
    public
    @ResponseBody
    ModelAndView showFriends(HttpServletRequest request, Model model) {
        User user = userService.getUser(authService.getUserId(request));
        List<User>[] lists = friendshipService.getFriends(user);
        List<User> users = lists[1];
        List<FriendsWithLastMessage> friends = transformer.
                transform(userService.getUser(authService.getUserId(request)), lists[0]);
        model.addAttribute("friends", friends);
        model.addAttribute("hasFriends", !friends.isEmpty());
        model.addAttribute("users", users);
        model.addAttribute("hasUsers", !users.isEmpty());
        return new ModelAndView("friends");
    }

    @RequestMapping("users")
    public
    @ResponseBody
    ModelAndView showOtherUsers(HttpServletRequest request, ModelMap model) {
        User user = userService.getUser(authService.getUserId(request));
        List<User> users = userService.getUsers(user, friendshipService.getFriends(user));
        model.addAttribute("users", users);
        model.addAttribute("hasUsers", !users.isEmpty());
        return new ModelAndView("other_users");
    }

    @RequestMapping(value = "friends/add", method = RequestMethod.POST)
    public
    @ResponseBody
    void makeFriends(HttpServletRequest request, @RequestParam("recipient") String recipientId) {
        friendshipService.addFriendship(userService.getUser(authService.getUserId(request)),
                userService.getUser(Long.parseLong(Parser.parseId(recipientId))));
    }

    @RequestMapping(value = "friends/approve", method = RequestMethod.POST)
    public
    @ResponseBody
    void approveFriends(HttpServletRequest request, @RequestParam("recipient") String recipientId) {
        friendshipService.approveFriendship(userService.getUser(authService.getUserId(request)),
                userService.getUser(Long.parseLong(Parser.parseId(recipientId))));
    }

    @RequestMapping(value = "friends/remove", method = RequestMethod.POST)
    public
    @ResponseBody
    void removeFriends(HttpServletRequest request, @RequestParam("recipient") String recipientId) {
        friendshipService.removeFriendship(userService.getUser(authService.getUserId(request)),
                userService.getUser(Long.parseLong(Parser.parseId(recipientId))));
    }

    @RequestMapping("friends/dialog")
    public
    @ResponseBody
    ModelAndView showDialog(HttpServletRequest request, @RequestParam("recipient") String recipientId, ModelMap model) {
        User user2 = userService.getUser(Long.parseLong(Parser.parseId(recipientId)));
        List<Message> messages = messageService.getMessages(userService.getUser(authService.getUserId(request)), user2);
        model.addAttribute("messages", messages);
        model.addAttribute("hasMessages", !messages.isEmpty());
        model.addAttribute("recipient", user2);
        return new ModelAndView("dialog");
    }

    @RequestMapping(value = "friends/dialog/send", method = RequestMethod.POST)
    public
    @ResponseBody
    String sendMessage(HttpServletRequest request, @RequestParam("recipient") String recipientId,
                       @RequestParam("message") String message, ModelMap model) {
        messageService.addMessage(userService.getUser(authService.getUserId(request)),
                userService.getUser(Long.parseLong(Parser.parseId(recipientId))), message);
        return "<li>" + "You at " + new Date() + " : " + message + "</li>";
    }

    @RequestMapping("friends/dialog/get")
    public
    @ResponseBody
    String getNewMessages(HttpServletRequest request, @RequestParam("recipient") String recipientId, ModelMap model) {
        User user1 = userService.getUser(authService.getUserId(request));
        User user2 = userService.getUser(Long.parseLong(Parser.parseId(recipientId)));
        List<Message> messages = messageService.getNewMessages(user1, user2);
        String res = "";
        for (Message m : messages) {
            res += "<li>" + m.getUser1().getFirstName() + " at " + m.getDate() + " : " + m.getText() + "</li>";
        }
        return res;
    }

}
