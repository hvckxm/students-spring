package com.students.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/{user}/marks")
public class MarkController {
    public String create(Model model) {
        return "";
    }
}
