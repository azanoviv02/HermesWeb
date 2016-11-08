package com.hermes.web.signin;

import com.hermes.core.domain.users.UserFactory;
import com.hermes.core.infrastructure.dataaccess.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

    private static final String SIGNIN_VIEW_NAME = "signin/signin";

    private final UserService userService;
    private final UserFactory userFactory;

    @Autowired
    public SigninController(UserService userService, UserFactory userFactory) {
        this.userService = userService;
        this.userFactory = userFactory;
    }

    @RequestMapping(value = "signin")
    public String signin(Model model) {
        model.addAttribute(new SigninForm());
        return SIGNIN_VIEW_NAME;
    }


}
