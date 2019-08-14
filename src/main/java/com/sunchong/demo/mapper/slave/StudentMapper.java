package com.sunchong.demo.mapper.slave;

import com.sunchong.demo.model.Student;

/**
 * @Description: Student数据操作层
 * @Author: xyw
 * @CreateDt: 2019-08-13
 */
public interface StudentMapper {


    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    Student selectByPrimaryKey(Integer id);
}
