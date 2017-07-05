package com.softserve.edu.webproject.service.impl;

import com.softserve.edu.webproject.entity.Account;
import com.softserve.edu.webproject.repository.AccountRepository;
import com.softserve.edu.webproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.softserve.edu.webproject.repository.AccountRepository.Expressions.*;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRep;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRep) {
        this.accountRep = accountRep;
    }

    public Account findAccountByUsername(String userName) {
        return (Account) accountRep.findOne(getByUsername(userName).and(getByActive(true)));
    }
}
