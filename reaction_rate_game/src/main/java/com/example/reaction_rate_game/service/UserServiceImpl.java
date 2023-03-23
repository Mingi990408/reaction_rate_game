package com.example.reaction_rate_game.service;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public Member join(Member member) {
        return userRepository.save(member);
    }

    @Override
    public Member login(Member member) {
        return userRepository.findMember(member);
    }

    @Override
    public Member change(Member member, String newpw) {
        return null;
    }

    @Override
    public void delete(Member member) {

    }
}
