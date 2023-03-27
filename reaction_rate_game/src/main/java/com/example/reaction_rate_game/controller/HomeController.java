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

    /**
     * 기본 페이지
     *
     * @return home.html 반환
     */
    @GetMapping("/")
    public String home() {
        return "home.html";
    }

    /**
     * home에서 game 페이지로 넘어감
     *
     * @return game.html
     */
    @GetMapping("/game")
    public String game() {
        return "game.html";
    }

    /**
     * login 버튼 누르면 로그인 페이지로 넘어감
     *
     * @return login.html
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * sign up 버튼 누르면 회원가입 페이지로 넘어감
     *
     * @return signup.html
     */
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    /**
     * 로그인 페이지에서 값이 들어오면 받음
     *
     * @param Email    이메일
     * @param Password 비밀번호
     * @return home.html
     */
    @PostMapping("/login/callback")
    public String logincallback(String Email, String Password) {
        Optional<Member> login = us.login(Email, Password);
        return "redirect:http://localhost:8080";
    }

    /**
     * 회원가입 페이지에서 값이 들어오면 받음
     *
     * @param Email    이메일
     * @param Password 비밀번호
     * @return home.html
     */
    @PostMapping("/user/signup/callback")
    public String signupcallback(String Email, String Password) {
        Member join = us.join(Email, Password);
        return "redirect:http://localhost:8080";
    }

    @PostMapping("/game/record")
    public void gamerecord(String record){
        System.out.println("record = " + record);
    }
}
