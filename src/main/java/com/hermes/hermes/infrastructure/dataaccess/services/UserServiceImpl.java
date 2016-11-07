package com.hermes.hermes.infrastructure.dataaccess.services;


import com.hermes.hermes.domain.users.AbstractUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<AbstractUser> implements UserService{

    @Autowired
    public UserServiceImpl(GenericRepository<AbstractUser> repository) {
        super(repository);
    }
}
