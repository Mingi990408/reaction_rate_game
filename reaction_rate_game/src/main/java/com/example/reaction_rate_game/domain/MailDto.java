package com.example.reaction_rate_game.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailDto {
    private String address;
    private String title;
    private String content;

}
