package com.example.todo.controller;

import com.example.todo.model.User;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }    @GetMapping("/sw.js")
    public String loginPageRedirect() {
        return "redirect:/";
    }


    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute("user") User user) {
        userService.registerUser(user);
        return "redirect:/login"; // Redirect to the login page after successful registration
    }
}

