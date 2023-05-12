package com.bookstore.Repository;

import com.bookstore.Entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository
        extends JpaRepository<BookStore,Integer> {

}
