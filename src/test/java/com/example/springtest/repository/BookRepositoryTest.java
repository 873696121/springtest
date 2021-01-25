package com.example.springtest.repository;

import com.example.springtest.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void findAll(){
        List<Book> all = bookRepository.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }

    @Test
    void save(){
        Book book = new Book();
        book.setName("java");
        book.setAuthor("huhong");
        bookRepository.save(book);
    }

    @Test
    void findById(){
        Book book = bookRepository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(131);
        book.setName("JAVA");
        this.bookRepository.save(book);
    }

    @Test
    void delete(){
        bookRepository.deleteById(131);
    }

}