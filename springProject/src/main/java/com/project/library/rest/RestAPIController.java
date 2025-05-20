package com.project.library.rest;

import com.project.library.dao.Book;
import com.project.library.dao.BookHolder;
import com.project.library.dto.BookDTO;
import com.project.library.dto.BookHolderDTO;
import com.project.library.services.BookHolderService;
import com.project.library.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
* Так как приложение написано в архитектуре mvc, то нет смысла писать логику всех методов в rest контроллере.
* Для демонстрации работы передачи данных из mvc контроллера в rest использовал две операции.
 */
@RestController
@RequestMapping("/api")
public class RestAPIController {
    private BookHolderService bookHolderService;
    private BookService bookService;

    @Autowired
    public RestAPIController(BookHolderService bookHolderService, BookService bookService) {
        this.bookHolderService = bookHolderService;
        this.bookService = bookService;
    }

    @PostMapping(value = "/regHolder")
    @Operation(description = "Регистрирует нового держателя в библиотеке")
    public ResponseEntity<BookHolder> createAndSaveBookHolder(@RequestBody BookHolderDTO bookHolderDTO) {
       return ResponseEntity.ok(bookHolderService.createAndSaveBookHolder(bookHolderDTO));
    }

    @PostMapping("regBook")
    @Operation(description = "Регистрирует новую книгу в библиотеке")
    public ResponseEntity<Book> createAndSaveBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.createAndSaveBook(bookDTO));
    }
}
