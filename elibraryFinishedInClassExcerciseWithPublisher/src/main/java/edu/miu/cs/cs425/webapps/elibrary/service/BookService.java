package edu.miu.cs.cs425.webapps.elibrary.service;

import edu.miu.cs.cs425.webapps.elibrary.model.Book;

import java.util.List;

public interface BookService {

    public abstract List<Book> getBooks();
    public abstract Book saveBook(Book book);


}
