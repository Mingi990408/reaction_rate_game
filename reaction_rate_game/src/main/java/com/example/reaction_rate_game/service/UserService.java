package com.example.reaction_rate_game.service;

import com.example.reaction_rate_game.domain.Member;

import java.util.Optional;

public interface UserService {
    Member join(String Email, String Pw, String Nickname);

    Optional<Member> login(String Email, String Pw);

    Optional<Member> change(Member member, String newpw);

    void delete(Member member);

}
