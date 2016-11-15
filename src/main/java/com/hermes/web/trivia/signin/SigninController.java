package com.hermes.web.trivia.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

    @RequestMapping(value = "signin")
    public String signin() {
        return "signin/signin";
    }

    @RequestMapping(value="secure/userDetail")
    public String studentDetail() {
        if(true){
            throw new IllegalArgumentException();
        }
        //model.addAttribute("students", service.getStudents());
        return "student";
    }
}
