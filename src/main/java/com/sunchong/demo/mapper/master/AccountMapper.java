package com.sunchong.demo.mapper.master;

import com.sunchong.demo.model.Account;

/**
 * @Description: Account数据操作层
 * @Author: sc
 * @CreateDt: 2019-08-13
 */
public interface AccountMapper {

    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    Account selectByPrimaryKey(Integer id);
}
