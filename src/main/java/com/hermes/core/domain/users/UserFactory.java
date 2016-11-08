package com.hermes.core.domain.users;

import com.hermes.web.signup.SignupForm;

/**
 * Created by ivan on 05.11.16.
 */
public interface UserFactory {
    AbstractUser createUser(String login, String password, String name, Role role)
            throws LoginAlreadyTakenException, NoSuchRoleException;

    AbstractUser createUser(SignupForm signupForm)
            throws LoginAlreadyTakenException, NoSuchRoleException;
}
