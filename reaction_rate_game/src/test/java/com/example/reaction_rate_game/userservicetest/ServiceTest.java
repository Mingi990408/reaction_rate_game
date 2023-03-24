package com.example.reaction_rate_game.userservicetest;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.repository.UserRepository;
import com.example.reaction_rate_game.repository.UserRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ServiceTest {
    private UserRepository userRepository = new UserRepositoryImpl();

    @AfterEach
    public void afterEach(){
        userRepository.clear();
    }

    @Test
    public void saveTest(){
        Member member = new Member("root1234@naver.com","1234");
        userRepository.save(member);
    }

    @Test
    public void findTest(){
        saveTest();
        Member member = new Member("root1234@naver.com","1234");
        Member member1 = userRepository.findMember(member).get();
        assertThat(member1).isEqualTo(member);
    }
    @Test
    public void findidTest(){
        saveTest();
        Member member = new Member("root1234@naver.com","1234");
        Member member1 = userRepository.findbyEmail("root1234@naver.com").get();
        assertThat(member1.getEmail()).isEqualTo("root1234@naver.com");
    }
}
