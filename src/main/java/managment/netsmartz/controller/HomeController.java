package managment.netsmartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/forget")
    public String forget(){
        return "forget";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
