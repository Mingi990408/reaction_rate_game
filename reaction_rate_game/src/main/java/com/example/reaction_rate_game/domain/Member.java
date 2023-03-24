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
    String record;

    public Member(String email, String pw) {
        Email = email;
        Pw = pw;
    }
}
