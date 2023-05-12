package com.bookstore.Controller;

import com.bookstore.Entity.BookStore;
import com.bookstore.Entity.MyBookList;
import com.bookstore.Service.BookService;
import com.bookstore.Service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    @Autowired
    private MyBookService myBookService;

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {

        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<BookStore> bookStoreList = service.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookList");
        modelAndView.addObject("bookStore", bookStoreList);
        return new ModelAndView("bookList", "bookStore", bookStoreList);
    }

    @GetMapping("/my_books")
    public ModelAndView getAllMyBooks() {
        List<MyBookList> mybookStoreList = myBookService.getAllMyBooks();
        ModelAndView mymodelAndView = new ModelAndView();
        mymodelAndView.setViewName("myBooks");
        mymodelAndView.addObject("MyBookList", mybookStoreList);
        return new ModelAndView("myBooks", "MyBookList", mybookStoreList);
    }

    /*@GetMapping("/my_books")
    public String getAllMyBooks(Model model){
        List<MyBookList> this_myBookList = myBookService.getAllMyBooks();
        model.addAttribute("bookStore",this_myBookList);
        return "myBooks";
    }*/

    @PostMapping("/save")
    public String addBook(@ModelAttribute BookStore bookStore) {
        service.save(bookStore);
        return "redirect:/available_books";
    }


    @RequestMapping("/my_books/{id}")
    public String getMyList(@PathVariable("id") int id) {
        BookStore bookStore = service.getBookById(id);
        MyBookList myBookList = new MyBookList(bookStore.getId(), bookStore.getName(), bookStore.getAuthor(), bookStore.getPrice());
        myBookService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id")int id, Model model){
        BookStore anotherbookStore = service.getBookById(id);
        model.addAttribute("bookStore",anotherbookStore);
        return"bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }

    @GetMapping("/coming_soon")
    public String comingSoon() {

        return "comingSoon";
    }
}
