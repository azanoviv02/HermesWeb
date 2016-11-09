package com.hermes.core.infrastructure.dataaccess.specifications.accounts;


import com.hermes.core.domain.accounts.AbstractAccount;
import com.hermes.core.domain.accounts.Role;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractWhich;
import com.hermes.core.infrastructure.dataaccess.specifications.Specification;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 02.11.16.
 */
@Component
public class AccountWhich extends AbstractWhich<AbstractAccount> {

    public AccountWhich() {
    }

    public Specification<AbstractAccount> hasLogin(String login){
        return new HasLogin(login);
    }

    public Specification<AbstractAccount> hasRole(Role role){
        return new HasRole(role);
    }

    public Specification<AbstractAccount> isAdmin(){
        return new HasRole(Role.ADMIN);
    }

    public Specification<AbstractAccount> isDriver(){
        return new HasRole(Role.DRIVER);
    }

    public Specification<AbstractAccount> isManager(){
        return new HasRole(Role.MANAGER);
    }

    public Specification<AbstractAccount> isPlanner(){
        return new HasRole(Role.PLANNER);
    }

    public Specification<AbstractAccount> isInformer(){
        return new HasRole(Role.INFORMER);
    }
}
