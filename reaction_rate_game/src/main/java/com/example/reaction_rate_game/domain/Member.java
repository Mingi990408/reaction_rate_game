package com.example.reaction_rate_game.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Member {
    Long Id;
    String Email;
    String Pw;
    String Nickname;
    String record;

    public Member(String email, String pw) {
        Email = email;
        Pw = pw;
    }

    public Member(String email, String pw, String nickname) {
        Email = email;
        Pw = pw;
        Nickname = nickname;
    }
}
