package com.hermes.core.domain.accounts;


import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.employees.EmployeeFactory;
import com.hermes.core.infrastructure.dataaccess.services.AccountService;
import com.hermes.core.infrastructure.dataaccess.specifications.accounts.AccountWhich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ivan on 02.11.16.
 */
@Component
public class AccountFactoryImpl implements AccountFactory {

    private final EmployeeFactory employeeFactory;
    private final AccountService accountService;
    private final AccountWhich accountWhich;

    @Autowired
    public AccountFactoryImpl(EmployeeFactory employeeFactory, AccountService accountService, AccountWhich accountWhich) {
        this.employeeFactory = employeeFactory;
        this.accountService = accountService;
        this.accountWhich = accountWhich;
    }

    @Override
    public AbstractAccount createAccount(String login, String password, String name, Role role)
            throws LoginAlreadyTakenException{

        List<AbstractAccount> possibleCollisions = accountService.getEvery(accountWhich.hasLogin(login));

        if(possibleCollisions.isEmpty() == false){
            throw new LoginAlreadyTakenException();
        }

        switch (role){
            case ADMIN:
            case MANAGER:
            case PLANNER:
            case INFORMER:
                return new BasicAccount(login, password, name, role);
            case DRIVER:
                AbstractEmployee representation = employeeFactory.createBasicDriver(name);
                return new RepresentedAccount(login, password, name, role, representation);
            default:
                throw new IllegalStateException();
        }
    }
}
