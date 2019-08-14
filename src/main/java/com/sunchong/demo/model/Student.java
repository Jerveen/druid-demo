package com.sunchong.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: Student实体类
 * @Author: xyw
 * @CreateDt: 2019-08-13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String studentName;

    private String studentNo;
}
