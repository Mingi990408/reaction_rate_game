package com.example.reaction_rate_game.repository;

import com.example.reaction_rate_game.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static Map<Long, Member> store = new HashMap<>();

    private long Sequence = 0L;

    @Override
    public Member findbyid(String Email) {
        for(Member member:store.values()){
            if(member.getEmail().equals(Email)){
                return member;
            }
        }
        return null;
    }

    @Override
    public Member save(Member member) {
        member.setId(++Sequence);
        long memberId = member.getId();
        store.put(memberId, member);
        return member;
    }

    @Override
    public Member findMember(Member member) {
        for(Member m :store.values()){
            if(member.getEmail().equals(m.getEmail())){
                if(member.getPw().equals(m.getPw()))
                    return member;
            }
        }
        return null;
    }

    @Override
    public Optional<Member> changePw(Member member, String newpw) {
        return Optional.empty();
    }
}
