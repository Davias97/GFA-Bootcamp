package com.example.reddit.controller;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.service.PostService;
import com.example.reddit.service.UserService;
import com.example.reddit.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class RedditController {

    @Autowired
    private PostService postService;
    @Autowired
    private VoteService voteService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model m) {
        List<Post> posts = postService.listPost();
        m.addAttribute("posts", posts);
        m.addAttribute("loggeduser", userService.getLoggedUser());
        return "index";
    }

    @GetMapping("/posts/new")
    public String createNewPost(Model m) {
        User optionalUser = userService.findByName("admin");
        if (optionalUser != null) {
            Post post = new Post();
            post.setUser(optionalUser);
            m.addAttribute("post", post);
            return "post_new";
        } else {
            return "404";
        }
    }

    @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model m) {
        Optional<Post> optionalPost = postService.findById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            m.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String sendLogin(String name, String password) {
        if (userService.login(name, password)) {
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model m) {
        User user = new User();
        m.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }
}

