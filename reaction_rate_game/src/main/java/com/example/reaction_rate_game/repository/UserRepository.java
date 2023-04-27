package com.example.reaction_rate_game.repository;

import com.example.reaction_rate_game.domain.Member;

import java.util.Optional;

public interface UserRepository{
    Optional<Member> findbyEmail(String Email); // email을 이용한 member 찾기

    Member save(Member member);                 // 회원가입 시 DB에 저장하기 위한 메소드

    void saverecord(Member member, String record);  // 반응속도 결과를 저장하기 위한 메소드

    Optional<Member> findMember(Member member);     // 로그인 메소드

    Optional<Member> changePw(Member member, String newpw);  // 비밀번호 변경 메소드

    void clear();                                            // 아직 DB 연결 X, 메모리 비우는 메소드
}
