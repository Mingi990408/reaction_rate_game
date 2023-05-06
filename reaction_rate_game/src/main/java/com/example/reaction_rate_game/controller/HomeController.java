package com.example.reaction_rate_game.controller;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class HomeController {
    /**
     * 기본 페이지
     *
     * @return home.html 반환
     */
    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("login");
        if (member != null){
            model.addAttribute("nickname", member.getNickname());
        }
        return "home";
    }
}
