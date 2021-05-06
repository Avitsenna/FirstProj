package ru.back.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }


    @RequestMapping("/error")//просто ссылка к ошибке, неважно какой
    public String handleError(HttpServletRequest request) {
        return "error";
    }
}
