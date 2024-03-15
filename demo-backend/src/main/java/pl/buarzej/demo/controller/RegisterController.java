package pl.buarzej.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.buarzej.demo.model.domain.User;
import pl.buarzej.demo.service.UserService;
import pl.buarzej.demo.validator.UserValidator;

import java.security.Principal;

@Controller
public class RegisterController {

    private UserService userService;
    private UserValidator userValidator;

    @Autowired
    public RegisterController(UserService userService,
                              UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/registerUser")
    public String registerUser(/*@Valid*/@ModelAttribute("user") User user, Model model, BindingResult result, Principal principal) {
        userValidator.validate(user, result);
        if (result.getErrorCount() == 0) {
            if (user.getId() == 0) {
                userService.addUserWithFixedRole(user);
            }
        }
        return "home";
    }
}
