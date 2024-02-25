package pl.buarzej.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartPageController {

    @GetMapping("/")
    public String startPage() {
        return "tu na razie jest ściernisko";

        //
    }
}
