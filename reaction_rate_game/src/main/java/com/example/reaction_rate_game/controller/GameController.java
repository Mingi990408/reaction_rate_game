package com.example.reaction_rate_game.controller;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class GameController {
    private final UserService us;
    /**
     * home에서 game 페이지로 넘어감
     *
     * @return game.html
     */
    @GetMapping("/game")
    public String game(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("login");
        model.addAttribute("member", member);
        return "game";
    }

    /**
     * 기록을 저장하기 위함
     * @param session 로그인 한 상태의 유저 정보를 받는다.
     * @param record 기록을 받아옴
     */
    @PostMapping("/game/record")
    public void gamerecord(HttpSession session, String record){
        Member login = (Member) session.getAttribute("login");
        us.inputrecord(login,record);
    }
}
