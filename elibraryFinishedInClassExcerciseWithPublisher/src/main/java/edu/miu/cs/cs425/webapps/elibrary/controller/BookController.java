package edu.miu.cs.cs425.webapps.elibrary.controller;

import edu.miu.cs.cs425.webapps.elibrary.model.Book;
import edu.miu.cs.cs425.webapps.elibrary.model.Publisher;
import edu.miu.cs.cs425.webapps.elibrary.service.BookService;
import edu.miu.cs.cs425.webapps.elibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private BookService bookService;

//    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/book/list"})
    public ModelAndView listBooks() {
        var modelAndView = new ModelAndView();
        List<Book> books = bookService.getBooks();
        modelAndView.addObject("book", books);
        modelAndView.setViewName("book/list");
        return modelAndView;
    }

    @GetMapping(value = {"/book/new"})
    public String displayNewBookForm(Model model) {
        List<Publisher> publishers=publisherService.getPublisher();
        model.addAttribute("book", new Book());
        model.addAttribute("publisher",publishers);
        return "book/new";
    }

    @PostMapping(value = {"/book/new"})
    public String addNewBook(@Valid
                             @ModelAttribute("book") Book book,
                             BindingResult bindingResult,
                             Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Publisher> publishers=publisherService.getPublisher();
            model.addAttribute("publisher",publishers);
            return "book/new";
        }
        book = bookService.saveBook(book);
        return "redirect:/book/list";
    }


}
