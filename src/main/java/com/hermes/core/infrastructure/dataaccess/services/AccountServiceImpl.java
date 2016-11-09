package com.hermes.core.infrastructure.dataaccess.services;


import com.hermes.core.domain.accounts.AbstractAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends GenericServiceImpl<AbstractAccount> implements AccountService{

    @Autowired
    public AccountServiceImpl(GenericRepository<AbstractAccount> repository) {
        super(repository);
    }
}