package pl.dmcs.buarzej.controller;
//wyświetlanie customowej strony logowania

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringSecurityCustomPagesController {

    @RequestMapping(value = "/login")
    public String customLogin(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              Model model) {
        System.out.println("Error: " + (error));
        if (error != null) {//przyszedł parametr błędu
            model.addAttribute("error", "Invalid username or/and password!");
        }

        if (logout != null) {//przyszedł parametr logoutu
            model.addAttribute("msg", "You've been logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {//wyświetlenie widoku accesdenied
        return "accessDenied";
    }
}
