package com.lhy.service.impl;

import com.lhy.service.pojo.Account;
import com.lhy.service.user.AccountFacade;
import org.springframework.stereotype.Service;

@Service("accountFacade")
public class AccountFacadeImpl implements AccountFacade {


    @Override
    public int addAccount(Account account) {
        return 1;
    }
}
