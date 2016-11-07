package com.hermes.hermes.infrastructure.dataaccess.services;


import com.hermes.hermes.domain.users.AbstractUser;

public class UserServiceImpl extends GenericServiceImpl<AbstractUser> implements UserService{
    public UserServiceImpl(GenericRepository<AbstractUser> repository) {
        super(repository);
    }
}
