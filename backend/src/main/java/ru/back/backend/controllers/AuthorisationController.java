package ru.back.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class AuthorisationController {
    @Controller
    @RequestMapping("/auth")
    public class AuthController {

        @GetMapping("/login")
        public String loginPage() {
            return "login";//login страница
        }

        @GetMapping("/logout")
        public String logoutPage() {
            return "logout";
        }//страница для выхода, возможно удалю
    }
}
