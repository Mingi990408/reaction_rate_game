package com.example.reaction_rate_game.service;

import com.example.reaction_rate_game.domain.Member;

import java.util.Optional;

public interface UserService {
    Member join(String Email, String Pw, String Nickname);   // 저장

    Optional<Member> login(String Email, String Pw);    // 로그인

    Optional<Member> change(Member member, String newpw);   // 비번 변경

    void inputrecord(Member member, String record);     // 기록 저장

    void delete(Member member);         // 삭제

}
