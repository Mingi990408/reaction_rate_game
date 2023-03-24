package com.example.reaction_rate_game.service;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository ur;
    @Override
    public Member join(String Email,String Pw) {
        Member member = new Member(Email, Pw);
        return ur.save(member);
    }

    @Override
    public Optional<Member> login(String Email, String Pw) {
        Member member = new Member(Email, Pw);
        return ur.findMember(member);
    }

    @Override
    public Member change(Member member, String newpw) {
        return null;
    }

    @Override
    public void delete(Member member) {

    }
}
