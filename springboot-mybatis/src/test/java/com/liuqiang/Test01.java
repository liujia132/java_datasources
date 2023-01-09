package com.liuqiang;

import com.liuqiang.entity.Student;
import com.liuqiang.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {

    @Resource
    private StudentMapper studentMapper;


   @Test
    public void test01(){
       List<Student> allStudent = studentMapper.getAllStudent();
       allStudent.forEach(System.out::println);

   }
}
