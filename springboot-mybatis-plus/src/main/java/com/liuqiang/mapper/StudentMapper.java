package com.liuqiang.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuqianh132
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
