package pl.buarzej.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }
}
