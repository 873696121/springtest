package com.example.springtest.repository;

import com.example.springtest.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
