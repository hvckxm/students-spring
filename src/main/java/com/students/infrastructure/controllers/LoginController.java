package com.students.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.students.domain.dto.security.LoginUserDTO;

@Controller
public class LoginController {
     @GetMapping("/login")
     public String index(Model uiModel) {
          uiModel.addAttribute("user", new LoginUserDTO());

          return "pages/security/login";
     }
}
