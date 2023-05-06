package com.students.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.students.domain.dto.security.RegistrationUserDTO;
import com.students.interactors.security.UserRegistrationInteractor;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
     private UserRegistrationInteractor userRegistrationInteractor;

     public RegistrationController(UserRegistrationInteractor userRegistrationInteractor) {
          this.userRegistrationInteractor = userRegistrationInteractor;
     }

     @GetMapping("/")
     public String index(Model uiModel) {
          RegistrationUserDTO registrationUserDTO = new RegistrationUserDTO();

          uiModel.addAttribute("user", registrationUserDTO);

          return "pages/security/registration";
     }

     @PostMapping("/")
     public String store(
               @ModelAttribute("user") @Valid RegistrationUserDTO registrationUserDTO,
               BindingResult result,
               Model uiModel) {
          if (result.hasErrors()) {
               uiModel.addAttribute("user", registrationUserDTO);

               return "pages/security/registration";
          }

          this.userRegistrationInteractor.register(registrationUserDTO);

          return "redirect:/login";
     }
}
