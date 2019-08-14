package com.sunchong.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: Account实体类
 * @Author: sc
 * @CreateDt: 2019-08-13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;

    private String accountName;

    private String accountPassword;

    private String idNo;
}
