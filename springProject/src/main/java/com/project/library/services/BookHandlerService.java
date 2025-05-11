package com.project.library.services;

import com.project.library.dao.Book;
import com.project.library.dao.BookHandler;
import com.project.library.repositories.interfaces.BookHandlerRepository;
import com.project.library.repositories.interfaces.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
* Бизнес-логика сущности BookHandler. Манипулирует данными.
 */
@Service
public class BookHandlerService {
    private BookHandlerRepository bookHandlerRepository;
    private BookRepository bookRepository;

    @Autowired
    public BookHandlerService(BookHandlerRepository bookHandlerRepository, BookRepository bookRepository) {
        this.bookHandlerRepository = bookHandlerRepository;
        this.bookRepository = bookRepository;
    }

    public void saveBookHandler(BookHandler bookHandler) {
        bookHandlerRepository.save(bookHandler);
    }

    public BookHandler getBookHandlerById(int id) {
        return bookHandlerRepository.findById(id).orElse(null); // TODO вернуть валидное значение
    }

    @Transactional
    public void addBook(int bookHandlerId, int bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new IllegalArgumentException("Такой книги в БД не найдено")); // TODO свое исключение
        BookHandler bookHandler = bookHandlerRepository.findById(bookHandlerId).orElseThrow(()->
                new IllegalArgumentException("Такого держалеля в БД не найдено")); // TODO свое исключение

        book.setBookHandler(bookHandler);
        bookHandler.addBook(book);
        bookRepository.save(book);
        bookHandlerRepository.save(bookHandler);
        System.out.println(bookHandlerRepository.findById(1).get().getBooks());
        System.out.println(bookRepository.findById(1).get().getBookHandler());
    }

}
