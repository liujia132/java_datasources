package com.kuang;

import com.kuang.mongodb.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongodbTest {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void contextLoads(){
        Book book = new Book();
        book.setId(10);
        book.setName("JAVA编程思想");
        book.setType("文档类型");
        book.setDescription("JAVA编程思想是一本比较有深度的书，值得相关专业的同学学习");
        mongoTemplate.save(book);
    }
    @Test
    public void test01(){

        List<Book> all = mongoTemplate.findAll(Book.class);
        all.forEach(System.out::println);
    }

}
