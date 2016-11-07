package com.hermes.signin;

import com.hermes.hermes.infrastructure.dataaccess.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

    @Autowired
    UserService userService;

	@RequestMapping(value = "signin")
	public String signin() {
        return "signin/signin";
    }
}
