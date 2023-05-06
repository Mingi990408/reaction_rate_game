package com.example.reaction_rate_game.controller;

import com.example.reaction_rate_game.domain.Member;
import com.example.reaction_rate_game.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService us;

    /**
     * sign up 버튼 누르면 회원가입 페이지로 넘어감
     *
     * @return signup.html
     */
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    /**
     * 회원가입 페이지에서 값이 들어오면 받음
     *
     * @param Email    이메일
     * @param Password 비밀번호
     * @return home.html
     */
    @PostMapping("/user/signup/callback")
    public String signupcallback(Model model, String Email, String Password, String Nickname) {
        Member join = us.join(Email, Password, Nickname);
        return "home";
    }

    /**
     * login 버튼 누르면 로그인 페이지로 넘어감
     *
     * @return login.html
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 로그인 페이지에서 값이 들어오면 받음
     *
     * @param Email    이메일
     * @param Password 비밀번호
     * @return home.html
     */

    @PostMapping("/login/callback")
    public String logincallback(Model model, String Email, String Password, HttpSession session) {
        Optional<Member> login = us.login(Email, Password);
        if (login.isPresent()) {
            session.setAttribute("login", login.get());
            return "redirect:/";
        }
        else {
            return "login";
        }

    }

    /**
     * 유저 정보를 보는 페이지
     * @param session 유저 정보의 session id
     * @param model 받아온 유저 정보를 디비에서 꺼내어 보여줌
     * @return  화면 보여줌
     */
    @GetMapping(value = "/profile")
    public String profile(HttpSession session, Model model){
        Member member = (Member) session.getAttribute("login");
        model.addAttribute("member", member);
        return "profile";
    }

    /**
     * 비밀번호 변경
     * @param session 유저 정보
     * @param NewPw 새로운 비밀번호를 받아옴
     * @return  홈페이지로 돌아감
     */
    @PostMapping("/change/pw")
    public String passwordchange(HttpSession session, String NewPw){
        Member login = (Member) session.getAttribute("login");
        us.change(login,NewPw);
        return "redirect:/";
    }

    /**
     * 로그아웃 기능
     * @param session
     * @return 로그아웃 후 바로 로그인
     */
    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
