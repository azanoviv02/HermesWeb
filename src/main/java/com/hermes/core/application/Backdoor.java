package com.hermes.core.application;

import com.hermes.core.domain.accounts.AccountFactory;
import com.hermes.core.infrastructure.dataaccess.services.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Backdoor {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountService accountService = context.getBean(AccountService.class);
        AccountFactory accountFactory = context.getBean(AccountFactory.class);

//        accountService.add(accountFactory.createAccount("Dudkin", "123", "Pavel Dudkin", Role.ADMIN));
//        accountService.add(accountFactory.createAccount("Gurbatov", "123", "Pavel Gurbatov", Role.DRIVER));
//        accountService.add(accountFactory.createAccount("Kireev", "123", "Pavel Kireev", Role.MANAGER));
//        accountService.add(accountFactory.createAccount("FYL", "123", "Pavel Fyl", Role.PLANNER));
//        accountService.add(accountFactory.createAccount("Azanov", "123", "Pavel Fyl", Role.INFORMER));
    }
}
