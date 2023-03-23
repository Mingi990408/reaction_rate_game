package com.example.reaction_rate_game.service;

import com.example.reaction_rate_game.domain.Member;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    @Override
    public Member join(Member member) {
        return null;
    }

    @Override
    public Optional<Member> login(Member member) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> change(Member member, String newpw) {
        return Optional.empty();
    }

    @Override
    public void delete(Member member) {

    }
}
