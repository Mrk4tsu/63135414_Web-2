package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping("/home")
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/about")
    public String showAboutPage(){
        return "about";
    }
}
