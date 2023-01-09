package com.liuqiang.mapper;

import com.liuqiang.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liuqianh132
 */
@Mapper
public interface StudentMapper {

    public List<Student> getAllStudent();
}

