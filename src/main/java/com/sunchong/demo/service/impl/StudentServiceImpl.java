package com.sunchong.demo.service.impl;

import com.sunchong.demo.mapper.slave.StudentMapper;
import com.sunchong.demo.model.Student;
import com.sunchong.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: Student实现类
 * @Author: sc
 * @CreateDt: 2019-08-13
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
