package com.hermes.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ivan on 09.11.16.
 */
@Controller
public class AccountController {

    @RequestMapping(value = "/secure/account")
    public String account() {
        return "account/account";
    }

//    @RequestMapping(value="secure/userDetail")
//    public String studentDetail() {
//        if(true){
//            throw new IllegalArgumentException();
//        }
//        //model.addAttribute("students", service.getStudents());
//        return "student";
//    }
}
