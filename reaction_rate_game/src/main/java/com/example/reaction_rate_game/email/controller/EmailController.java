package com.example.reaction_rate_game.email.controller;

import com.example.reaction_rate_game.email.dto.MailDto;
import com.example.reaction_rate_game.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@Controller
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping("/mail/send")
    public String mail(){
        return "SendMail";
    }

    @PostMapping("/mail/send")
    public String sendMail(MailDto mailDto) throws Exception {
        emailService.sendSimpleMessage(mailDto);
        System.out.println("메일 전송 완료");
        return "home";
    }
}
