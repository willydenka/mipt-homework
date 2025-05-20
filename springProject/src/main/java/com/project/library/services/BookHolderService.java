package com.project.library.services;

import com.project.library.dao.Book;
import com.project.library.dao.BookHolder;
import com.project.library.dto.BookHolderDTO;
import com.project.library.repositories.BookHolderRepository;
import com.project.library.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
* Бизнес-логика сущности BookHolder. Манипулирует данными.
 */
@Service
public class BookHolderService {
    private BookHolderRepository bookHolderRepository;
    private BookRepository bookRepository;

    @Autowired
    public BookHolderService(BookHolderRepository bookHolderRepository, BookRepository bookRepository) {
        this.bookHolderRepository = bookHolderRepository;
        this.bookRepository = bookRepository;
    }

    public void saveBookHolder(BookHolder bookHolder) {
        bookHolderRepository.save(bookHolder);
    }

    public void deleteById(int id) {
        bookHolderRepository.deleteById(id);
    }

    public List<BookHolder> getAllBookHolders() {
        return bookHolderRepository.findAllByOrderByName();
    }

    public BookHolder getBookHolderById(int id) {
        return bookHolderRepository.findById(id).orElse(null);
    }

    public BookHolder createAndSaveBookHolder(BookHolderDTO bookHolderDTO) {
        BookHolder bookHolder = new BookHolder();
        bookHolder.setName(bookHolderDTO.getName());
        bookHolder.setSurname(bookHolderDTO.getSurname());
        bookHolder.setPatronymic(bookHolderDTO.getPatronymic());
        bookHolder.setBirthdate(bookHolderDTO.getBirthdate());
        return bookHolderRepository.save(bookHolder);
    }

    @Transactional
    public void addBook(int bookHolderId, int bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new EntityNotFoundException("Такой книги в БД не найдено"));
        BookHolder bookHolder = bookHolderRepository.findById(bookHolderId).orElseThrow(()->
                new EntityNotFoundException("Такого держалеля в БД не найдено"));
        bookHolder.addBook(book);
        bookHolderRepository.save(bookHolder);
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
