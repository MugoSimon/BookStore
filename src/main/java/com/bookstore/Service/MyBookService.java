package com.bookstore.Service;

import com.bookstore.Entity.MyBookList;
import com.bookstore.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private final MyBookRepository myBookRepository;

    public MyBookService(MyBookRepository this_repository) {
        this.myBookRepository = this_repository;
    }

    public void saveMyBooks(MyBookList myBookList) {
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBookRepository.findAll();
    }

    public void deleteById(int id) {
        myBookRepository.deleteById(id);
    }
}
