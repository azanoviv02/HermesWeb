package com.hermes.signin;

import com.hermes.hermes.domain.users.UserFactory;
import com.hermes.hermes.infrastructure.dataaccess.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

    private final UserService userService;
    private final UserFactory userFactory;

    @Autowired
    public SigninController(UserService userService, UserFactory userFactory) {
        this.userService = userService;
        this.userFactory = userFactory;
    }

    @RequestMapping(value = "signin")
	public String signin() {
        return "signin/signin";
    }
}
