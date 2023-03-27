package com.example.reaction_rate_game;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitTestData {
    private final UserRepository ur;

    @PostConstruct
    public void setTestData(){
        Member memberA = new Member();
        memberA.setEmail("root@naver.com");
        memberA.setPw("1234");
        memberA.setNickname("nickname");
        ur.save(memberA);
    }
}
