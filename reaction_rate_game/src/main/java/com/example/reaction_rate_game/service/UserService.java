package com.example.reaction_rate_game.service;

import com.example.reaction_rate_game.domain.Member;

import java.util.Optional;

public interface UserService {
    Member join(Member member);

    Member login(Member member);

    Member change(Member member, String newpw);

    void delete(Member member);

}
