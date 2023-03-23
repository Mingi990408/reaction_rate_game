package com.example.reaction_rate_game.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
    Long Id;
    String Email;
    String Pw;
    String record;
}
