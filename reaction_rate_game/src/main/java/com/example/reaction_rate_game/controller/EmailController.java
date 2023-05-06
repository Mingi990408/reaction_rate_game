package com.example.reaction_rate_game.controller;

import com.example.reaction_rate_game.domain.MailDto;
import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;


    @PostMapping("/mail/send")
    public String sendMail(HttpSession session) throws Exception {
        Member login = (Member) session.getAttribute("login");
        emailService.sendSimpleMessage(login);
        System.out.println("발송");
        return "redirect:/profile";
    }
}
