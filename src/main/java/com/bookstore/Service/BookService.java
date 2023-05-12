package com.bookstore.Service;

import com.bookstore.Entity.BookStore;
import com.bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public void save(BookStore bookStore){
        repository.save(bookStore);
    }

    public List<BookStore> getAllBooks(){
        return repository.findAll();
    }
    public BookStore getBookById(int id){
         return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
