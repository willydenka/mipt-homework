package com.project.library.services;

import com.project.library.dao.Book;
import com.project.library.repositories.interfaces.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
* Бизнес-логика сущности Book. Манипулирует данными.
 */
@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null); // TODO вернуть валидное значение
    }
}
