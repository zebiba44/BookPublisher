package edu.miu.cs.cs425.webapps.elibrary.service.impl;

import edu.miu.cs.cs425.webapps.elibrary.model.Book;
import edu.miu.cs.cs425.webapps.elibrary.repository.BookRepository;
import edu.miu.cs.cs425.webapps.elibrary.service.BookService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll(Sort.by("title"));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


}
