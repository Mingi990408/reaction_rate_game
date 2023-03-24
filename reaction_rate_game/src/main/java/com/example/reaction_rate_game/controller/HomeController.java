package com.example.reaction_rate_game.controller;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService us;
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
    @GetMapping("/user/signup")
    public String signup(){
        return "signup";
    }
    @PostMapping("/login/callback")
    public String logincallback(String Email, String Password){
        System.out.println("Email = " + Email);
        System.out.println("Password = " + Password);
        Optional<Member> login = us.login(Email, Password);
        System.out.println("login.get().toString() = " + login.get().toString());
        return "redirect:http://localhost:8080";
    }

    @PostMapping("/user/signup/callback")
    public String signupcallback(String Email, String Password){
        System.out.println("Email = " + Email);
        System.out.println("Password = " + Password);
        Member join = us.join(Email, Password);
        System.out.println("join.toString() = " + join.toString());
        return "redirect:http://localhost:8080";
    }

}
