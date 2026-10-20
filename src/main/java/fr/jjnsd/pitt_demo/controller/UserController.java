package fr.jjnsd.pitt_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/test")
    public String index()
    {
        return "Hello World!";
    }
}
