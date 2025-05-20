package com.project.library.services;

import com.project.library.dao.Book;
import com.project.library.dao.BookHolder;
import com.project.library.dto.BookDTO;
import com.project.library.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAllByOrderByTitle();
    }

    @Transactional(readOnly = true)
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void detachBookFromHolder(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null && book.getBookHolder() != null) {
            BookHolder bookHolder = book.getBookHolder();
            bookHolder.removeBook(book);
            bookRepository.save(book);
        } else throw new EntityNotFoundException("Объекта с таким id в базе данных нет");
    }

    public Book createAndSaveBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthorName(bookDTO.getAuthorName());
        book.setYearOfProduction(bookDTO.getYearOfProduction());
        return bookRepository.save(book);
    }

    /*
     * Метод перенаправления данных в rest.
     */
    public <T, V> ResponseEntity<V> sendToRest(String suffix, T dto, Class<V> response) {
        String urlApi = "http://localhost:8080/api" + suffix;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(urlApi, new HttpEntity<>(dto, headers), response);
    }
}
