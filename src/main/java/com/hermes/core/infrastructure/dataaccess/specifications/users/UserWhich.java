package com.hermes.core.infrastructure.dataaccess.specifications.users;


import com.hermes.core.domain.users.AbstractUser;
import com.hermes.core.domain.users.Role;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractWhich;
import com.hermes.core.infrastructure.dataaccess.specifications.Specification;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 02.11.16.
 */
@Component
public class UserWhich extends AbstractWhich<AbstractUser> {

    public UserWhich() {
    }

    public Specification<AbstractUser> hasLogin(String login){
        return new hasLogin(login);
    }

    public Specification<AbstractUser> hasRole(Role role){
        return new hasRole(role);
    }

    public Specification<AbstractUser> isAdmin(){
        return new hasRole(Role.ADMIN);
    }

    public Specification<AbstractUser> isDriver(){
        return new hasRole(Role.DRIVER);
    }

    public Specification<AbstractUser> isManager(){
        return new hasRole(Role.MANAGER);
    }

    public Specification<AbstractUser> isPlanner(){
        return new hasRole(Role.PLANNER);
    }

    public Specification<AbstractUser> isInformer(){
        return new hasRole(Role.INFORMER);
    }
}
