package com.example.reaction_rate_game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home.html";
    }
    @GetMapping("/game")
    public String game(){
        return "game.html";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login/callback")
    public String callback(String userID, String userPW){


        return "redirect:http://localhost:8080";
    }
    @PostMapping("/user/signup")
    public String signin(String userID, String userPW){
        return "redirect:http://localhost:8080";
    }

}
