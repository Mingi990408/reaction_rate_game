package com.example.reaction_rate_game.service;

import com.example.reaction_rate_game.domain.MailDto;
import com.example.reaction_rate_game.domain.Member;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService {
    private JavaMailSender sender;

    public boolean sendSimpleMessage(Member member) throws Exception {
        boolean msg = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(member.getEmail());            // 받는 주소
        helper.setSubject("반응속도 게임" + member.getNickname() + "님의 기록입니다.");         // 제목
        helper.setText("기록 : " + member.getRecord());          // 내용
        try {
            sender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return msg;
        }
        return msg = true;
    }
}
