package com.softserve.edu.webproject.service;

import com.softserve.edu.webproject.entity.Account;

public interface AccountService {
    Account findAccountByUsername(String userName);
}
