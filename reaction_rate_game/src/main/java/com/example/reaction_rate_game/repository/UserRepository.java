package com.example.reaction_rate_game.repository;

import com.example.reaction_rate_game.domain.Member;

import java.util.Optional;

public interface UserRepository{
    Member findbyid(String id);

    Member save(Member member);

    Member findMember(Member member);

    Optional<Member> changePw(Member member, String newpw);
}
