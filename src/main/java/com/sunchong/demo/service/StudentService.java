package com.sunchong.demo.service;

import com.sunchong.demo.model.Student;

/**
 * @Description: 学生Service
 * @Author: xyw
 * @CreateDt: 2019-08-13
 */
public interface StudentService {

    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    Student getStudentById(Integer id);
}
