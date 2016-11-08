package com.hermes.core.infrastructure.dataaccess.services;


import com.hermes.core.domain.users.AbstractUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<AbstractUser> {

    @Autowired
    public UserServiceImpl(GenericRepository<AbstractUser> repository) {
        super(repository);
    }
}
