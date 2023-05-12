package com.bookstore.Repository;

import com.bookstore.Entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository
        extends JpaRepository<MyBookList,Integer> {
}
