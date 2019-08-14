package com.sunchong.demo.controller;

import com.sunchong.demo.model.Account;
import com.sunchong.demo.model.Student;
import com.sunchong.demo.service.AccountService;
import com.sunchong.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 多数据源配置测试Controller
 * @Author: sc
 * @CreateDt: 2019-08-13
 */
@RestController
@RequestMapping("/manyConnection")
public class ManyConnectionController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentService studentService;

    @GetMapping("getAccountById")
    public Account getAccountById(Integer id) {
        Account account = accountService.getAccountById(id);
        return account;
    }

    @GetMapping("getStudentById")
    public Student getStudentById(Integer id) {
        Student student = studentService.getStudentById(id);
        return student;
    }
}
