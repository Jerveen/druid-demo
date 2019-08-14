package com.sunchong.demo.service.impl;

import com.sunchong.demo.mapper.master.AccountMapper;
import com.sunchong.demo.model.Account;
import com.sunchong.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: Account实现类
 * @Author: xyw
 * @CreateDt: 2019-08-13
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccountById(Integer id) {
        return accountMapper.selectByPrimaryKey(id);
    }
}
