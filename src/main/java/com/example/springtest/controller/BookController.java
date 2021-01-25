package com.example.springtest.controller;

import com.example.springtest.pojo.Book;
import com.example.springtest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page - 1, size);
        Page<Book> list = bookRepository.findAll(pageable);
        return list;
    }

    @GetMapping("findAll")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @PostMapping("save")
    public String save(@RequestBody Book book){
        Book save = bookRepository.save(book);
        if(save != null){
            return "success";
        }
        else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book save = bookRepository.save(book);
        if(save != null){
            return "success";
        }
        else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
