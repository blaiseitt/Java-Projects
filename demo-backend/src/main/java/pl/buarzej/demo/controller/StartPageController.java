package pl.buarzej.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class StartPageController {

    @GetMapping(value = "/")
    public String home(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        } else {
            model.addAttribute("username", "Not logged in.");
        }
        return "home";
    }

    @GetMapping(value = "/userList")
    public String userList() {
        return "userList";
    }
}
