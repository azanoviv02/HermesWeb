package com.hermes.core.domain.users;


import com.hermes.web.signup.SignupForm;
import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.employees.EmployeeFactory;
import com.hermes.core.infrastructure.dataaccess.services.UserService;
import com.hermes.core.infrastructure.dataaccess.specifications.users.UserWhich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ivan on 02.11.16.
 */
@Component
public class UserFactoryImpl implements UserFactory {

    private final EmployeeFactory employeeFactory;
    private final UserService userService;
    private final UserWhich userWhich;

    @Autowired
    public UserFactoryImpl(EmployeeFactory employeeFactory, UserService userService, UserWhich userWhich) {
        this.employeeFactory = employeeFactory;
        this.userService = userService;
        this.userWhich = userWhich;
    }

    @Override
    public AbstractUser createUser(String login, String password, String name, Role role)
            throws LoginAlreadyTakenException{

        List<AbstractUser> possibleCollisions = userService.getEvery(userWhich.hasLogin(login));

        if(possibleCollisions.isEmpty() == false){
            throw new LoginAlreadyTakenException();
        }

        switch (role){
            case ADMIN:
            case MANAGER:
            case PLANNER:
            case INFORMER:
                return new BasicUser(login, password, name, role);
            case DRIVER:
                AbstractEmployee representation = employeeFactory.createBasicDriver(name);
                return new RepresentedUser(login, password, name, role, representation);
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public AbstractUser createUser(SignupForm signupForm)
            throws LoginAlreadyTakenException, NoSuchRoleException{

        Role role = null;

        switch (signupForm.getRole().toLowerCase()){
            case "admin":
                role = Role.ADMIN;
                break;
            case "manager":
                role = Role.MANAGER;
                break;
            case "driver":
                role = Role.DRIVER;
                break;
            case "informer":
                role = Role.PLANNER;
                break;
            case "planner":
                role = Role.INFORMER;
                break;
            default:
                throw new NoSuchRoleException();
        }

        return createUser(
                signupForm.getLogin(),
                signupForm.getPassword(),
                signupForm.getName(),
                role);
    }
}
