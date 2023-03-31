package com.example.reaction_rate_game.repository;

import com.example.reaction_rate_game.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    /**
     * 디비 넣기 전에 값을 map으로 시험
     */
    private static Map<Long, Member> store = new HashMap<>();

    /**
     * 고유 ID 값
     */
    private long Sequence = 0L;

    /**
     * email을 이용하여 회원을 찾는 메소드
     * @param Email 이메일
     * @return 찾은 멤버 값
     */
    @Override
    public Optional<Member> findbyEmail(String Email) {
        for(Member member:store.values()){
            if(member.getEmail().equals(Email)){
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    /**
     * 회원가입 시 값을 저장하는 메소드
     * @param member
     * @return 저장한 멤버의 값
     */
    @Override
    public Member save(Member member) {
        clear();
        member.setId(++Sequence);
        store.put(member.getId(), member);
        return store.get(Sequence);
    }

    /**
     * 로그인 시 해당 값이 맞는 멤버 찾기
     * @param member
     * @return 찾은 멤버
     */
    @Override
    public Optional<Member> findMember(Member member) {
        for(Member m :store.values()){
            if(member.getEmail().equals(m.getEmail())){
                if(member.getPw().equals(m.getPw()))
                    return Optional.of(m);
            }
        }
        return null;
    }

    /**
     * 비밀번호 변경에 사용될 메소드 추후에 작업
     * @param member
     * @param newpw
     * @return
     */
    @Override
    public Optional<Member> changePw(Member member, String newpw) {
        for(Member m :store.values()){
            if(member.getEmail().equals(m.getEmail())){
                m.setPw(newpw);
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }

    /**
     * map을 비우는 메소드
     */
    @Override
    public void clear() {
        store.clear();
    }
}
