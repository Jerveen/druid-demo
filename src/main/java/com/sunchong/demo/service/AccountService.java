package com.sunchong.demo.service;

import com.sunchong.demo.model.Account;

/**
 * @Description: 用户Service
 * @Author: xyw
 * @CreateDt: 2019-08-13
 */
public interface AccountService {

    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    Account getAccountById(Integer id);
}
