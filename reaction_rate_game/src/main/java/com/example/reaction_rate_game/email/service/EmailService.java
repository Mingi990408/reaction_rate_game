package com.example.reaction_rate_game.email.service;

import com.example.reaction_rate_game.email.dto.MailDto;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService {
    private JavaMailSender sender;

    /**
     *
     * @param mailDto
     * @throws MessagingException
     */

    public boolean sendSimpleMessage(MailDto mailDto) throws Exception {
        boolean msg = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("softwareemailtest18@gmail.com");       // 보내는 주소
        helper.setTo(mailDto.getAddress());            // 받는 주소
        helper.setSubject(mailDto.getTitle());         // 제목
        helper.setText(mailDto.getContent());          // 내용
        try {
            sender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return msg;
        }
        return msg = true;
    }
}
