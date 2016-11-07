package com.hermes.hermes.application.states;


import com.hermes.hermes.domain.users.AbstractUser;
import com.hermes.hermes.domain.users.InvalidPasswordException;
import com.hermes.hermes.domain.users.RepresentedUser;
import com.hermes.hermes.infrastructure.dataaccess.services.UserService;
import com.hermes.hermes.infrastructure.dataaccess.specifications.users.UserWhich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

/**
 * Created by ivan on 01.11.16.
 */
@Component
class UserStateFactory {

    private final UserService userService;
    private final AdminState adminState;
    private final DriverState driverState;
    private final ManagerState managerState;
    private final InformerState informerState;
    private final PlannerState plannerState;
    private final UserWhich userWhich;

    @Autowired
    public UserStateFactory(UserService userService,
                            AdminState adminState,
                            DriverState driverState,
                            ManagerState managerState,
                            InformerState informerState,
                            PlannerState plannerState,
                            UserWhich userWhich) {
        this.userService = userService;
        this.adminState = adminState;
        this.driverState = driverState;
        this.managerState = managerState;
        this.informerState = informerState;
        this.plannerState = plannerState;
        this.userWhich = userWhich;
    }

    AbstractUserState createUserState(String login, String password) throws NoSuchLoginException, InvalidPasswordException {
        try {
            AbstractUser user = userService.getOne(userWhich.hasLogin(login));
            user.checkPassword(password);
            switch(user.getRole()){
                case ADMIN:
                    adminState.setCurrentUser(user);
                    return adminState;
                case DRIVER:
                    if(user instanceof RepresentedUser){
                        driverState.setCurrentUser(user);
                        return driverState;
                    }else{
                        throw new IllegalStateException();
                    }
                case MANAGER:
                    managerState.setCurrentUser(user);
                    return managerState;
                case PLANNER:
                    plannerState.setCurrentUser(user);
                    return plannerState;
                case INFORMER:
                    informerState.setCurrentUser(user);
                    return informerState;
                default:
                    throw new IllegalStateException();
            }
        }catch (NoResultException nre){
            throw new NoSuchLoginException();
        }
    }
}
