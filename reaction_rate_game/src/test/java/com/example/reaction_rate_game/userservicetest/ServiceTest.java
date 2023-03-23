package com.example.reaction_rate_game.userservicetest;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    private UserRepository userRepository;



    @Test
    public void Test(){
        Member member = new Member();
        member.setEmail("alsrl4769@naver.com");
        member.setPw("memberPw");
        System.out.println("member = " + userRepository.findMember(member));
    }
}
