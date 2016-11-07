package com.hermes.hermes.domain.users;

/**
 * Created by ivan on 05.11.16.
 */
public interface UserFactory {
    AbstractUser createUser(String login, String password, String name, Role role);
}
