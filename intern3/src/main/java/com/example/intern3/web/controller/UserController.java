package com.example.intern3.web.controller;

import com.example.intern3.web.dto.UserDto;
import com.example.intern3.web.service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String main()
    {
        return "home";
    }
    @GetMapping("/join")
    public String signUpForm(@ModelAttribute("userDto") @RequestBody UserDto userDto)
    {
        return "join";
    }
    @PostMapping("/join")
    public String signup(@Valid @ModelAttribute("userDto") @RequestBody UserDto userDto, Model model) {
        model.addAttribute("userDto", userService.signUp(userDto));
        return "redirect:/login";
    }



    @GetMapping("/login")
    public String loginForm(@ModelAttribute("userDto") @RequestBody UserDto userDto) {
        return "/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userDto") @RequestBody UserDto userDto)
    {
        userService.login(userDto.getUserId(),userDto.getUserPw());
        return "redirect:/";
    }

}
